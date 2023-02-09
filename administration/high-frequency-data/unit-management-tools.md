# Unit Management Tools

### **Introduction**

A feature to manage units of measure and unusual conversions. It has three main functionalities, [**Unit extension**](../../deprecated/liverig-v3/2.29.0.md#unit-extension), [**Unchained unit conversion**](../../deprecated/liverig-v3/2.29.0.md#unchained-unit-conversion), and [**Unit alias**](../../deprecated/liverig-v3/2.29.0.md#unit-alias). These features provide a way to create and edit new units, aliases, and unusual conversions via LIVE web interface. It can be found under menu Configurations > Unit Management Tools.\\

***

![](https://lh5.googleusercontent.com/\_\_5M4YoF11yYYH23ryLr7BlDURvrs9so8N\_jcr8Of-kmVHJfReVgYbTSYi0BR2tUhSntHhd27Jbf-EwZoSq4kaaCdefx7EwPIyHJefa74aNSDtk-rW9tT\_zoj\_tN-S2jMGTG\_qDt)

### **Unit extension**

It allows the creation of a new unit that does not exist in the system yet. A valid base unit must be chosen for the new unit and also a valid conversion factor must be defined to that.\\

***

![After defining the name and values, the new conversion can be tested on the bottom](https://lh6.googleusercontent.com/2cEoc7LV0pUZ0MA0nPNLDQRqXiDU-3Hs1Mfn3knGrOewJKi9vP9fRi4oafUsYL\_j-qqk-iuH4bwaAcBmyhWnBbTPrO8FXa2lfsn2rpnVZ7p3obrW6UMkff2s-dzJ\_1X6MU0jLaj5)

***

The new unit will be displayed in the list after creation.

![](https://lh3.googleusercontent.com/2MTfCoQ\_kuDL79ipr95YZPdse2EgB5pR3NaWS\_ox0szYpjZkORbmfrGc3VulmIwPg439cNOEnxnJXzp5h\_rp0LCsvttp62DoSE0rQilhDcAoQDWusPcg93twkY0Tx3EiKrl4FQ43)

To delete a unit, just click on the garbage icon of the desired item and endorse your decision on the confirmation box.

![](https://lh4.googleusercontent.com/bv9MedxELCkT22pq6pJvNOjmD8Tw6eQfw8HS5Yu\_A1lBisfu\_Rgx4EhxAx8vsfmtW42ant\_g1012u8VQyNCutp7CwO27CRy156Xoi-r3rgrUffJJG-0WQs1dxyT8t73whkrZz\_sk)

### **Unit alias**

It associates a new word to a valid unit in the system. It is possible to create an alias for a common pre-existing unit like kg, N, m3\*\*,\*\* or even a new unit extension as created in the previous session.\\

![Creating a new alias for a common pre-existing unit](https://lh6.googleusercontent.com/Oo2Wpodj8eCKHgsCz3MVSwxniQkekV22rv2zhb9vevRfLuGlLmvSq1RCcLD-h5\_tSwBGXSegGna4Rsw0tdZgNlEblCPvNH1B7073A1\_bjs2TVZs6d3dbYRSNoWh0t2g0o6VjWk9d)

![Creating a new alias for a unit extension created by a user](https://lh3.googleusercontent.com/iX16KtwJn9AkdftjEFos10rviOndgoP4KtSjsMzzmQYhUoTFF6wKKzsYJfKGKVVpg-CsbBb7fOJMn5uAiCrcJdE3wkqY5iEvNg-U7mj-mvhgon46VYgXmTP9yf0EQCbkuAs1g2Vp)

The new aliases will be available in the list after creation.

![](https://lh3.googleusercontent.com/kBuv8GCuhvEa2P9Ov9IaUgPOfPGax2XK1bL7ohv2TM7jRk\_XL2CocBiftQWMdpHepiDgTTyqfgFiFbv9pd8exqMNrDULVz7IITYEJ-WdnZkEao\_ei8pi0RV3J9hcT-o3jKZasbCZ)

To delete an alias, just click on the garbage icon of the desired item and endorse your decision on the confirmation box.

![](https://lh6.googleusercontent.com/uXFPLuhFia1Bh3Kt43xtno56X0tOArFtVqlkouuaiw0e4gsp962wBQwEYv7ChsDtC83cd94NW8gKmGpWw7x2--\_z5gFHYd5fbPh0\_XcvUVKWY4nrTuVi8K\_3sIc39gb9DOxcvva\_)

### **Unchained unit conversion**

This feature provides a way to create unusual conversions in the system. For example, in the native system, it is not possible to convert from kg to N. Using this functionality we can add the conversion for that. Unchained conversions can be created using only base units.\\

***

![After defining the parameters for the new conversion it can be tested on the bottom](https://lh6.googleusercontent.com/VD\_soD83iuUIJYbxHdzL1vf4\_UZKRSjUXovU\_DychmrTVr0q03-B5j-I\_HypvFNdvVoPZBo49Z8RSf-kZ-dqVFQLBcj7KIO3m0Jwy6257HCGICjl2UWNU\_OMBiLtuWEqqhKxQBXt)

After creation, the new conversion can be seen on the list.

![](https://lh5.googleusercontent.com/tcUpStSE2JsWe-Qxg9LQ\_FYLeDbMW2IDovbuKjJv-Vh8u\_TYrc-iZTitMgBHLm4vxDEZzOT9UUvqreJ8E13rLfPv9Rj7q\_D4YoPFnqh9SsoRCQ4Oi46OsNLP\_60rPDje4ePuqyHV)

Although the opposite conversion is not displayed on the list, internally, all conversions created in the interface are bidirectional. It means that when you create a conversion kg -> N it is automatically possible to convert N -> kg.

![](<../../.gitbook/assets/image (98).png>)

![](<../../.gitbook/assets/image (87).png>)

To delete a conversion, just click on the garbage icon of the desired item and endorse your decision on the confirmation box.

![](https://lh5.googleusercontent.com/wQ9Ou7XB\_IPPaskVpFQ82Wjvei7Z0Y4mbhUbkmBlCzXz2gsWdlRD8BdL88fo1Snj9ONJazzyjNf1co4crZwG2y\_uMfzVm23uGwzLO-NGjC2ef2bdvpoFDXalPc6jg01FeZ6awftM)

### **Conversion tester**

At the bottom of the left panel, there is a **Conversion Tester** utility. It exercises the conversion. You can choose any builtin units, new units, aliases, or custom unchained units to convert to and from.

<figure><img src="../../.gitbook/assets/Screenshot_select-area_20220908181916.png" alt=""><figcaption></figcaption></figure>

![A conversion using the new unit previously created](<../../.gitbook/assets/image (477).png>)

![A conversion using a custom alias](<../../.gitbook/assets/image (447).png>)

\*\*\*\*\
\*\*\*\*It is also possible to combine the features during a conversion:

![Here we use an alias, which points to kg unit, to perform an unchained conversion](<../../.gitbook/assets/image (506).png>)

### **Pipes function**

The function, `curve_unit_convert(<number>, <string>, <string>) -> <number>`, receives a number to be converted as the first parameter, a string that is the source unit of the conversion as the second parameter, and, another string as the target unit of the conversion as the third parameter. It returns a number as the result of the conversion.

![Performing an unchained conversion via console using the Pipes function](<../../.gitbook/assets/image (505).png>)

### **Normalization and Dashboards**

Since 3.1.0, normalization/dashboards are being affected by this new feature!

### Side effects of deleting and renaming

At last, it's important to mention the known side effects of deleting or renaming a unit alias or an extension, or deleting a conversion.

#### At "Standard Channels" and "Calculated Channels"

The unit is no longer recognized by Live, and, then, will be displayed with a warning layout.

![Unknown unit warnning](<../../.gitbook/assets/image (44).png>)

#### **At "Data Management"**

If a conversion, unit alias, or extension that is being used to "Data Management" is deleted or renamed, the interface and the normalization threads the unit as Unknown

#### **At "Display Units"**

If a unit alias or a unit extension that is being used at Display Units, and is deleted or renamed, dashboards that use this "Display Units" will fail:

![Dashboard showing "No Data" because the Display Unit contains an unknown unit](<../../.gitbook/assets/image (489).png>)

And the Display Units will prevent the user from saving until the unit is changed to a known one:

![](<../../.gitbook/assets/image (269).png>)
