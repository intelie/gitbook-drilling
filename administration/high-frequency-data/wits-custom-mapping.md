# WITS Custom Mapping

This feature allows defining a customized mapping for data coming from a source using WITS protocol. It is important to state that this is not about data normalization, the WITS Custom Mapping is used to create the raw event.

## How it works

WITS data is sent in the following format:

```
1984TESTE
1985
198611111
01081234.56
01290123.4
01301234
0133-1.2
0141-999
019999
313233
9999END
```

Each entry obeys the following convention:

* The first and second digits represent the `wits_record`
* Third and fourth digits represent the `wits_item`
* Fifth onwards represents the value of the mnemonic

Knowing that we can use a WITS Custom Mapping to associate each entry of the above list to a mnemonic and parse those data in the following format:

```javascript
{
 "liverig__metadata": {
   "source_protocol_name": "wits;0;fpsuk;custom=witsCustomMap01"
 },
 "VENDOR1": {
   "wits_record": "19",
   "wits_item": "84",
   "value": "TESTE"
 },
 "VENDOR2": {
   "wits_record": "19",
   "wits_item": "85",
   "value": null
 },
 "VENDOR3": {
   "wits_record": "19",
   "wits_item": "86",
   "value": "11111"
 },
 "DEPTBITM": {
   "wits_record": "01",
   "wits_item": "08",
   "uom": "ft",
   "value": 1234.56
 },
 "MFOA": {
   "wits_record": "01",
   "wits_item": "29",
   "uom": "galUK/min",
   "value": 123.4
 },
 "MFIA": {
   "wits_record": "01",
   "wits_item": "30",
   "uom": "galUK/min",
   "value": 1234.0
 },
 "MTOA": {
   "wits_record": "01",
   "wits_item": "33",
   "uom": "degF",
   "value": -1.2
 },
 "SPARE1": {
   "wits_record": "01",
   "wits_item": "41",
   "value": -999.0
 },
 "WITS0199": {
   "wits_record": "01",
   "wits_item": "99",
   "value": 99.0
 },
 "WITS3132": {
   "wits_record": "31",
   "wits_item": "32",
   "value": 33.0
 },
 "WITS9999": {
   "wits_record": "99",
   "wits_item": "99",
   "value": "END"
 }
}
```

UOM, unit of measurement, can be independently defined for each mnemonic when creating a custom mapping via Live interface.

If there is no mapping for a specific entry it will be parsed as a mnemonic identified by the concatenation of “WITS” + wits\_record + wits\_item as it was done for entries 019999, 313233, and 9999END in the previous example.&#x20;

## Creating a WITS Custom Mapping

A customizes mapping, which will be used to parse WITS data coming from a source, can be created going to `Live interface > Configurations > WITS Custom Mapping`

![](<../../.gitbook/assets/image (450).png>)

Click `New map` and enter an Identifier which will be used to identify your list later. The Identifier cannot be changed after defined, it will be the unique identifier of your custom mapping. The field `Description` is not mandatory, and it can be used to briefly describe the purpose of the custom mapping. After setting both fields, click `Save`.

![](<../../.gitbook/assets/image (320).png>)

Fill the lines according to the rules informed above. Remember that `RECORD` and `ITEM` will identify the entries received from the source and map that to the given `MNEMONIC` and `UOM`.

![](<../../.gitbook/assets/image (359).png>)

| Column      | Description                                                        |
| ----------- | ------------------------------------------------------------------ |
| RECORD      | The first part of the composite key, which identifies the mnemonic |
| ITEM        | The second part of the composite key which identifies the mnemonic |
| DESCRIPTION | Briefly description of the mnemonic                                |
| MNEMONIC    | Mnemonic name                                                      |
| TYPE        | Should be "A" for Alphanumeric, "L", "S" or "F" for number         |
| UOM         | Unit of measurement                                                |

## Editing a WITS Custom Mapping

To edit a WITS Custom Mapping previously created, go to `Live interface > Configurations > WITS Custom Mapping`  to list all mappings available.

![](<../../.gitbook/assets/image (213).png>)

After that, just click the list to be edited and it will show the same screen used for creation.
