# Introduction

Surge effects occur when the pipe moves downward with mud circulation through the drill string, additional bottom hole pressure called “surge pressure” is created. If surge pressure is too high, many problems will occur, such as formation breakdown, partial mud loss, and circulation loss. On the other hand, the swabbing effect happens when a drill string, casing string, or logging tool is being pulled out of the hole too fast, due to bigger diameter almost the same hole size, BHA/ bit, casing, or logging tool will possibly swab mud out of the hole, like pulling a small piston of a syringe. For this reason, hydrostatic pressure at the bottom hole will be reduced. Pressure reduction created by this situation is called “swab pressure”. If swab pressure is too much, kick (wellbore influx) may occur in the hole and well control must be conducted in order to secure the well.

Summary:

* Surge and Swab calculations/tripping speeds
* Triggers the model only during a drill pipe/casing movement and without flow rate
* Uses real-time drill string/casing velocity,  bit depth, and fluid properties
* Uses the wellbore and drill string geometry&#x20;
* Calculates with different flow regimes and Rheological Models:
  * Power-Law, Newton, Bingham
* Easier to add new models
* Triggers alarms when the Surge and Swab Calculations or tripping speeds are exceeding the operating window (New).
* Able to calculate open and close-ended.&#x20;
