# Pipes Functions

## **Volume Tracker**

```javascript
og.model.volumeTracker.density(
         newmap("wellId", "{well_id}",  
                "bitDepth", value_m,
                "initialDensity", value_kg/m3, 
                "pumpingSequence", sequence)
)
```

#### **Pipes Example:**

```javascript
def @@pumpingSequence: (newmap(
      'duration', 2000.0, -- [s]
      'flowProviders', (
          newmap(
             'measuredDepth', 0.0, -- [m]
             'isAnnular', false,
             'density', 1200.0, -- [kg/m3]
             'flowRate', 0.01 -- [m3/s]
          ),
      )),
):const():seq();

=>og.model.volumeTracker.density(
  newmap(
  'wellId','21',
  'initialDensity', 1000.0, -- optional parameter [kg/m3]
  'pumpingSequence', @@pumpingSequence,
)) at the end =>_->result as trackerResults
```
