# Validation

## **Static Data - Validation**

This validation is a service where through the below link, is possible to check if all dependencies (static inputs) are correct to run the models.

Example 1: Case with an error

![](<../../.gitbook/assets/image (240).png>)

Example 2: All inputs are correct

![](<../../.gitbook/assets/image (63).png>)

**Link:**

Example:

**https://{env}.intelie.com/services/plugin-og-model-core/well/  +**

1. **validate/wellId/{wellId}**
2. **validate/wellId/{wellId}/timestamp/{timestamp}**
3. **validate/wellId/{wellId}/interventionId/{interventionId}/drillingSectionPosIndex/{drillingSectionPosIndex}/runPosIndex/{runPosIndex}**

## Messages

These messages are showed when the validation finds an error.&#x20;

### **Well**

1. **Well ID { Number } not found.**
2. **Well ID { Number } contains no drilling sections.";**
3. **Well ID { Number } attributes part is null."**
4. **Well ID { Number } trajectory is null.."**
5. **Well ID { Number } fluid not found**
6. **Missing ID of drill string section {List of components without ID(Names)}**
7. **Missing ID of BHA section  {List of components without ID(Names)}**
8. **Missing TFA of BHA section  {List of components (DrillBit or Underreamers) without ID(Names)}**
9. **Drill string Length {Number m} is longer than the wellbore ("  + wellboreLength  + "m).**
10. **Wellbore section(s) with start depth(s): "  + startDepthsWithMinWellboreDiameter  + " collides with the following component(s): "  + componentsWithCollision (InsideDiameter Wellbore< Outside Diameter DrillString/BHA component)**
11. **A hole depth (" + holeDepth + ") smaller than drill bit depth ("  + drillBitDepth + ") is not allowed.**

### **Fluid**

1. **Missing field \\"powerLawExponent\\" value at \\"fluid\\**
2. **Missing field \\"flowConsistencyIndex\\" value at \\"fluid\\**
3. **Missing field \\"density\\" value at \\"fluid\\**
4. **Missing field \\"isCompressible\\" value at \\"fluid\\**
5. **Missing field \\"saltType\\" at at \\"fluid\\**
6. **Missing field \\"brineConcentration\\" at \\"brine\\" at \\"fluid\\**
7. **Field \\"concentration\\" is negative at \\"brine\\" at \\"fluid\\**
8. **Field \\"concentration\\" is greater than 1 at \\"brine\\" at \\"fluid\\**
9. **Missing field \\"oilConcentration\\" value at \\"fluid\\**
10. **Field \\"oil\\" is negative at \\"fluid\\**
11. **Field \\"oil\\" is greater than 1 at \\"fluid\\**
12. **Missing field \\"brineConcentration\\" value at \\"fluid\\**
13. **Field \\"brineConcentration\\" is negative at \\"fluid\\**
14. **Missing field \\"solidsConcentration\\" value at \\"fluid\\**
15. **Field \\"solidsConcentration\\" is negative at \\"fluid\\**
16. **Field \\"solidsConcentration\\" is greater than 1 at \\"fluid\\**
17. **Concentrations do not sum to 100% at field at \\"fluid\\**

### **Trajectory**

1. **Trajectory \\"points\\" must start at depth 0**
2. **Trajectory \\"points\\" have repeated depths at**&#x20;
3. **Missing \\"azimuth\\" field value at trajectory points:**&#x20;
4. **Missing \\"inclination\\" field value at trajectory points:**

### **Wellbore**

1. **Wellbore sections have the following repeated starting depths:**&#x20;
2. **Wellbore sections have the following repeated ending depths:**
3. **Wellbore sections does not have positive length**&#x20;
4. **Wellbore sections are not chained. There are gaps between depths**&#x20;
5. **Missing field \\"innerDiameter\\" value at wellbore section**
6. **Missing field \\"outerDiameter\\" value at wellbore section**
7. **Missing field \\"isCasing\\" value at wellbore sections**
8. **A hole depth ("   + holeDepth   + ") smaller than last section's (open hole) start depth ("  + openHoleStartDepth + ") is not allowed.**

### **DrillString**

1. **Drill string components have the repeated following ids**
2. **Missing \\"innerDiameter\\" field value at drill string components: "  + nullInnerDiamComponents**
3. **Missing \\"outerDiameter\\" field value at drill string components: "   + nullOuterDiamComponents**
4. **Missing \\"length\\" field value at drill string components: " + nullLengthComponents**
5. **Missing \\"linearDensity\\" field value at drill string components:**
6. **Missing \\"totalNozzleArea\\" field value at drill bit components:**
7. **Drill string must start at depth 0**
8. **Drill string sections have the following repeated starting depths:**
9. **Drill string sections have the following repeated ending depths:**
10. **Drill string sections does not have positive length:**&#x20;
11. **Drill string sections are not chained. There are gaps between depths**&#x20;
12. **Drill string sections missing component:missingComponentSections**
13. **Drill string last component must be a drill bit**
14. **Drill bit depth of " + drillBitDepth    + " not allowed. It must be a non-negative number.**

### **Geopressures**

1. **Pore pressure points must start at depth 0"**
2. **Operational window \\"porePressurePoints\\" field has repeated depths at "  + ppRepeatedDepths**
3. **Missing operational window \\"porePressurePoints\\" field values at points: "     + ppMissingValuePoints**
4. **Fracture pressure points must start at depth 0**
5. **Operational window \\"fracturePressurePoints\\" field has repeated depths at "    + fpRepeatedDepths**
6. **Missing operational window \\"fracturePressurePoints\\" field values at points: "          + fpMissingValuePoints**
