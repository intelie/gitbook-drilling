# Introduction

The physical models are available today on the Intelie Live Platform.

* Trajectory - Minimum Curvature Method
* Torque and Drag  - Soft String
* Hydraulics&#x20;
* Hole Cleaning
* Swab and Surge
* Thermal Simulator
* Volume Tracker

**On Intelie Live is possible to use the Engineering tools in two forms:**&#x20;

*   **Standalone (Steady-state)**

    * Physical models are interconnected using the steady-state approach
    * Fast results
    * Simulate any conditions keeping constant the operational parameters
    * Improve fluid properties and optimize the operational parameters in Real-time
    * Independent and customizable dashboards


* **Transient**
  * Use pseudo-transient and transient approach
  * Integrated with Model Manager
  * Two-way or One-way Coupling&#x20;
  * All data calculated is stored and used as a feature on ML algorithms
  * Set the frequency of all simulator
  * Connect 3rd-party equations
  * Connected with ML algorithms to detect/avoid drilling problems in Real-time

## Built-in functions

All models are done as built-in functions, helping to do any analysis.

![](<../../.gitbook/assets/image (185).png>)

## Structure for all output of og.model functions

All **og.model** functions return a structure with log and result.&#x20;

* **Log**: debugging tool, we can see debug, info, warnings, and error messages. Very important to check errors at the specific function calling data.
* **Result**: Desire output, can be a single value or a map.

![](<../../.gitbook/assets/image (29).png>)

## **Run the models using Historical, Active, or set IDs  Interventions/Section/Runs**

**Interventions -> Section -> Run -> Operations**

![](<../../.gitbook/assets/image (199).png>)

**How it works**

**For CURRENT date (now, last x min, etc)**

* The algorithm finds the active intervention, last section, and ACTIVE RUN and Fluid. **This mode does not need the dates on intervention and runs.**

**For one SELECTED TIME (historical)**

* The algorithm finds the intervention date interval (can be active, finished, or schedule), go to the last section and see if there is some RUN where the interval fits the SELECTED TIME (end date), otherwise go to the next section. **For this mode is mandatory to set all dates interval.**&#x20;

**Set the interventionID, sectionIndex and runIndex**

* In this mode all og.model functions can receive as input the: **interventionId, drillingSectionPosIndex and runPosIndex**

```groovy
og.model.general.mse(
         newmap("wellId", "{well_id}",  
                "weightOnBit", value_N,
                "rotarySpeed", value_rad/s, 
                "torqueOnBit", value_N.m, 
                "rateOfPenetration", value_m/s,
                "interventionId", "value_ID",
                "drillingSectionPosIndex", value_index,
                "runPosIndex", value_index,
                'trajectoryAndGeopressureDataFromWellParameter', value_boolean
                )
)
```

\
