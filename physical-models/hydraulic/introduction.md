# Introduction

Drilling hydraulics refers to how the drilling fluid in the circulating system exerts pressure throughout the system, particularly on the wellbore. The amount of pressure exerted by the fluid depends on the depth of interest, the fluid properties, wellbore geometry, and whether the fluid is static (not circulating) or in a dynamic (circulating) condition. When static, the pressure exerted on the wellbore by the drilling fluid (often called bottom hole pressure or BHP) is simply the fluid density or mud weight (MW) multiplied by the true vertical depth (TVD). The main objective of the drilling fluid is to improve the drilling performance and remove cuttings from downhole to surface.

### **Summary**:

* ESD, pressure drop, and ECD calculations
* Use the minimum curvature method to interpolate the trajectory
* Take into account wellbore geometry, hole angle, and size
* Considers various modes such as sliding, rotating, mixed, circulating, running in hole / pulling out of hole
* Able to calculate with multiple fluids on Annular or tubular.&#x20;
* Solid concentration&#x20;
  * Use transient cuttings concentration to estimate the apparent density
* Fluid Compressibility Model
  * Use different types of fluids (oil-based and water-based)
  * Uses transient or steady-state pressures  and temperature to update the compressibility
  * Compute brine weights under pressure and temperature conditions
* Ability to choose rheology models from Newtonian, Bingham Plastic, Power Law, and HB
* Drilling components&#x20;
  * Calibrate the BHA real-time data or Shallow test inputs&#x20;
  * Drill bit, turbine, underreamer, etc
  * Easy to add more friction pressure equations
* Drilling hydraulics optimization (maximum jet impact force and maximum)&#x20;

