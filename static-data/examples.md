# REST API Examples

## Well

#### Read Well

`GET /services/plugin-liverig/assets/well/view/attributes/{wellId}`

#### Create Well

`POST /services/plugin-liverig/assets/well`

```javascript
{
   "name": "wellName",
   "type": "offshore_floating",
   "perspective": {
      "id":"1"
   }
}
```

#### Update Well

`POST /services/plugin-liverig/assets/well/view/attributes/{wellId}`

```javascript
{
   "description":{
      "name":"1-RJS-752",
      "type":"offshore_floating",
      "water_depth":"15",
      "final_depth":"1550",
      "production_unit":"text_area_livre",
      "goal":{
         "blocks":[
            {
               "key":"7h93s",
               "type":"unstyled",
               "text":"text_area_livre",
               "depth":"0.0",
               "inlineStyleRanges":[

               ],
               "data":{

               },
               "entityRanges":[

               ]
            }
         ],
         "entityMap":{

         }
      },
      "units":{
         "water_depth":"m",
         "final_depth":"m"
      }
   },
   "pressures":{
      "pore":[
         {
            "quota":123,
            "md":123
         }
      ],
      "fracture":[
         {
            "quota":456,
            "md":456
         }
      ],
      "units":{
         "quota":"m",
         "md":"m",
         "pressure":"lb/gal"
      }
   },
   "sections":{
      "sections":[
         {
            "bit_diameter":"36.0",
            "final_md":358.04,
            "id":"98871d56-0795-4a19-8e04-74d9e98387a6",
            "md_casing_shoe":358.04,
            "top_of_cement":298.0
         },
         {
            "bit_diameter":"17.5",
            "final_md":1310.0,
            "id":"e87b9ee6-c85e-4284-bfd8-e161bd9ecf12",
            "md_casing_shoe":1298.38,
            "top_of_cement":298.0
         },
         {
            "bit_diameter":"36.0",
            "final_md":358.04,
            "id":"9272c954-a86a-4f77-bcc2-6de1fbe39767",
            "md_casing_shoe":358.04,
            "top_of_cement":298.0
         },
         {
            "bit_diameter":"17.5",
            "final_md":1310.0,
            "id":"ac4c5a42-f576-43ca-870d-f927180aa55c",
            "md_casing_shoe":1298.38,
            "top_of_cement":298.0
         }
      ],
      "units":{
         "bit_diameter":"in",
         "casing_diameter":"in",
         "final_md":"m",
         "fluid_weight":"lb/gal",
         "md_casing_shoe":"m",
         "top_of_cement":"m"
      }
   },
   "temperatures":{
      "profile":[
         {
            "quota":1234,
            "md":45689,
            "temperature":78
         }
      ],
      "water_depth":[
         {
            "quota":753,
            "md":951,
            "temperature":458
         }
      ],
      "units":{
         "quota":"m",
         "md":"m"
      }
   },
   "trajectory":{
      "trajectory":[
         {
            "md":147,
            "inclination":258,
            "azimuth":369,
            "tvd":80.76890393770103,
            "horizontalDisplacement":99.74128980911976
         },
         {
            "md":987,
            "inclination":654,
            "azimuth":321,
            "tvd":172.5660925578345,
            "horizontalDisplacement":895.0306693605418
         }
      ],
      "units":{
         "md":"m",
         "inclination":"º",
         "azimuth":"º",
         "tvd":"m",
         "horizontalDisplacement":"m"
      }
   },
   "location":{
      "country":"BR",
      "region":"text_area_livre",
      "field":"text_area_livre",
      "latitude":22.222222,
      "longitude":55.665656565
   }
}
```

## Rig

#### Read Rig

`GET /services/plugin-liverig/assets/rig/view/attributes/{rigId}`

#### Create Rig

`POST /services/plugin-liverig/assets/rig`

```javascript
{
   "name": "rigName",
   "type": "offshore_floating",
   "perspective": {
      "id":"1"
   }
}
```

#### Update Rig

`POST /services/plugin-liverig/assets/rig/view/attributes/{rigId}`

```javascript
{
    "description": {
        "type": "offshore_fixed",
        "company": "free_text_area",
        "maxWaterDepth": "654",
        "maxDrilledDepth": "789",
        "derrickHeight": "123",
        "derrickBase": "321",
        "rotaryTableCapacity": "456",
        "rotaryTableMaxTorque": "987",
        "mudPumps": "789",
        "maxMudPumpsSystemPressure": "456",
        "topDriveWeight": "1235",
        "topDriveMaxTorque": "369",
        "topDriveCapacity": "852",
        "pumpMaxPressure": "147",
        "travellingBlockCapacity": "896",
        "travellingBlockWeight": "321",
        "riserDiameter": "478",
        "units": {
            "airGap": "m",
            "maxWaterDepth": "m",
            "maxDrilledDepth": "m",
            "derrickHeight": "m",
            "derrickBase": "m",
            "rotaryTableCapacity": "klb",
            "rotaryTableMaxTorque": "Nm",
            "mudPumps": "hp",
            "maxMudPumpsSystemPressure": "psi",
            "topDriveWeight": "kbl",
            "topDriveMaxTorque": "Nm",
            "topDriveCapacity": "klb",
            "pumpMaxPressure": "psi",
            "travellingBlockCapacity": "klb",
            "travellingBlockWeight": "klb",
            "riserDiameter": "in"
        },
        "name": "NS-32"
    },
    "BOPInfo": {
        "model": "free_text_area",
        "maxPressure": "123",
        "annularPreventerMaxPressure": "456",
        "floatingStackBOPWeight": "789",
        "BOPStackHeight": "963",
        "LMRPFloatingWeight": "852",
        "LMRPFloatingHeight": "741",
        "units": {
            "maxPressure": "psi",
            "annularPreventerMaxPressure": "psi",
            "floatingStackBOPWeight": "lbf",
            "BOPStackHeight": "m",
            "LMRPFloatingWeight": "lbf",
            "LMRPFloatingHeight": "m"
        }
    }
}
```

## Intervention

#### Read Intervention

`GET /services/plugin-liverig/assets/well/view/new_intervention/{wellId}`

#### Create or Update Intervention

`POST /services/plugin-liverig/assets/well/view/new_intervention/{wellId}`

```javascript
{
   "wellId":"8",
   "rigId":"10",
   "wellIntervention":{
      "status":"planned",
      "type":"drilling",
      "rotaryTable":"120",
      "letDown":0,
      "begin":1571108400000,
      "end":1571713200000,
      "id":"1",
      "responsible":"John",
      "goal":"Goal Intervention"
   }
}
```

## Sections

#### Read Sections

`GET /services/plugin-liverig/assets/intervention/{interventionId}/part/drilling_sections`

#### Create or Update Sections

`POST /services/plugin-liverig/assets/intervention/{interventionId}/part/drilling_sections`

```javascript
{
  "sections": [
    {
      "id": "qui eiusmod laboris et dolore",
      "well_bores": [
        {
          "type": "eiusmod fugiat in",
          "final_md": 34856457.80854535,
          "inner_diameter": 38149169.96576646,
          "outer_diameter": -11202644.999764815,
          "linear_weight": -373684.5672522634
        },
        {
          "type": "in tempor",
          "final_md": -30057372.66422233,
          "inner_diameter": -87908092.58964907,
          "outer_diameter": 89767286.62135312,
          "linear_weight": -82845652.82636
        },
        {
          "type": "velit fugiat elit eu magna",
          "final_md": -35945965.897739016,
          "inner_diameter": 81678908.82004061,
          "outer_diameter": 8622363.191463605,
          "linear_weight": 37537713.7674315
        }
      ],
      "drill_strings": [
        {
          "active": false,
          "begin": 38071806.200362474,
          "begin_md": -80795019.4866724,
          "end": -45771243.61562754,
          "end_md": -96963851.09459259,
          "timeZone": "eu cillum Duis",
          "values": [
            {
              "component_type": "dolor sunt dolore",
              "component_id": "voluptate irure id",
              "length": 47400737.059443355,
              "inner_diameter": 40563882.54742363,
              "outer_diameter": -31249577.08116907,
              "linear_weight": -136308.02520889044
            },
            {
              "component_type": "dolor dolor in cillum irure",
              "component_id": "deserunt ut cupidatat",
              "length": 61659709.744441,
              "inner_diameter": 42986203.0619497,
              "outer_diameter": 20723597.817303434,
              "linear_weight": -46810903.799554415
            }
          ]
        },
        {
          "active": true,
          "begin": -45553204.08967463,
          "begin_md": 59905976.77451587,
          "end": 31893835.644587472,
          "end_md": 58464909.532576084,
          "timeZone": "veniam dolor magna dolore",
          "values": [
            {
              "component_type": "culpa Duis dolore adipisicing",
              "component_id": "do anim quis",
              "length": -62383118.41426358,
              "inner_diameter": -55809906.247426875,
              "outer_diameter": 16040862.983862862,
              "linear_weight": 9072185.004469931
            },
            {
              "component_type": "aliquip tempor",
              "component_id": "do",
              "length": -51897788.244436204,
              "inner_diameter": -80333975.58585285,
              "outer_diameter": -33272654.839477547,
              "linear_weight": 24209494.671944797
            }
          ]
        },
        {
          "active": false,
          "begin": 93079684.15638417,
          "begin_md": 71691296.69739136,
          "end": 10435939.210864782,
          "end_md": -80723218.52034418,
          "timeZone": "proident",
          "values": [
            {
              "component_type": "eiusmod sed ad adipisici",
              "component_id": "in mollit magna",
              "length": 58543187.602945715,
              "inner_diameter": 84048689.1853002,
              "outer_diameter": 57477368.220733285,
              "linear_weight": 33455882.52196859
            },
            {
              "component_type": "veniam ",
              "component_id": "eu fugiat Duis proident",
              "length": -12602885.3509081,
              "inner_diameter": -7210968.257552028,
              "outer_diameter": 55285302.06556144,
              "linear_weight": 19288070.648157075
            },
            {
              "component_type": "laboris enim",
              "component_id": "sed qu",
              "length": 69894977.30894008,
              "inner_diameter": -66858272.09941535,
              "outer_diameter": 46319929.0844678,
              "linear_weight": 2216052.626150906
            },
            {
              "component_type": "qui cupidatat Ut eu",
              "component_id": "elit adipisicing dolor in enim",
              "length": 66114716.33110896,
              "inner_diameter": 87324154.10271114,
              "outer_diameter": -50572628.198778614,
              "linear_weight": 48388689.909178406
            }
          ]
        }
      ],
      "BHAs": [
        {
          "active": true,
          "begin": 19890093.814803928,
          "begin_md": -33990286.03992074,
          "end": 29748184.990219742,
          "end_md": -97058318.975259,
          "timeZone": "irure ut tempor pariatur adipisicing",
          "values": [
            {
              "component_type": "sed occaecat incididunt labore",
              "component_id": "reprehenderit eu",
              "length": 3744545.9973235875,
              "inner_diameter": -9895469.323421136,
              "outer_diameter": 78537568.87577114,
              "linear_weight": -73904251.69630817,
              "tfa": 12080805.661083579
            },
            {
              "component_type": "ipsum deserunt",
              "component_id": "velit",
              "length": -1786520.770352289,
              "inner_diameter": -364002.5150478929,
              "outer_diameter": 18621064.92182152,
              "linear_weight": -58241911.46990416,
              "tfa": -76429309.23638569
            }
          ]
        },
        {
          "active": false,
          "begin": 78052920.65425304,
          "begin_md": 35071811.54163331,
          "end": 19472635.377904356,
          "end_md": -51045308.808439896,
          "timeZone": "nostrud labore eiusmod",
          "values": [
            {
              "component_type": "incididunt dolor",
              "component_id": "reprehenderit non id ipsum exe",
              "length": 53084813.44998461,
              "inner_diameter": 25160905.204087898,
              "outer_diameter": 4671834.920452118,
              "linear_weight": -99525503.5437717,
              "tfa": -58499936.55129597
            }
          ]
        },
        {
          "active": true,
          "begin": 13081749.114166468,
          "begin_md": -80562420.75866136,
          "end": 81436587.51948944,
          "end_md": -74761836.3205758,
          "timeZone": "aliqua ut fugiat enim",
          "values": [
            {
              "component_type": "Lorem incididunt veniam non",
              "component_id": "fugiat",
              "length": 81467171.66213077,
              "inner_diameter": 78112713.01684046,
              "outer_diameter": 32275391.326345786,
              "linear_weight": -41925600.37435018,
              "tfa": -56735549.660556875
            }
          ]
        },
        {
          "active": false,
          "begin": -14366406.148004398,
          "begin_md": -15304555.700870499,
          "end": 41345421.9574517,
          "end_md": -78358564.71515065,
          "timeZone": "sint in irure",
          "values": [
            {
              "component_type": "tempor ",
              "component_id": "aliqua in eiusmod",
              "length": 61787157.09706989,
              "inner_diameter": 58928420.28503105,
              "outer_diameter": 60973648.21203771,
              "linear_weight": -73988484.89573236,
              "tfa": 74835503.86502814
            },
            {
              "component_type": "cupidatat",
              "component_id": "id laboris cillum",
              "length": -2642915.2219287604,
              "inner_diameter": -97015401.63234994,
              "outer_diameter": 31224858.717281252,
              "linear_weight": -81886756.54002453,
              "tfa": -63592923.14403446
            },
            {
              "component_type": "dolor voluptate pariatur ut ea",
              "component_id": "reprehenderit",
              "length": -14932262.486124828,
              "inner_diameter": -63258145.577333204,
              "outer_diameter": 96787901.97280377,
              "linear_weight": 2485155.6236892045,
              "tfa": -30477461.882028446
            },
            {
              "component_type": "amet pariatur Lor",
              "component_id": "consequat",
              "length": 56687260.47991535,
              "inner_diameter": 12842602.288225085,
              "outer_diameter": 82768863.50255078,
              "linear_weight": 17502755.32393171,
              "tfa": -78756640.78446838
            }
          ]
        }
      ],
      "drilling_fluids": [
        {
          "active": true,
          "begin": -11199374.84884508,
          "complements": "aute esse sunt anim",
          "compressible": true,
          "density": -78093308.73890334,
          "name": "esse est",
          "observations": "occae",
          "oil_concentration": 82241291.10861334,
          "rheological_flow_consistency_index": -97171263.59127297,
          "rheological_power_law_exponent": 36726978.106013656,
          "salt_concentration": 32556288.6972889,
          "salt_type": "nulla sint",
          "solids_concentration": -98900265.55201282,
          "timeZone": "ullamco adipisicing ut sed",
          "type": "eiusmod adipisicing elit",
          "water_concentration": 88277728.93819317
        },
        {
          "active": false,
          "begin": -60880528.11029869,
          "complements": "cupidatat ad ex in",
          "compressible": true,
          "density": 76581403.25279966,
          "name": "in consequat ",
          "observations": "dolore aute enim",
          "oil_concentration": -17463073.21050562,
          "rheological_flow_consistency_index": -76073232.95678695,
          "rheological_power_law_exponent": 12285574.9128917,
          "salt_concentration": 37695621.38793957,
          "salt_type": "anim",
          "solids_concentration": -99304795.27665707,
          "timeZone": "sunt esse",
          "type": "dolore proident et",
          "water_concentration": 43659100.86378348
        },
        {
          "active": false,
          "begin": -12404416.588229105,
          "complements": "dolor in",
          "compressible": false,
          "density": 62308684.03343636,
          "name": "consectetur enim",
          "observations": "elit est sed in ex",
          "oil_concentration": -89428773.42035139,
          "rheological_flow_consistency_index": 48810673.296165586,
          "rheological_power_law_exponent": 16273641.947318882,
          "salt_concentration": 83795176.61078727,
          "salt_type": "ea in est fugiat amet",
          "solids_concentration": 1810655.5061588138,
          "timeZone": "dolor ea",
          "type": "labore dolore anim ad nisi",
          "water_concentration": -84260425.41981901
        },
        {
          "active": true,
          "begin": 6563960.037440002,
          "complements": "Excepteur proident",
          "compressible": true,
          "density": 13061810.885608643,
          "name": "anim Lor",
          "observations": "reprehenderit occaecat id",
          "oil_concentration": 28853190.220628873,
          "rheological_flow_consistency_index": 48254581.24564269,
          "rheological_power_law_exponent": 65330245.15249038,
          "salt_concentration": -50550690.380801685,
          "salt_type": "i",
          "solids_concentration": 56213284.72413939,
          "timeZone": "dolor reprehenderit adipisicing ea ut",
          "type": "Ut consequat Except",
          "water_concentration": -47445203.032162644
        }
      ],
      "units": {
        "BHAs": {
          "length": "nostrud consectetur dolor",
          "inner_diameter": "irure elit",
          "outer_diameter": "deserunt",
          "linear_weight": "sed reprehenderit non proident velit",
          "tfa": "dolor in amet id"
        },
        "drilling_fluids": {
          "density": "nostrud",
          "rheological_power_law_exponent": "dolore eiusmod qui sit",
          "rheological_flow_consistency_index": "consequat deserunt enim adipisicing magna",
          "oil_concentration": "magna irure consequat",
          "water_concentration": "reprehenderit sint sunt voluptate ullamco",
          "solids_concentration": "proide",
          "salt_concentration": "ullamco"
        },
        "drill_strings": {
          "length": "est amet",
          "inner_diameter": "in ip",
          "outer_diameter": "ad",
          "linear_weight": "sed reprehenderit non proident velit"
        },
        "well_bores": {
          "final_md": "eu",
          "inner_diameter": "aliqua cillum Duis in anim",
          "outer_diameter": "dolor veniam",
          "linear_weight": "Excepteur nostrud sint"
        }
      }
    }
  ]
}
```

##
