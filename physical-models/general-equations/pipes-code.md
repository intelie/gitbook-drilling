# Pipes Functions

## Drilling KPI

### Mechanical Specific Energy - **MSE**

Calculates the mechanical specific energy for the given well

```javascript
og.model.general.mse(
         newmap("wellId", "{well_id}",  
                "weightOnBit", value_N,
                "rotarySpeed", value_rad/s, 
                "torqueOnBit", value_N.m, 
                "rateOfPenetration", value_m/s)
)
```

**Output: MSE (Pa)**

### **H**ydraulic Mechanical Specific Energy - **HMSE**

Calculates the hydraulic mechanical specific energy for the given well

```javascript
og.model.general.hmse(
         newmap("wellId", "{well_id}",  
                "weightOnBit", value_N,
                "rotarySpeed", value_rad/s, 
                "torqueOnBit", value_N.m, 
                "rateOfPenetration", value_m/s,
                "fluidFlow", value_m3/s,
                "bitPressureLoss" value_Pa,
                "energyReductionFactor", value)
)
```

**Output: HMSE (Pa)**

### Drilling Specific Energy - **DSE**

Calculates the drilling specific energy for the given well

```javascript
og.model.general.dse(
         newmap("wellId", "{well_id}",  
                "weightOnBit", value_N,
                "rotarySpeed", value_rad/s, 
                "torqueOnBit", value_N.m, 
                "rateOfPenetration", value_m/s,
                "bitHydraulicPower", value_,
                "lambda" value)
)
```

**Output: DSE (Pa)**

### **d-Exponent**

Calculates the d-exponent for the given well

```javascript
og.model.general.dExponent(
         newmap("wellId", "{well_id}",  
                "weightOnBit", value_N,
                "rotarySpeed", value_rad/s, 
                "rateOfPenetration", value_m/s)
)
```

**Output: d-exponent (-)**

## Volumes and Sizes

### **Well Volume**

Given a well, this function computes the volume between two well locations.&#x20;

Obs: These methods (well, Well between, and Well in Region) do not take into account the material of the work column, it only considers the space available for fluid (drilling mud, cement, etc). For work column volume, refer to **og.model.general.pipeDisplacement**.

```javascript
og.model.general.wellVolume(
         newmap("wellId", "{well_id}")
)
```

### **Well Volume Between**

Given a well, this function computes the volume between two well locations.&#x20;

* startPosition:  Starting location where volume will be computed ({measuredDepth: number, isAnnular: boolean})&#x20;
* endPosition: Starting location where volume will be computed ({measuredDepth: number, isAnnular: boolean})

```javascript
og.model.general.wellVolumeBetween(
         newmap("wellId", "{well_id}",  
                "startPosition", {measuredDepth: number, isAnnular: boolean},
                "endPosition", {measuredDepth: number, isAnnular: boolean},
                )
)
```

### **Well Volume in Region**

Given a well, this function computes the volume between two well locations. The expected parameters are:  isAnnular: flag indicating if region is annular or not (boolean)

```javascript
og.model.general.wellVolumeInRegion(
         newmap("wellId", "{well_id}",  
                "isAnnular", value_boolean
                )
)
```

### **Pipe Displacement**

Calculates the pipe displacement (steel total volume) for the given well

```javascript
og.model.general.pipeDisplacement(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m)
)
```

**Output: Pipe Displacement (m3)**

### **Open Hole Start Depth**

Shows the last casing shoe measured depth

```javascript
og.model.general.openHoleStartDepth(
         newmap("wellId", "{well_id}")
)
```

### **Well JSON**

```javascript
og.model.general.wellJSON(
         newmap("wellId", "{well_id}")
)
```

### **Equivalent Geometry**

```javascript
og.model.general.equivalentGeometry(
         newmap("wellId", "{well_id}")
)
```

### **Bottom’s up time**

Calculates the time the fluid takes to travel through a well portion. For this function, the flow rate and depth are fixed during all periods of **t**ime.&#x20;

```javascript
og.model.general.fluidCourseTime(
         newmap("wellId", "{well_id}"
                "bitDepth", value_m, 
                "fluidFlow", value_m3/s, 
                "isAnnular", boolean)
)
```

**Output: Bottom’s up time (s)**

**Example Pipes:**

```javascript
=> og.model.general.fluidCourseTime( newmap(
             'wellId', '11',
             'bitDepth', BITDEP#*0.3048, --ft to meters
             'fluidFlow', FLOWIN#*0.000063090196,  -- gpm to m3/s
             'isAnnular', true)
) every minute -- output is in seconds
=>_#/60 as {bottom_up [min]}
```

**Example Pipes**

**Calculate annular volume and annular velocity**

```javascript
-- Annular Volume
def @@fluid_flow: 0.05; --m3/s
def @@bit_depth: 1000; --m

=> og.model.general.fluidCourseTime(
         newmap("wellId", "1"
                "bitDepth", @@bit_depth, 
                "fluidFlow", @@fluid_flow, 
                "isAnnular", true)
)->result/@@fluid_flow as annular_volume

--Annular Velocity (average)
=> og.model.general.fluidCourseTime(
         newmap("wellId", "1"
                "bitDepth", @@bit_depth, 
                "fluidFlow", @@fluid_flow, 
                "isAnnular", true)
)->result as bottom_up_time
=>@@bit_depth/bottom_up_time as annular_velocity
```

### **Lag Depth and Lag Time (only Fluid)**

Calculates lag time and lag depth for a given interval of data, only using the information of fluid flow, i.e, do not take into account the cuttings velocities (see on cuttings this feature).

```javascript
og.model.general.lagTime(
         newmap("wellId", "{well_id}"
                "bitDepth", value_m, 
                "intervalData</span>", value)
)
```

![](https://lh6.googleusercontent.com/XR8\_DdgGj5lfwrwh-K3haqYEbaKBkVq8yqvCvNTPyNRHOIkPfht1R1\_Extpp75RFz8XxdeXpQg\_5Nw3c973802RU8oBd-hZzEVYZWA9QlcDsY5H9QSY2M6\_dqv\_48OMrbpnjwIxM)

## Fluid Properties

### Rheometer Calculations

Calculate shear rate and Shear Stress from rheometer readings

```javascript
og.model.general.shearRateShearStressFromRheometer(
  newmap(
    "rheometerReadings", newmap(
      3.0, value_theta_rpm3,
      6.0, value_theta_rpm6,
      100.0, value_theta_rpm100,
      200.0, value_theta_rpm200,
      300.0, value_theta_rpm300,
      600.0, value_theta_rpm600
    ),
    "powerLawExponent", value_exponent
))
```

Calculate Rheological Parameter from rheometer readings

```javascript
og.model.general.rheologicalModelCalibration(
  newmap(
    "rheometerReadings", newmap(
      3.0, value_theta_rpm3,
      6.0, value_theta_rpm6,
      100.0, value_theta_rpm100,
      200.0, value_theta_rpm200,
      300.0, value_theta_rpm300,
      600.0, value_theta_rpm600
    ),
    "fluidType", "FluidType"
))
```

**Fluid Types:**&#x20;

* **HERSCHEL\_BULKLEY**
* **POWER\_LAW**
* **BINGHAM**
* **NEWTONIAN**

**Example**

![Plot all rheological model vs rheometer readings](<../../.gitbook/assets/image (481).png>)
