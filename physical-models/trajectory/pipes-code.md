# Pipes Functions

### **Dogleg**

![Dogleg vs Measured Depth](https://lh3.googleusercontent.com/mP\_YcomL5ggJRvLlUxpCBpxmVcjgixypuSYdUSDhdWlTT6KMIus5th1oUDbDLLihZSpRZ4AtNqmX3g1CrCneG1aPsx0kwqdFLw2dgUGOnW3Fr1S1jNvzCWWFJP4F1gqA3X9l0yMW)

Computes dogleg on every trajectory section

```javascript
og.model.minimumCurvature.doglegMap(
         newmap("wellId", "{well_id}")
)
```

**Output: Doglegs (rad) vs MD**

### Dogleg Delta

```javascript
og.model.minimumCurvature.dogleg( 
        newmap("startDepth" value_m, 
               "startInclination", value_rad, 
               "startAzimuth", value_rad, 
               "endDepth", value_m, 
               "endInclination", value_rad,
               "endAzimuth", value_rad)
 ) 
```

**Output: Dogleg (rad)**

**Example Pipes:**

```javascript
og.model.minimumCurvature.doglegMap(
         newmap("wellId", "{well_id}")
)
```

### **Dogleg Severity**

![Dogleg Severity vs Measured Depth](https://lh5.googleusercontent.com/6FsVL3MvKoaErMgLLqbSn27-KG57tK0EYcdxYHmnVnfkIl4NpcHtzG5R7TZv0zA3HkA5URHn0kpHVpiimNVOE\_Mo5MwL0YtILgsLZP8oU6kzUKM4jwYn8j\_GC6bwgPyLgpyR25zH)

Computes dogleg severity on every trajectory section

```javascript
og.model.minimumCurvature.doglegSeverityMap(
         newmap("wellId", "{well_id}")
)
```

**Output: Dogleg Severity (rad/m) vs MD**&#x20;

```javascript
og.model.minimumCurvature.doglegSeverity( 
        newmap("startDepth" value_m, 
               "startInclination", value_rad, 
               "startAzimuth", value_rad, 
               "endDepth", value_m, 
               "endInclination", value_rad,
               "endAzimuth", value_rad)
 )
```

**Output: Dogleg Severity (rad/m)**

### **Computes ratio factor on every trajectory section**

```javascript
og.model.minimumCurvature.ratioFactorMap(
         newmap("wellId", "{well_id}")
)
```

**Output: Ratio Factor (-) vs MD**&#x20;

**Example Pipes:**

```javascript
=> og.model.minimumCurvature.severityMap(newmap("wellId", "5"))) at the end 
=> @for 
=> @yield 
=> {doglegSeverity}#*180/pi()*30  as DLS(degree/100ft), depth# as depth
```

## **North and East**

![3D plot (North, East, and TVD)](https://lh3.googleusercontent.com/Rx\_C09eVq7zfCwNFXfb6qQBKum8\_v6A\_InOExFVSWj6bnc8H-hlgGPM5zZ2FnXr0ukXA4l8-L8zdLtgUv41QcM1mV0Yl-FXwKQaKDatsQ6RWeVxhjdm229aVpsUnnW5-k1dGSwqu)

![North vs East](https://lh4.googleusercontent.com/AD9bI6Pv4u\_Mi7i2gLNAs3wiLzwbO9PjmwzaX39OKYeuE\_WO1kX32uS5X-8Iuap2cGzbtpz7j5uSqzZ3hftEdR8Wfk7EH\_ZwdeejlXfVc3cCavi4s\_aywXMJn7\_SYOlTahfhRPQy)

Computes north coordinate on every trajectory section

### Easting Map

```javascript
og.model.minimumCurvature.northingMap(
         newmap("wellId", "{well_id}")
)
```

**Output: North (m) vs MD(m)**

### North Delta

```javascript
og.model.minimumCurvature.northDelta(
        newmap("startDepth" value_m, 
               "startInclination", value_rad, 
               "startAzimuth", value_rad, 
               "endDepth", value_m, 
               "endInclination", value_rad,
               "endAzimuth", value_rad)
)
```

### Easting Map

Computes east coordinate on every trajectory section

```javascript
og.model.minimumCurvature.eastingMap(
         newmap("wellId", "{well_id}")
)
```

**Output: East (m) vs MD(m)**

### **East Delta**

```javascript
og.model.minimumCurvature.eastDelta(        
        newmap("startDepth" value_m, 
               "startInclination", value_rad, 
               "startAzimuth", value_rad, 
               "endDepth", value_m, 
               "endInclination", value_rad,
               "endAzimuth", value_rad)
 )
```

![Horizontal Displacement vs TVD](https://lh4.googleusercontent.com/GMQkf4eOtpzIFwtKA92hBXr1PFyhNVsg5G5DAtyWE4XL0pEja-9acmkdhHIH9rLjJM4MuZXAB5f4O3xJTSxYRhrgIxXPalT36\_tK5GSED5Gkg-bbr2l8g9eTIAvhEFmYnHqwq05e)

### **True Vertical Depth**

**Computes true vertical depth on every trajectory section**

```javascript
og.model.minimumCurvature.tvdMap(
         newmap("wellId", "{well_id}")
)
```

**Output: True Vertical Depth (m) vs MD(m)**\


### **TVD Delta**

```javascript
og.model.minimumCurvature.tvdDelta(        
        newmap("startDepth" value_m, 
               "startInclination", value_rad, 
               "startAzimuth", value_rad, 
               "endDepth", value_m, 
               "endInclination", value_rad,
               "endAzimuth", value_rad)
 )
```

### **Horizontal Displacement**&#x20;

**Computes horizontal displacement on every trajectory section**

```javascript
og.model.minimumCurvature.horizontalDisplacementMap(
         newmap("wellId", "{well_id}")
)
```

**Output: Horizontal Displacement (m) vs MD(m)**

### **Minimum Distance between target Line**

![](https://lh3.googleusercontent.com/9B4PMcpmsBYLCfaFHJButLLLgyCCe-avEb0XinVmnCE5Vtp\_LBawNKcF2f-EyoMbi7WBpAGUieCor5waxvsfxGfTSNxqcade0DC6LD5XoZ-MqsiyyZre\_\_AxL3ALMTF402HhASuj)

**Pipes Example**

```javascript
=> og.model.minimumCurvature.distanceToTargetLine(
      newmap("targetAngle", 0.785398, "targetLine", newmap("tvd", 1000, "verticalSection", 0, "inclination", 1.5708),  "point", newmap("north", 100, "east", 1000, "tvd", 1000)
))->result as result at the end
```

**Pipes Example**

```javascript
=> og.model.minimumCurvature.distanceToTargetPlane(
       newmap("targetAngle", 0.785398,  "point", newmap("north", 1000, "east", 0)
))->result as result at the end
```

### **Build Rate**

```javascript
og.model.minimumCurvature.buildRate(        
        newmap("startDepth" value_m, 
               "startInclination", value_rad, 
               "endDepth", value_m, 
               "endInclination", value_rad)
 )
```

### Turn Rate

```javascript
og.model.minimumCurvature.turnRate(
        newmap("startDepth" value_m, 
               "startAzimuth", value_rad, 
               "endDepth", value_m, 
               "endAzimuth", value_rad)
 )
```

### **Delta Azimuth**

```javascript
og.model.minimumCurvature.deltaAzimuth(
        newmap("startInclination", value_rad, 
               "dogleg", value_rad, 
               "toolFace", value_rad)
 )
```

### End Inclination

```javascript
og.model.minimumCurvature.endInclination(
        newmap("startInclination", value_rad, 
               "endInclination", value_rad,
               "dogleg", value_rad)
 )
```

### **Tool Face**&#x20;

```javascript
og.model.minimumCurvature.toolface(
         newmap("startDepth" value_m, 
               "startInclination", value_rad, 
               "startAzimuth", value_rad, 
               "endDepth", value_m, 
               "endInclination", value_rad,
               "endAzimuth", value_rad)
)
```

### **Trajectory Distance**

```javascript
og.model.minimumCurvature.trajectoryDistance(
        newmap("wellId", "{well_id}",
               "north" value_m, 
               "east", value_rad, 
               "tvd", value_rad)
)
```

```javascript
og.model.minimumCurvature.trajectoryDistanceMap(
         newmap("wellId", "{well_id}"
                "bitDepth", value_m, 
                newmap( "point", 
                       newmap("measuredDepth", value_m,
                              "north", value_m,
                              "east", value_m, 
                              "tvd", value_m))
                )
)
```

### **Vertical Section**

```javascript
og.model.minimumCurvature.verticalSection(
        newmap("north" value_m, 
               "east", value_rad, 
               "targetAngle", value_rad)
 )
```

```javascript
og.model.minimumCurvature.verticalSectionMap(
         newmap("wellId", "{well_id}",
                "targetAngle", value_rad)
)
```

### Survey from Directional Parameters

Calculate the survey points from the section lengths, build rate, and turn rate.&#x20;

```javascript
og.model.minimumCurvature.surveyFromDirectionalSections(
     newmap("points", 
          newmap("sectionLength", value_m, "buildRate", value_rad/m, "turnRate", value_rad/m),
          newmap("sectionLength", value_m, "buildRate", value_rad/m, "turnRate", value_rad/m)
     )
)
```

Example

Well Type II&#x20;

```javascript
def @@KOP: 1000; --m
def @@BuildUp: 12/100; --rad/m
def @@endBuildup: 1200; --m
def @@slantSection: 100; --/m
def @@dropOff: -12/100; --//rad/m
def @@endDropOff: 1500; --//rad/m

def @@points: (

  newmap("sectionLength", @@KOP, "buildRate", 0, "turnRate", 0.0),
  newmap("sectionLength", @@endBuildup - @@KOP, "buildRate", @@BuildUp, "turnRate", 0.0),
  newmap("sectionLength", @@slantSection, "buildRate", 0.0, "turnRate", 0.0),
  newmap("sectionLength", @@endDropOff - @@slantSection-@@endBuildup, "buildRate", @@dropOff, "turnRate", 0.0),
  
):const():seq();


=>og.model.minimumCurvature.surveyFromDirectionalSections(
     newmap("points", @@points)
) at the end
```
