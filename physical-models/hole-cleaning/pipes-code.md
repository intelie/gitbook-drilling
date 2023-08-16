# Pipes Functions

## **Steady State Hole Cleaning**



![Hole Cleaning Index, Solid concentration and Bed Relative Height vs Depth - Steady State](https://lh6.googleusercontent.com/QECQnyTe4fxy1xF7gQiLHBKs3U8Sf544rrrWeYwgCrtEORDQq5OzLhle0WKJ3O1pljcL0ucaohSUJmukcPvbcVuY8OGTDWC2aLRdBYKOg\_qe3xlUk9AphZuR0\_2bCJxDbabwz4Zt)

Compute cuttings transport in steady-state

```groovy
og.model.cuttingstransport.steadyState(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

**Output:**&#x20;

* **Bed Relative Height (0-1),**&#x20;
* **Transport Ratio (0-100),**&#x20;
* **cuttings Carrying Index (0-1)**&#x20;
* **Suspension Solids Concentration (m3/m3)**&#x20;
* **vs Depth (m)**
* **Lag time (s)**

### **Bed Relative Height**

Bed Relative Height = Bed Height / Annular Hydraulic Diameter

Calculate bed relative heights the annular depths

```groovy
og.model.cuttingstransport.bedRelativeHeight(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

### **Suspension Solids Concentration**

Calculate suspension solid concentration the annular depths

```javascript
og.model.cuttingstransport.suspensionSolidsConcentration(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

### **Total Solids Concentration**

Calculate total solid concentration of the annular depths (suspension + solid bed)

```javascript
og.model.cuttingstransport.totalSolidsConcentration(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

### **Suspension Solids Velocity**

Calculate suspension solid velocities along the annular depths

```javascript
og.model.cuttingstransport.suspensionSolidsVelocity(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

### **Suspension Fluid Velocity (Annular Velocity)**

Calculate suspension fluid velocities along the annular depths

```javascript
og.model.cuttingstransport.suspensionFluidVelocity(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

### **Transport Ratio**

&#x20;Transport Ratio = Suspension Solid Velocity/Suspension Fluid Velocity

Calculate transport ratio along the annular depths

```javascript
og.model.cuttingstransport.transportRatio(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

### **Minimal Flow For Efficient Cleaning**

Calculate minimum flow for efficient cleaning

```javascript
og.model.cuttingstransport.minimalFlowForEfficientCleaning(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s
                "maxTotalCuttingsConcentration", value_m3/m3)
)
```

### **Maximum ROP For Efficient Cleaning**

Calculate maximum ROP for Efficient Cleaning

```javascript
og.model.cuttingstransport.maximumRopForEfficientCleaning(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s,
                "maxTotalCuttingsConcentration", value_m3/m3
                )
)
```

### **Lag time (Cuttings)**

Calculate the lag time using the cuttings calculator.

**Example Pipes:**

```javascript
og.model.cuttingstransport.lagTime(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "flowRate", value_m3/s,
                "drillPipeRotation",  value_rad/s, 
                "rateOfPenetration", value_m/s, 
                "cuttingsAverageSize", value_m, 
                "cuttingsDensity", value_kg/m3, 
                "maxCellLength", value_m, 
                "minCellLength", value_m,
                "boosterMeasuredDepth", value_m,
                "boosterFlowRate", value_m3/s)
)
```

![](https://lh5.googleusercontent.com/CDIN9wP3ITMMjc0JyjhL8nNVTNKCXdxLRY5-Pw8w2ZsUt5CjR1mSCB9qcMN\_r0ZJ9HReLSJdMeYLc6P3ueppvVBHxdr6jqW2KoN1xf2MK\_-BLbevGwZ0tZLa7mx72o5nAu1SYzXx)

## **Input Parameters Description**

| **Parameters**           | **Description**                          | **unit**   |
| ------------------------ | ---------------------------------------- | ---------- |
| **wellId**               | **Well Id**                              | **String** |
| **rateOfPenetration**    | **Rate of Penetration**                  | **m/s**    |
| **flowRate**             | **Flow Rate or pump flow in**            | **m3/s**   |
| **cuttingsAverageSize**  | **Particle Diameter**                    | **m**      |
| **cuttingsDensity**      | **Solid density (cuttings)**             | **kg/m3**  |
| **maxTailorLength**      |                                          | **m**      |
| **minCellLength**        | **Size length of cell (discretization)** | **m**      |
| **boosterMeasuredDepth** | **Measured depth of booster**            | **m MD**   |
| **boosterFlowRate**      | **Booster flow rate**                    | **m3/s**   |
