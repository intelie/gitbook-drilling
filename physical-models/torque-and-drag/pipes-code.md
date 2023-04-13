# Pipes Functions

## **Forces**

### **All curves**

**Computes the normal, axial load, drag, and torque over all the well layers**

```groovy
og.model.softString.torqueAndDrag(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "torqueOnBit", value_N.m, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

**Outputs:**

* **True Axial Load (N)**
* **Drag (N)**
* **Normal (N)**
* **vs Depth(m)**

### **Normal**

Calculates a map of the side forces (normal) of the specified well

```groovy
og.model.softString.normal(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "torqueOnBit", value_N.m, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Normal (N) vs Depth(m)

### **Normal per Length**

```groovy
og.model.softString.normalPerLength(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "torqueOnBit", value_N.m, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Normal per Length Forces (N/m) vs Depth(m)

### **Drag**

**Computes the drag values of the specified well**

```javascript
og.model.softString.drag(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Drag (N) vs Depth(m)

### **Torque**

**Computes the torque values of the specified well**

```javascript
og.model.softString.torque(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "torqueOnBit", value_N.m, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Torque (N.m) vs Depth(m)

### **Axial load**

![Axial Load, Drag,  Sinusoidal and Helical Buckling vs Depth ](https://lh5.googleusercontent.com/AJmwJXQh0gnDDpZnT1kXSnt8tCuFLTLob1N9\_k\_\_1\_4-JlahtMCYyUdJekjp8fbSFONTNX9hb655tikwtenkngE0sHQVXM-aMuSDbGmdLGQ4zjRgp7stMwa3l5ZGQ7Y4e8rGB6hQ)

**Computes the axial load values of the specified well**

```javascript
og.model.softString.axialLoad(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: True Axial Load (N) vs Depth(m)

### **Effective Axial Load**

**Computes the effective axial load values of the specified well**

```javascript
og.model.softString.effectiveAxialLoad(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Effective Axial Load (N) vs Depth(m)

### **Stress**

**Computes the stress values of the specified well**

```javascript
og.model.softString.stress(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "torqueOnBit", value_N.m, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3)
                "stressType", "String")
)
```

Output: Stress (Pa) vs Depths (m)

**Possible stress types:**

* **TRANSVERSE\_SHEAR,**&#x20;
* **RADIAL,**&#x20;
* **HOOP,**&#x20;
* **BUCKLING,**&#x20;
* **AXIAL,**&#x20;
* **VON\_MISES**
* **BENDING**
* **TORSIONAL**

## **Buckling**

### &#x20;**Sinusoidal**

**Computes the sinusoidal buckling values of the specified well**

```javascript
og.model.softString.sinusoidalBuckling(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "maxSectionLength",value_m)
)
```

Output: Sinusoidal Buckling (N) vs Depth(m)

### **Helical**

**Computes the helical buckling values of the specified well**

```javascript
og.model.softString.helicalBuckling(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "maxSectionLength",value_m)
)
```

Output: Helical Buckling (N) vs Depth(m)

## **Broomstick Charts**

![Broomstick (Hookload) modeled (4 frictions factors), Hookload real (dots) vs Depth. Each Dot color represents different rig states.](https://lh5.googleusercontent.com/R2tPPI4vtCJOxhy7x7\_WUciB7t\_dAk7STcQyN2Oz9XQOVJY703rK7U1NhjEI8JXRTRbLWgOTCzkw8vwzhcSns4piaQpzwd9E68fr42RCfiyeVr-J2aFBdIH4IMrWMP5bRBCbJiH1)

### **Hook load**

**Computes the hook load**

```javascript
og.model.softString.hookLoad(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "stepLength", value_m, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s,  
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Hook Loads (N) vs Depth (m)

### **Minimum Weight Helical Buckling**

**Computes the Minimum Weight Helical Buckling**

```javascript
og.model.softString.hookLoadForBuckling(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "stepLength", value_m, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s,  
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Hook Load For Helical Buckling (N) vs Depths (m)

### **Maximum  weight for Yield Strength**

**Computes the Maximum  weight for Yield Strength**

```javascript
og.model.softString.hookLoadForMaterialFailure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "stepLength", value_m, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s,  
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: HookLoad For Material Failure (N) vs Depths (m)

### **Torque on Surface**

**Computes the torque on surface**

```javascript
og.model.softString.torqueOnSurface(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "stepLength", value_m, 
                "torqueOnBit", value_N.m, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s,  
                "startFromSurface", boolean, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Torque on Surface (N) vs Depths (m)

## **Find Positions**

### **Neutral Point**

![BHA Schematic vs Neutral Point - Compression (Red), Tension (Blue)](https://lh4.googleusercontent.com/JvyPLJCdlB7EHjDz1T3kjld6LoyKXIjDPjs9U53AhctjHzK7Qix1uT53rDW3QgNmoctSDih9lAM92UIagNvsPIMVgERxsfCKTzF5Tl2LGx7sFW5-ODmY5jQg-WjWqgN7i10xt42S)

![Neutral Point, Top BHA and Bit Depth vs Time](https://lh4.googleusercontent.com/nqjEcOUiUUw9Oe89b4cmZyB8N5d4ifaGN4yCF139za-B391Nbn3Qb94teftvRx4JCGeUQQjnh8gUSy6jrDK3ujFMWdyAtRsLZcRLyzTwvEQW1\_356Tz6AJ48yPBtKVhSO38ecVLB)

\
**Computes all the neutral points locations**

```javascript
og.model.softString.neutralPoint(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "travellingBlockWeight", value_N, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "startFromSurface", boolean, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Neutral point (m)

### **Stretch**

**Computes the stretch value of the specified well**

```javascript
og.model.softString.stretch(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "frictionFactor", value,
                "frictionFactorMap", value,
                "maxSectionLength",value_m, 
                "useCalibrationData", boolean, 
                "pipesWeightMultiplier", value, 
                "rotarySpeed",  value_rad/s, 
                "columnVelocity", value_m/s, 
                "weightOnBit", value_N, 
                "hookLoad", value_N, 
                "pipeDensityMap", newmap(m,kg/m3), 
                "annularDensityMap", newmap(m,kg/m3))
)
```

Output: Stretch (m)

### **Stuck Pipe Position (Free point calculation)**

**Computes the stuck pipe position (m) given a hook load delta (N) and the respective stretch (m)**

```javascript
og.model.softString.stuckPipePosition(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "stretch", value_m,
                "hookLoadDelta", value_N)
)
```

Output: Position (m)

## Input Parameters Description

#### **Input Parameters**

| **Parameters**            | **Description**                                                                                                                                                           | **unit**      |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------- |
|  **wellId**               | **Well id**                                                                                                                                                               | **String**    |
| **weightOnBit**           | <p><strong>Weight on bit (downhole)(default: zero)</strong><br></p>                                                                                                       | **N**         |
| **rotarySpeed**           | **Angular Speed (RPM) (default: zero)**                                                                                                                                   | **rad/s**     |
| **columnVelocity**        | **Drill string or Casing Velocity (default: zero)**                                                                                                                       | **m/s**       |
| **frictionFactor**        | **Friction Factor (default: zero)**                                                                                                                                       | **\[-]**      |
| **frictionFactorMap**     | **Add map friction factor along the string, e.g: newmap(0.0, friction1,  MD2, friction2).**                                                                               | **(m, -)**    |
| **bitDepth**              | **Bottom Depth (bit depth) (default: original Md of Drillstring)**                                                                                                        | **m**         |
| **torqueOnBit**           | **Torque on Bit (Downhole) (default: zero)**                                                                                                                              | **N.m**       |
| **fluidFlow**             | **Flow Rate/pump flow in (default: zero)**                                                                                                                                | **m3/s**      |
| **stepLength**            | **Mesh discretization Step length (default: 1000m)**                                                                                                                      | **m**         |
| **usCalibrationData**     | **Calibratable (default: False)**                                                                                                                                         | **Boolean**   |
| **maxSectionLength**      | **Max Section Length (default:200m)**                                                                                                                                     | **m**         |
| **startFromSurface**      | **Calculate from the surface (Top to bottom) default: False**                                                                                                             | **Boolean**   |
| **hookLoad**              | **Hook Load (default empty)**                                                                                                                                             | **N**         |
| **travellingBlockWeight** | **Traveling Block Weight (default: zero)**                                                                                                                                | **N**         |
| **pipesWeightMultiplier** | **Pipes Weight Multiplier, it is the coefficient to multiply linear weight of DP (default:1.0)**                                                                          | **\[-]**      |
| **pipeDensityMap**        | <p><strong>Add map density within pipe,</strong> </p><p><strong>e.g: newmap(0.0, density1,  MD2, density2). This is an important feature to multiple fluids</strong></p>  | **(m,kg/m3)** |
| **annularDensityMap**     | <p><strong>Add map density within pipe,</strong> </p><p><strong>e.g: newmap(0.0, density1,  MD2, density2). This is an important feature of multiple fluids.</strong></p> | **(m,kg/m3)** |
