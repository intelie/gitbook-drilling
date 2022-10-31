# Pipes Functions

## **Pressure along of the drill string**

![Pressure along of the drill string](https://lh4.googleusercontent.com/1wXvwi93mf2vOvSd5TmkBDag2yrPb0H2HkOuQHimDZQO0tNeFAAI32ocg1HAowGJ-3M5XSvzZps7Ta59WGMsy-7lEjJt4QIzHhSoOFlktCH3WmfbxJKZC449SlF69JOuKspnW0R2)

### Surge

Computes surge pressure along the specified well with the specified pipe speed)

```javascript
og.model.surge.pressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "pipeSpeed", value_m/s, 
                "computationUom", 'Pa', 
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: Pressure Surge (Pa) vs Depth**

### Swab

Computes swab pressure along the specified well with the specified pipe speed

```javascript
og.model.swab.pressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "pipeSpeed", value_m/s, 
                "computationUom", 'Pa', 
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: Pressure Swab (Pa) vs Depth**

**Example Pipes:**

```javascript
--Swab ECD
=> og.model.swab.pressure(newmap("wellId","11","pipeSpeed", 0.05)) every batch
=> @for => @yield => {swab.pressure} as Swab_pressure, depth

--Surge ECD
=> og.model.surge.pressure(newmap("wellId","11","pipeSpeed", 0.05)) every batch
=> @for => @yield => {surge.pressure} as Surge_pressure, depth
```

## **Equivalent Pressure along the drill string**

![Surge and Swab ECD  along of the drill string](https://lh6.googleusercontent.com/c4efKJo226moI0j-LtEs7bsCl2U8CtOoM9urCy7Q9h8S1LrEL0xS7B7RirGTpLxutvbo8EsO0WU-WjcmoHYJzzq2ck4LPtzBx2gWtRxAz2goMUmboI71qoybshqZ05M1E1VPCfAI)

### Swab

Computes swab density along with the specified well with the specified pipe speed

```javascript
og.model.swab.pressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "pipeSpeed", value_m/s, 
                "computationUom", 'kg/m3', 
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: ECD swab (kg/m3) vs Depth**

### Surge

Computes surge density along with the specified well with the specified pipe speed

```javascript
og.model.surge.pressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "pipeSpeed", value_m/s, 
                "computationUom", 'kg/m3', 
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: ECD surge (kg/m3) vs Depth**

## **ECD and Pressure at a given depth**

### Surge

Computes surge equivalent circulating density at given depth

```javascript
og.model.surge.pressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "pipeSpeed", value_m/s, 
                "computationUom", 'kg/m3', 
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean,
                "atDepth", value_m)
)
```

**Output: ECD surge (kg/m3)**&#x20;

### **Swab**

Computes swab equivalent circulating density at given depth

```javascript
og.model.swab.pressure(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "pipeSpeed", value_m/s, 
                "computationUom", 'kg/m3', 
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean,
                "atDepth", value_m)
)
```

**Output: ECD swab (kg/m3)**&#x20;

**Example Pipes:**

```javascript
--Swab ECD

=>og.model.swab.pressure(
           newmap('wellId','9', 
                  'computationUom', 'kg/m3', 
                  'pipeSpeed', 0.01, 
                  'bitDepth', 1000, 
                  'minSectionLength', 250))->result:seq at the end
=> @chain
=> {swab.pressure}#curve_unit_convert(kg/m3,'lbm/galUS') as {Swab}, depth#curve_unit_convert('m',@@depthOutputUnit) as depth

--Swab ECD
=>og.model.surge.pressure(
           newmap('wellId','9', 
                  'computationUom', 'kg/m3', 
                  'pipeSpeed', 0.01, 
                   'bitDepth', 1000, 
                   'minSectionLength', 250))->result:seq at the end
=> @chain
=> {swab.pressure}#curve_unit_convert(kg/m3,'lbm/galUS') as {Surge}, depth#curve_unit_convert('m',@@depthOutputUnit) as depth
```

## **Maximum running speed**

![Max trip velocity vs Depth](https://lh5.googleusercontent.com/2\_9LzgutZgAYQ1Z9xN3rnZyN--M7rna18gk52bj\_2E3HY3heOzYhOAQEjY6JcSD\_loxcwgOpLjK0VwZUyU1dhedgXMjciX2TKOTNRrEBo2z3NP4mHAMFxJY0chMH9-6oCsDOyKvM)

### Surge

Computes maximum pipe speed profile on surge along the specified well

```javascript
og.model.surge.maxPipeSpeed(
         newmap("wellId", "{well_id}",  
                "depthLowerBound", value_m,
                "initialBitDepth", value_m, 
                "bitStepSize", value_m,
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: Max Surge Speed (m/s) vs Depth**

| <p><strong>PARAMETER | TYPE | DOMAIN | REQUIRED? | DEFAULT</strong> </p><p><strong>wellId | String | Integer Strings | Yes | ---</strong> </p><p><strong>drillingSectionIndex | Integer | >= 0 | No | ---</strong> </p><p><strong>bitDepth | Double | >= 0 | No | ---</strong> </p><p><strong>atDepth | Double | >= 0 | No | ---</strong> </p><p><strong>minSectionLength | Double | 0 &#x3C;= x &#x3C;= maxSectionLength | No | 0</strong> </p><p><strong>maxSectionLength | Double | >= minSectionLength | No | Infinity</strong> </p><p><strong>closedEnded | Boolean | {true, false} | No | true</strong> </p><p><strong>depthLowerBound | Double | Reals | No | 0</strong> </p><p><strong>bitStepSize | Double | > 0 | No | 20</strong></p> |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |

### Swab

Computes maximum pipe speed profile on swab along the specified well

```javascript
og.model.swab.maxPipeSpeed(
         newmap("wellId", "{well_id}",  
                "depthLowerBound", value_m,
                "initialBitDepth", value_m, 
                "bitStepSize", value_m,
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: Max Swab Speed (m/s) vs Depth**

**Example Pipes:**

```javascript
=> og.model.swab.maxPipeSpeed(
      newmap("wellId", "11", 
             "depthLowerBound", 50, 
             "initialBitDepth", 1000, 
             "stepSize" 50))->result:seq at the end
=> @for => @yield => -{swab.maxPipeSpeed}# as {Max Swab Speed}, depth# as depth

=> og.model.surge.maxPipeSpeed(
       newmap("wellId", "11", 
              "depthLowerBound", 50, 
              "initialBitDepth", 1000, 
              "stepSize", 50))->result:seq at the end
=> @for => @yield => -{swab.maxPipeSpeed}# as {Max surge Speed}, depth# as depth
```

## **Maximum and Minimum trip - ECD**

### Surge

Computes surge equivalent circulating density in drill string trip

```javascript
og.model.surge.tripLimits(
         newmap("wellId", "{well_id}",  
                "pipeSpeed", value_m/s,
                "depthLowerBound", value_m,
                "initialBitDepth", value_m, 
                "computationUom", "kg/m3",
                "bitStepSize", value_m,
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: Max and Min Surge ECD (kg/m3) vs Depth**

### Swab

Computes swab equivalent circulating density in drill string trip

```javascript
og.model.swab.tripLimits(
         newmap("wellId", "{well_id}",  
                "pipeSpeed", value_m/s,
                "depthLowerBound", value_m,
                "initialBitDepth", value_m, 
                "computationUom", "kg/m3",
                "bitStepSize", value_m,
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

## **Maximum and Minimum trip - Pressure**

### Surge

Computes surge pressure in drill string trip

```javascript
og.model.surge.tripLimits(
         newmap("wellId", "{well_id}",  
                "pipeSpeed", value_m/s,
                "depthLowerBound", value_m,
                "initialBitDepth", value_m, 
                "computationUom", "Pa",
                "bitStepSize", value_m,
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: Max and Min Surge Pressure (Pa) vs Depth**

### **Swab**

**Computes swab pressure in drill string trip**

```javascript
og.model.swab.tripLimits(
         newmap("wellId", "{well_id}",  
                "pipeSpeed", value_m/s,
                "depthLowerBound", value_m,
                "initialBitDepth", value_m, 
                "computationUom", "Pa",
                "bitStepSize", value_m,
                "maxSectionLength", value_m, 
                "minSectionLength", value_m,
                "closedEnded", boolean)
)
```

**Output: Max and Min Swab Pressure (Pa) vs Depth**

## Input Parameters Description

| **Parameters**                                              | **Description**                                                            | **unit**         |
| ----------------------------------------------------------- | -------------------------------------------------------------------------- | ---------------- |
| **wellId**                                                  | **Well Id**                                                                | **String**       |
| <p><strong>computationUom</strong><br><strong></strong></p> | **If ‘Pa’  output pressure or ‘kg/m3’ output is equivalent density**       | **string**       |
| **depthLowerBound**                                         | **Bottom Depth (bit depth)**                                               | **m**            |
| **bitDepth**                                                | **Casing Shoe depth**                                                      | **m**            |
| **atDepth**                                                 | **Choose specific depth**                                                  | **m**            |
| **bitStepSize**                                             | **Step size length (discretization)**                                      | **m**            |
|  **pipeSpeed**                                              | **Drill string or casing speed**                                           | **m/s**          |
| **minSectionLength**                                        | **Minimum section length for integration**                                 | **m**            |
| **maxSectionLength**                                        | **Maximum section length for integration**                                 | **m**            |
| **closedEnded**                                             | **Close or open ended geometry. Default is true (close ended)**            | **boolean**      |
| **sectionIndex**                                            | **Set the index of the section. Default is empty, uses the last section**  | **Number (int)** |
