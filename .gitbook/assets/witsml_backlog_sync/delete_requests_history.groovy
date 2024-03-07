import java.util.Arrays
import java.util.stream.Stream
import net.intelie.live.StorageQuery
import net.intelie.live.StorageQueryOptions
import net.intelie.live.EventIterator
import net.intelie.pipes.MapPropertySource
import net.intelie.pipes.PropertyGroup
import net.intelie.pipes.filters.Filter
import net.intelie.pipes.filters.Segment
import net.intelie.pipes.filters.TermFilter

// fill the parents with the parent UUIDs to be removed
String[] parents = ["PARENT1_UUID", "PARENT2_UUID"]

childRequestEventType = "__witsml_remote_request_sync__"
parentRequestEventType = "__witsml_remote_request_sync_batch__"

Arrays.stream(parents).forEach { parentUID -> 
  log("Removing events with parentUID: %s", parentUID)

  filter = new TermFilter(new PropertyGroup(new MapPropertySource().property("parentUID")), new Segment.Literal(parentUID))

  Stream.of(childRequestEventType, parentRequestEventType).forEach { eventType ->
    query = new StorageQuery(eventType).withWhere(filter)
    count = live.engine().getMainStorage().delete(query, 0, live.time().clock().now())
    log("Event type: %s Removed events: %d", eventType, count)            
  }
  
  log("-"*100)
}      
