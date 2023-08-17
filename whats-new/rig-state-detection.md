---
description: >-
  Live provides the rig state detection to help to analyse the current and past
  well states and safety
---

# Rig State detection

The rig state plugin can be found in the [marketplace](https://marketplace.intelie.com/artifact/plugin-rig-state)

## Operations feed

The activities will be displayed both on the rig and on the well interfaces. They are available under the "Operation Status" tab.

![Example of the operations feed](<../.gitbook/assets/image (45).png>)

{% hint style="warning" %}
This feature requires that the input standard channels are [identified](../administration/standard-identifiers.md).
{% endhint %}

In this feed, it is also possible to add, delete and edit operations, even those that were detected automatically.

{% hint style="info" %}
If the data is normalized by rig, the operations will only be shown on the well interface if there is an active intervention, and vice-versa.
{% endhint %}

## Configuration

INTELIE Live provides two different algorithms for detecting the current drilling activity. It is also possible to add and edit those activities manually. Their configuration is accessed on the Configurations menu, as the image shows.

![Rig state configuration menu](https://lh3.googleusercontent.com/Ol9YkUfQfVIwAJrwIzw9\_B4P06J-o2-VYkBwVqPWdDjNBc7yJNSS8G0cW3dAhfnYjx9s0a\_IqlKw-0BnlcEVtD6krm9nWhosiRw81xy\_9ec1nXvAtOMhEb7dDz4QlDTm2kNf9GrP)

For each algorithm, several parameters are available for configuration. It is also possible to change the output operations names and colors.

There are examples of usage of each algorithm under the "How to use" tab.

![Example of algorithm configuration](https://lh6.googleusercontent.com/urEknCk2rvoigNXIvRfTB8JRXGrQQ3Db4gg-WazottJmO\_I\_Vae6-fKHBAMn8xNkI8Onei\_i4H3x\_xx4eo2LX-gkFWH2kDflr2oCg-g3AsHS617yAlTvnp2Bp2S-LvKuf\_tQnp8t)

For the default algorithm, it is also possible to enable and disable the operation auto detection, which populates automatically the operations lists for rigs and wells.

{% hint style="warning" %}
With version less than 2.26 the rig state is at plugin-opmode with other nomeclature.&#x20;
{% endhint %}

## **Rig state detection configuration by rig**

At the rig menu it is possible to access the _models configuration_ to change the values used by the physical model algorithms to identify the rig state:\


![](https://lh4.googleusercontent.com/REkpOzvf3wvD2A4Prd6GeYtBF3CXzx0LKGEklgSR6lZ4Nr98N711-jxW1GNyS\_xBvPCjqv0AHS3MRbVxs-r5\_R2lCddM\_H099ekKCLks6siQD1hAAxusrA3kuGAoWmPB6nyp578q)

It is possible to overwrite only the parameters for the current rig. The parameters that are not overwritten the globally configured values will be used. There are two parameters that are presented as read-only, since they are editable at the Derrick configuration at the rig screen tab:\
\


![Physical models configuration for Rig state detection](https://lh5.googleusercontent.com/Bs0mC46ASkWnf-AQ3V2SZtWgJZooxx76P4L9YFD\_C2DFJqTvx2UFg0qSVQIFoOsiVEbKnyOV3BX8C9GsA\_PLe8n\_8i4A3SDwfGZwnUf8iNCRcYWL1zE4L1HZvqsPlyQuId-eIpzQ)

It is also possible to enable and disable the algorithm calculation per rig:

![Models configuration at rig parameters tab](<../.gitbook/assets/image (500).png>)

If the rig is not enabled, a message will be shown at the operation status screen:

![Operation status warning of rig configuration](https://lh6.googleusercontent.com/wLPcm6RK4YNR3qBxOq2cpGsTNvOPKVW2WvUpD2uKUktWh6s1XN0IVgM3BqKnL8VMYcVYVQdburWgyNgp\_LkY39ucg6l57mzwLpgR5elxH9j2b7Ui4qvwh28A4CV7di4ZifRCXxi-)

Derrick parameters  stand length and pipe length are configurable on the rig screen at the Derrick Information card. If they are not informed the configured global values will be used.

![Derrick rig state parameters](https://lh5.googleusercontent.com/LixiVD5tgSAzUdM1cpCe0-G5csvXdK1A7rKtRASSn4wXhMQ\_wstEIlhrgDWYWtgvLUWUHAVUVrw4qQD\_gOdIIyxHUOWngvzEG-qOduloUKQ25eqq6ox1V5SMUolwHceBK6cXLyQj)

## Pipes functions

The old opmode functions are still available for compatibility reasons:\


* drilling.normalized\_opmode

![Pipe function: drilling.normalized\_opmode](https://lh3.googleusercontent.com/v5hJ87RlXSCTz-z9yVQjJrV1CB-lt0Mwu5hGvtvl\_aBKGb5jBvlzcoWJ-BvSC-LdlFfVhLPAvZmAhJwMkEwTyzI-4fpOHMAq4eCdh8ZqALlyXfFSwXoH\_cBADEqlxVt71\_8IafzV)

* normalized\_operation\_mode

![Pipe function: normalized\_operation\_mode](https://lh6.googleusercontent.com/zUNdKxC0Z3pUYbFbK9CamQnQ13a6XL9M1wj48tuosLWScweRy-H0UCk8-otz7AmFY6WOLu-86ejiMvpYk5oJm4KR8EKMZkUFh4ECQKDAOZYxxkO2izMglau7MEy9o48wBCX-8lMG)

To use the configuration of a specific rig one can use one of the functions that receive the rig name as the first parameter:\


* drilling.rig\_state

![Pipe function: drilling.rig\_state](https://lh5.googleusercontent.com/kjVlk9mbIh1d7y7-eDr5DbKTPtVoNky1WAKAzm2vOERUR\_CPAuPZNKhQEZuMqpHWSA6a5ax5h20UZ9wrbNyEg6MtEm9aLXwsibpY5zaVlxOykQ6JkA7f8IIk8ZHpCgZI4\_x6SDIQ)

![Pipe function: drilling.rig\_state](https://lh6.googleusercontent.com/afKFKdOzlYXCuflqfKU0bpdMzLYOs-cfxaDBm9aGIMduqF6U4Ev2kBtclwMsqnYdnUW\_RZCTk\_k41jNqQ24fYWky55FvbmMUVZIj3PRbEO4TRtxuQcwCAS8nNluWmb0XSSSqNMli)

![Pipe function: drilling.rig\_state](https://lh5.googleusercontent.com/OBkrORSICqVEiOCsjHnffCIQMJa26ufojVNUcVfkC08-0vPRzVoKWN-TWUXWsneqbKYwsCVazYQmPEMChuD28G8nG4BsXn4-c2bwose0lSVCr3tilR3BO8CbzYz-CW9WAq9jb\_C5)

* drilling.normalized\_rig\_state

![Pipe function: drilling.normalized\_rig\_state](https://lh4.googleusercontent.com/Sz68bfsi4k1o3FEhVs5\_NzzePgV4XswKC9Z1ueIOBKtGV0eVTb4z4dkegfDf35ReNFhauAMruT7Igf5HSKMwGjWFwIFvJwao4wGESAev1phAmYTmC1xAdiQKk7Aa-P7jHKHzXBmN)

Above an example of the query used to retrieve the rig state of a rig by name:

_def @@mnemonics: (@@channels.weight\_on\_bit, @@channels.hole\_depth, @@channels.rotary\_speed, @@channels.rate\_of\_penetration, @@channels.bit\_depth, @@channels.fluid\_flow, @@channels.block\_position, @@channels.weight\_on\_hook);_\
\
_**event\_type** .timestamp:adjusted\_index\_timestamp mnemonic!:@@mnemonics_

_=> expand drilling.normalized\_rig\_state("**rigName**", adjusted\_index\_timestamp#, mnemonic, value#, uom, @@mnemonics!) every 15 seconds_\
_=> @set operating\_mode != prev(operating\_mode) ? random(), 0 as r_\
_=> @throttle 2 min by operating\_mode, r_\
_=> @filter operating\_mode != 'UNDEFINED' && operating\_mode != null_\
_=> @yield newmap(operating\_mode, 1:object(), 'timestamp', timestamp#, '\_\_color', newmap(operating\_mode, \_\_color)_\


![Pipe function: drilling.normalized\_rig\_state](https://lh4.googleusercontent.com/3MaXl\_6pO9zmOEitCQnUgS8sk7Nr-zQN2yFiMMqInhbrBnaiFh7XWGX2g4bZ1PHrmuEG3jPCoNc1\_38RN7wW1p\_dfF7IuwlDnG68ZqqDU1SrrzKTIIS6N9BO8iBaz9ikjGsAK3Oa)

![Pipe function: drilling.normalized\_rig\_state](https://lh3.googleusercontent.com/JX1NA8Mq1n6eJjmxeyMeZK4Q13EFM5hpnEPMz9iCAliG-rRt2jDo-RWWGJJQdR22nwW6n8YRWoCrlni10UKUnNw8-V0fPTZyrytY2TcTgq4FVi0dRGBcU8joiwYxdf0Zh6eolZxY)

## Dashboards

In the following image, it is possible to see the result of the stand length changed in the rig configuration, for the same time period on the dashboard the representation is updated due to the new value passed to the physical model algorithm.\


![Rig state detection comparison using algorithms and configuration by rig](https://lh5.googleusercontent.com/BplQUBtDWJO56u95duth23egTqvDPQifw0w6RtXGY\_pjQ1URn\_WZG2ZevUCl7Qcf6F02kGQss0r3eItl\_XfmADBuCiCv\_wMNeYp8UM\_l36xVUoVPMN7PI-QYeL7-Pq7tDnpapv\_z)

## Unit configuration

It is possible to configure the rig state detection units constants per rig&#x20;

![Units configuration for rig state detection](<../.gitbook/assets/image (352).png>)

## Default Value - RigState Parameters

This topic describes how to configure the Rig State detection and it defines all parameters considered and how they impact the Rig State detection.

|           **Parameter**          |                                                                                                     **Description and use in RigState**                                                                                                    |
| :------------------------------: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
|            Pipe Lenght           |                                                                                                   Drill pipe or Casing/Liner joint length                                                                                                  |
|           Stand Length           |                                                     The number of drill pipes or joints that compose a stand. If the bit depth moves more than one stand 'is tripping' is set as true.                                                     |
|           Block Weight           |                                                Weight of Block or hook load when the drillpipe is 'in slips'. It is the sum of Travelling block weight and Top Drive Weight (Derrick Info).                                                |
|        Minimum Fluid Flow        |                          <p>The minimum fluid flow to set true as 'is circulating'. </p><p>Flow rate > minimum fluid flow --> is circulating </p><p>Flow rate &#x3C;= minimum fluid flow -> is not circulating</p>                         |
|       Minimum Rotary Speed       |                    <p>The minimum Rotatory Speed to set true as 'is rotating'. </p><p>Rotatory Speed > minimum Rotatory Speed -> is rotating </p><p>Rotatory Speed &#x3C;= minimum Rotatory Speed -> is not rotating</p>                   |
|       Minimum Rotary Speed       |                    <p>The minimum Rotatory Speed to set true as 'is rotating'. </p><p>Rotatory Speed > minimum Rotatory Speed -> is rotating </p><p>Rotatory Speed &#x3C;= minimum Rotatory Speed -> is not rotating</p>                   |
|       Minimum Weight On Bit      |                 <p>The minimum Weight On Bit to set true as 'has weight on bit'. </p><p>Rotatory Speed > minimum Rotatory Speed -> is rotating </p><p>Rotatory Speed &#x3C;= minimum Rotatory Speed -> is not rotating</p>                 |
|          Minimum Torque          |                                         <p>The Minimum Torque to set true as 'has torque'. </p><p>Torque > minimum torque -> has torque </p><p>Torque &#x3C;= minimum torque -> has not torque</p>                                         |
|    Minimum Standpipe Pressure    | <p>The Minimum Standpipe Pressure to set true as 'has spp’. </p><p>Standpipe pressure > Minimum Standpipe Pressure -> has standpipe pressure </p><p>Standpipe pressure &#x3C;= Minimum Standpipe Pressure -> has no standpipe pressure</p> |
|    Minimum Rate Of Penetration   |                   <p>The Minimum Rate Of Penetration to set true as 'is penetrating'. </p><p>ROP > Minimum Rate Of Penetration-> is penetrating </p><p>ROP &#x3C;= Minimum Rate Of Penetration -> is not penetrating</p>                   |
|      Bottom Depth Tolerance      |             <p>The threshold to define if the bit is on bottom or off bottom. </p><p>Hole depth - bit depth > bottom depth tolerance -> off bottom </p><p>Hole depth - bit depth &#x3C; bottom depth tolerance -> on bottom</p>            |
|        Movement Threshold        |                                                                          Movement threshold is used to define if the bit depth and hole depth are constant or not.                                                                         |
| Block Weight Tolerance Threshold |                                                                                   Used to define if the hook load is near Travelling Block Weight or not                                                                                   |
|     Hook Load Ratio Threshold    |                                                                                  Used to define which variation the hook load is increasing or decreasing                                                                                  |
|        Connection Timeout        |                                                                                                           Maximum connection time                                                                                                          |
|         Minimum Operation        |                                                                          Minimum time to leave of one specific micro rig state (minimum duration of the rigState).                                                                         |
|      Low Bit Depth Threshold     |                                                                      BHA length. When bit depth is lower than this length the rig state is defined as Column Assembly.                                                                     |
|            Data Period           |                                                                Data periodicity (1s, 5s, etc) - Used to calculate the Sliding window length. Impact on OP Mode switch delay.                                                               |

## Default settings and guidelines for adjustment per rig

|           **Parameter**          |                 Default Values                 | <p>Guideline </p><p>Range (Metris)</p> | <p>Guideline </p><p>Range (Imperial)</p> |
| :------------------------------: | :--------------------------------------------: | :------------------------------------: | :--------------------------------------: |
|            Pipe Lenght           |             <p>9.14m</p><p>30ft</p>            |                 7-15 m                 |                  23-49ft                 |
|           Stand Length           |                        3                       |                   1-5                  |                                          |
|           Block Weight           |    <p>250000N </p><p> 25tf </p><p>55klft</p>   |                10-100tf                |                22-220 klbf               |
|        Minimum Fluid Flow        | <p>0.0008m3/s </p><p> 50lpm </p><p> 13 gpm</p> |               30-150l/min              |                  8-40gpm                 |
|       Minimum Rotary Speed       |         <p>0.21 rad/s </p><p> 2 RPM</p>        |                 1-4 RPM                |                                          |
|       Minimum Weight On Bit      |  <p>2000 N </p><p> 200 kgf</p><p> 440 lbf</p>  |               50-500 kgf               |               110-1100 lbf               |
|          Minimum Torque          |        <p>500 N.m </p><p> 370 lbf.ft</p>       |               200-800 N.m              |              150-590 lbf.ft              |
|    Minimum Standpipe Pressure    |  <p>500000 Pa </p><p> 5 bar </p><p>73 psi</p>  |                2 - 7 bar               |                30-100 psi                |
|    Minimum Rate Of Penetration   |  <p>0.0003 m/s </p><p> 1m/h </p><p> 3 ft/h</p> |               0.5 - 2 m/h              |               1.6-6.5 ft/h               |
|      Bottom Depth Tolerance      |          <p>0.45 m </p><p> 1.5 ft</p>          |               0.3 - 0.7m               |                 1 - 2.5ft                |
|        Movement Threshold        |           <p>0.2 m</p><p> 0.7 ft</p>           |               0.1 - 0.3 m              |                 0.3 - 1ft                |
| Block Weight Tolerance Threshold |                      0.15                      |                0.05 - 10               |                                          |
|     Hook Load Ratio Threshold    |                       0.5                      |                 0.1-10                 |                                          |
|        Connection Timeout        |          <p>1200 s </p><p> 20 min</p>          |                10-60 min               |                                          |
|         Minimum Operation        |           <p>10000 ms </p><p>10 s</p>          |                  5-60s                 |                                          |
|      Low Bit Depth Threshold     |           <p>400m </p><p> 1300 ft</p>          |                200-600m                |                650-1970ft                |
|            Data Period           |                       1 s                      |                  1-20s                 |                                          |
