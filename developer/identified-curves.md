# Identified Curves

## How to identify new curves

{% hint style="info" %}
Your project must have plugin-liverig as a maven dependency.
{% endhint %}

```java
<dependency>
    <groupId>net.intelie.live</groupId>
    <artifactId>plugin-liverig</artifactId>
    <version>${project.version}</version>
    <scope>provided</scope>
</dependency>
```

```java
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    ...
    <configuration>
        <archive>
            <manifestEntries>
            ...
                <requirePlugins>
                    plugin-liverig@${liverig-api-version}
                </requirePlugins>
            </manifestEntries>
        </archive>
    </configuration>
</plugin>
```

There are two ways to register identified curves via back-end API using the `CurveIdentifierService`.\
First, you need to get the service instance.

{% code title="my-plugin/Main.java" %}
```java
CurveIdentifierService curvesService = live.system().getPluginService(CurveIdentifierService.class)
```
{% endcode %}

The first way, you can create a standard curve from the `CurveIdentifierService`, so, your identifier curve will be registered on the standard curves page.\


```java
CurveIdentifierService.register(live, ImmutableMap.of("myChannelName", new CurveIdentifierService.IdentifiedChannel("My Channel", "MyChannelKey", "unit", "color")));
```

The second way is to create just one identifier curve.

```java
curveIdentifierService.register(live, ImmutableMap.of("myChannelName", new CurveIdentifierService.IdentifiedChannel("My Channel", "MyChannelKey", "unit")));
```

Then, you will then be able to finish configuring the standard curves page.

## Curve name conflicts

Curve conflicts are ignored but counted. If a Curve is registered once, it cannot be overwritten by a new `register` call. Additional calls only increment a counter. This way the service can keep track of which identifiers are still in use, and remove those that are not (done automatically whenever all identifier register callers are unloaded).
