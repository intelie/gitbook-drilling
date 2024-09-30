# Pipes Functions

## Plugins

![](<../../.gitbook/assets/image (69).png>)

## Pipes Functions

### **Pressure Map (Annular and Tube)**

#### **Computes a map of total pressures**

```javascript
og.model.hydraulics.pressureMap(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "entryPressure", value_Pa, 
                "startAnnular", boolean, 
                "isAnnular",boolean)
)
```

### **ECD and ESD (Annular)**

Computes a map of equivalent densities

```javascript
og.model.hydraulics.equivalentDensityMap(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "entryPressure", value_Pa, 
                "startAnnular", boolean, 
                "isAnnular",boolean)
)
```

### **Frictional Pressure Loss (Annular and Tube)**

Computes a map of frictional pressure losses.

```javascript
og.model.hydraulics.frictionalPressureLossMap(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "entryPressure", value_Pa, 
                "startAnnular", boolean, 
                "isAnnular",boolean)
)
```

### **Pressure at specific MD (Annular and Tube)**&#x20;

These methods calculate the pressure at a given depth, eg. when it is set the depth=0.0m and isAnnular = False the method returns the standpipe pressure. Normally this functionality is useful to compare pressure (at specific position)  on Time Charts.

Computes the pressure at a given depth.

```javascript
og.model.hydraulics.pressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "entryPressure", value_Pa, 
                "startAnnular", boolean, 
                "isAnnular",boolean,
                "depth", value_m)
)
```

### **ECD or ESD at specific MD (Annular and Tube)**&#x20;

These methods calculate the ECD at a given depth, eg. when it is set the depth=bitdepth and isAnnular = True the method returns the Bottom ECD or ESD. Normally this functionality is useful to compare ECD and ESD (at specific position)  on Time Charts.&#x20;

Computes the equivalent density at a given depth

```javascript
og.model.hydraulics.equivalentDensity(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "entryPressure", value_Pa, 
                "startAnnular", boolean, 
                "isAnnular",boolean,
                "depth", value_m)
)
```

### **Frictional Pressure Loss by Components**

Maps components into their respective pressure drops.

```javascript
og.model.hydraulics.lossByComponent(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s)
)
```

### Computes a specific component pressure drop

```javascript
og.model.hydraulics.componentLoss(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s),
                "type", "type_component", 
                "name", "name_component")
)
```

### **Choke Pressure**&#x20;

Calculates the choke pressure based on a set point and measured depth of the set point

```javascript
og.model.hydraulics.chokePressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "fluidFlow", value_m3/s,
                "equivalentDensitySetPoint", value_kg/m3, 
                "measuredDepthSetPoint", value_m)
)
```

### **Calibration**&#x20;

Calibrates frictional pressure loss on BHA from the linear and exponential parameters on adjustable components.

```javascript
og.model.hydraulics.chokePressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                seq points. Each point being: 
                   {fluidFlow (m³/s), entryPressure (Pa), exitPressure (Pa)})
)
```

## **Optimization**

### Calculates the maximum flow rate for given pump characteristics

```javascript
og.model.hydraulics.maximumFlowRate(
         newmap("wellId", "{well_id}",  
                "maximumPressure", value_Pa,
                "hydraulicPower", value_J/s,
                "efficiency", value_kg/m3)
)
```

![Bit Hydraulic Power](https://lh4.googleusercontent.com/MrXdD2FK2NoTgaU3wd17tYC14DbcGhNHHhjJ0dq1XG8PeoZ42jTX4BrDjIyXYe4lAWb2BQQ4LaefgsWMiQEjEAa29piQhbcwxvzu1-PphcSpTC1pEWO4MPkFuIu-UXtxjBf5Gs8S)

### Calculates the optimum flow rate for maximum bit hydraulic power

```javascript
og.model.hydraulics.optimizeFlowRateWithMaximumBitHydraulicPower(
         newmap("wellId", "{well_id}",  
                "maximumPressure", value_Pa,
                "minimumFlowRate", value_m3/s,
                "maximumFlowRate", value_m3/s)
)
```

### Calculates the flow x bit jet impact force considering maximum system pressure

```javascript
og.model.hydraulics.bitJetImpactForce(
         newmap("wellId", "{well_id}",  
                "maximumPressure", value_Pa,
                "minimumFlowRate", value_m3/s,
                "maximumFlowRate", value_m3/s)
)
```

### Calculates the optimum flow rate for maximum bit jet impact force

```javascript
og.model.hydraulics.optimizeFlowRateWithMaximumBitJetImpactForce(
         newmap("wellId", "{well_id}",  
                "maximumPressure", value_Pa,
                "minimumFlowRate", value_m3/s,
                "maximumFlowRate", value_m3/s,
                "fluidDensity", value_kg/m3)
)
```

## **Input Parameters Description**

#### **Input Parameters on Hydraulic Pipes Functions**

| **Parameters**                       | **Description**                                                                                                                                                                                                                                                                    | **unit**       |
| ------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------- |
| **wellId**                           | **Well Id**                                                                                                                                                                                                                                                                        | **String**     |
| **drillingSectionIndex**             | **Drilling Section Index**                                                                                                                                                                                                                                                         | **String**     |
| **runPosIndex**                      | **Run Pos Index**                                                                                                                                                                                                                                                                  | **String**     |
| **bitDepth**                         | **bit depth measured depth. Default is length of drill string**                                                                                                                                                                                                                    | **meters**     |
| **fluidFlow**                        | **Flow Rate or pump flow in. Default is zero**                                                                                                                                                                                                                                     | **m3/s**       |
| **isAnnular**                        | <p><strong>The pressure at the start of the portion specified at the {@link Hydraulics} creation, which determines the ({@link #integrationPath}). If startAnnular at {@link Hydraulics} construction is true, the portion is the annular one, tubular otherwise.</strong><br></p> | **Boolean**    |
|  **entryPressure**                   | <p><strong>The pressure at the integration path starts. Default zero.</strong><br></p>                                                                                                                                                                                             | **Pa**         |
| **startAnnular**                     | **This is MD of start annular (default = 0). When is the ‘return to seabed’ scenario this value is the water depth.**                                                                                                                                                              | **m**          |
| **cuttingsDensity**                  | **Density of Cuttings.**                                                                                                                                                                                                                                                           | **(Kg/m³)**    |
| **tubularPressureMap**               | **Pressure along of tubular**                                                                                                                                                                                                                                                      | **(m, Pa)**    |
| **annularPressureMap**               | **Pressure along of annular**                                                                                                                                                                                                                                                      | **(m, Pa)**    |
| **tubularTemperatureMap**            | **Temperature along the tubular. Important for compressibility**                                                                                                                                                                                                                   | **(m, degK)**  |
| **annularTemperatureMap**            | **Temperature along of annular**                                                                                                                                                                                                                                                   | **(m, degK)**  |
| **cuttingsConcentrationMap**         | **Solid concentration along of annular**                                                                                                                                                                                                                                           | **(m, m3/m3)** |
| **boosterDepth**                     | **Depth (MD) of pump booster**                                                                                                                                                                                                                                                     | **(m),**       |
| **boosterFluidFlow**                 | **Flow rate of pump booster**                                                                                                                                                                                                                                                      | **(m³/s),**    |
| **useCalibrationData**               | **Used to calibrate the standpipe pressure. Default is False**                                                                                                                                                                                                                     | **boolean**    |
| **linearCalibratableParameter**      | **Calibratable parameter (on BHA)**                                                                                                                                                                                                                                                | **-**          |
| **exponentialCalibratableParameter** | **Calibratable parameter (on BHA)**                                                                                                                                                                                                                                                | **-**          |
