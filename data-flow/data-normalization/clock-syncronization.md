# Clock Synchronization

Calculates an adjustment which, when added to a timestamp in the WITSML data, should return the real-world time in which it actually happened, even if the source's clock is not synchronized.

This algorithm makes the following assumptions:

* The collector always reads until the end of the data sequence, that is, the store is conceptually "empty";
* The source inserts data into the store in real time or almost in real time;
* The source's clock is wrong by a slowly changing offset;
* The source's clock is not too wrong since if it were too wrong, the collector would fail to grab the data;
* The collector's clock is correct.

Under these assumptions, any new data since the last read from the store was generated after the last read, and before the current read. That is, the correct timestamp for the new data should lie in the interval between last read's correct timestamp, and current read's correct timestamp.

This algorithm computes a pair of intervals:

* The source interval, which is between the first and last events received from the source;
* The target interval, which is between the last query and this query to the store.

It arbitrarily picks a point in both intervals and computes the offset between their timestamps. This offset, when added to a timestamp from the source, should result in the corresponding timestamp from the collector.

Since the chosen point is only a guess, the result has an error which varies from sample to sample. To present a more stable result, the offset is smoothed by an EWMA filter.\
