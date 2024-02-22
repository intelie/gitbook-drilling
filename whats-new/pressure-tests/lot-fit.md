---
description: >-
  Lives provides Leak-Off Tests (LOT) and Formation Integrity Tests (FIT) for
  well integrity analysis
---

# LOT/FIT

{% hint style="info" %}
Requirement: plugin-pressuretests 2.28.0+
{% endhint %}

### Introduction

While drilling a well, the rock wall are under effect of compression and tensile stress by the drilling fluid pressure. LOT/FIT are pressure tests to ensure the well safety and integrity to avoid problems such as:

* rock collapse
* lost circulation
* shear rock failure caused by compression stresses
* fracture failure of the rock by tensile stresses

LOT pressure test is used to determine the strength or fracture pressure of the open formation, usually conducted immediately after drilling below a new casing shoe. FIT pressure test is used for testing strength of formation and shoe to designed pressure, or the maximum pressure that the wellbore can withstand with regard to the casing setting depth.

To maintain a small safety factor to permit safe well control operations, the maximum operating pressure is usually slightly below the leak-off test result.

The region of the graph bounded by the fracture pressure curve on the upper side and by the pore pressure curve) on the lower side is often referred to and defined as the _Drilling Operating Window_ :

![Drilling operating window for well stability with pressure by depth graphic](<../../.gitbook/assets/image (490).png>)

![Wellbore Instability collapse and lost of circulation in a pressure by depth graphic](<../../.gitbook/assets/image (385).png>)

LOT/FIT tests help to keep the well in safety region of pressure by depth and to find critical points.

Above is shown a typical pressure-volume curve with LOP (Leak-Off-Pressure) point and FIT (Formation Integrity) point. Next is shown the fracture propagation and the when the pump stops.

![Typical pressure-volume curve in a fracturing test.](<../../.gitbook/assets/image (404).png>)

Understanding the implications of mud weight, pore pressure, and fracture pressure is important in pressure management and well control assurance.&#x20;

## **How to use**&#x20;

### **Enabling LOT/FIT Add-on**

LOT/FIT add-on can be added to temporal channels charts in edit mode.\


![Editing widget to enable add-on feature for LOT/FIT](https://lh6.googleusercontent.com/FCqfyvsrkj7R6W\_A7Uow3EQqvRcZnOm6NhjRLA4SjfD5eMySLxpXBTvI3\_LP6\_dPI5-eTkZWzTVPCNAcJhdVJKEGMyLC-0Igp98nCzOLDZU67xrsrmJ6XQonYIwX3F9vmCn3O5Ye)

Select Leak-Off / Formation Integrity Test option:

![](https://lh6.googleusercontent.com/AFCsIKjWlI4JMQOOeS2jZtj4feJn9swchEirprnPWMYhwnDmYcCY3xiIUdR7olNYC19zLpLIDLZe3ERcL\_y8OQK2XNRLMra4RWuH1ja6AGi9Z0P1CtO13iGsOkviq2y6Yb97Nb8j)

![Add-on for LOT/FIT tests](https://lh6.googleusercontent.com/D8LELHM6t\_NdDQ5qnay7ImYsXKoFMox5ycT9DDTmDQQoBxI1kcJIJETL9vP86A98RAiTT-Djp0fgmxvlQ-yRBnSbEXsWKpdAJeR3nBdjFEP5TkgcLqfcvZGhzba36pZGDl5iDYJZ)

Save and go back to dashboard:

![Saving the widget](https://lh5.googleusercontent.com/OX0u\_YdEu7EZzK6MJ7nrjF9Qd6n9HpT92n\_614etoCvCxDS1ZPCoHBEM-opms5u3Iy6Vmxx1CbBL0u8pU-EIPJ2q6I2EBaIrqgOeWDLfcxZepUMqo\_dir5N5vmR8KBFvZLLN3Z9i)

\
Once the LOT/FIT Add-on is enabled there will be a new action added to the widget “Automated Tests”:

![Automated test option enabled at the dashboard for LOT/FIT tests](https://lh3.googleusercontent.com/Dmx1\_cJ-pudDZkbU9I54yvFCu0w\_1BBDXY5YsRJ0N9LEzcsB2-bs-PCqLwKNtMLR4wSodSkfiVKiVxguROli26adFmVEX2Q1E-hOQvLWOnV06Tl52TfiOCw7Ca5t7ybNcUljieC6)

Clicking it will bring up a dropdown menu

![Automated tests details](https://lh5.googleusercontent.com/XSQipmdy93U3NiowakRbhgXOQtziEMJ097Ha\_WxgOZ3pq7DYei\_8TG\_GqdPw7QL4VXAQsdy99toAkh5TEA7QuKW0k3nrGfXsEoYKnmTrmZOxaKUKtVvRtBaIEN-gUsWZp599m5Yi)

Select a test type:

![Choosing test type LOT or FIT](https://lh6.googleusercontent.com/jiH\_Nfh4RKAu9HgYdiwQgmvlU467Fr4GfExanatKAbeTGImP4nmL5CnnHHhFBzbMD\_LKH4HLyE\_YQL1Zd5KI6b8R0aOEWLernDvlbv0prW90pK\_DXVidaoZWy5e2Q5NryCzSHwLs)

### **Leak-off Test (LOT)**

After choosing a test it is possible to select an interval to run the test on.&#x20;

![Warning to select test interval](https://lh4.googleusercontent.com/oO9C8xNHMFv3WWDpt7UQlnjTnBxKud1nTit5MuSNrqHC8iOiufUNj3OdX3zQI9m7m4gyCEmDaKqFWhSZCWcO2o9sdutjv6kdouu5hW2l99KiuRbQ-TrjtfUse1C12q0HX\_ORqnZY)

Simply click and drag to determine the interval:

![Interval selecting ](https://lh3.googleusercontent.com/ta\_9IoX44Pp\_0gXqocEr-mUFBThIePrmT09FBhybhhVkBPHAB-0L5VBmb9HO0Y6lZB\_2RjscrYgmC-Yv9S2tjeW6M9mvWaR-LBsvBpQuptj8f-fwfnFxf0ciu\_LS-n2b5lU41fxF)

Next it will be presented with the calculation parameters. It is possible to inform tvd casing shoe, md casing shoe, mud weight and which asset and channels the test should based on. Also it is possible to disable pressure loss calculation and configure units:\


![MD, TVD, Mud weigth, pressure loss enabled and units configuration](<../../.gitbook/assets/image (360).png>)

Next it is possible to select the linear portion of the interval:

![Selecting linear interval for LOT test](https://lh3.googleusercontent.com/5cAAxKJcMNhnRQ8Lyn9LWIJ3Ii9m0bQpo1Hp820AyHPuE\_1DfPN0N-6yURzzgFen3VNwE\_wgHt6nfIAdOVWxJ\_\_v\_bnWaCv2DO9\_2WYXwHIPniaU32a7nXb2huW0phO9EitCRdOb)

Now the system is able to display the preliminary results and also the EMW :

![LOT results](https://lh5.googleusercontent.com/9pM-Ae69qnPeT0Y0sC9GyEl11Aifm2iZZZxt8k6EyeAyw1XrVBzfrCqiDP3uGeRBeVE7WO-p-d19C47s\_MN5L\_9EB9dzMKMvLLzKj-hqaFUvJrsRjXo09ver6YZrvBH9i3T\_x2cv)

![LOT formula](https://lh4.googleusercontent.com/CW0jQbZAthtrdTCoy-k\_b8QWyZmJdxOoeDIqeaRD6wDcIRkMBbEai\_pOvzIIgaQRXxilh0CpC83FmUB1Dt201OaJtPGxV6q5m1YahOncGIq-chf1O5QTbWqmwM\_yKh76KaxnBrcc)

It is possible to comment and save the test as a note.\


![Save test as note](https://lh4.googleusercontent.com/poBZGtdUQ7YaRy9vBwjRxiGsE0B9RnmDOyS4b6rlEbgNuPgzG\_yuThmaO1lPfzFFyWvxxHeikvuKqQ93VTc-CarTa9JtGeww-Sqn0-Umn99BXFk8Nywtg7qxHidOtGhZl8PTxgSE)

This note will be displayed on the dashboard timeline:

![LOT note at timeline](https://lh4.googleusercontent.com/BBhyBvqvz49FVhTEOpR3VzzNM8lxsgOdvzZ9dQGN-jYSRbRqpDezJh5BN-jD-\_OKQ5YshvWPasB-mQrOPYs7--h-Bf-KMeKtoDpJEy1qZrCg0z80fWTBD4QlAbCfmrbBm\_4jjtFk)

The comment field can also be edited later:\


![](https://lh3.googleusercontent.com/w1hrdle4Ow3XjLvN\_rYsAIxetst0uZiChqqExJTbh3i62Di3JhvUMWijG53WFzGJQscLMGKRjPgiW1Tu8T5dml1CBQAfqriyV\_30mpZl5YW2Z8bB4gDQQzQQQVEGuPaJqCLPOqpf)

It is possible to adjust the fitted line or the results by selecting the interval span or edit the calculation parameters. Adjusting the linear interval is possible by dragging or resizing the interval marker:\


![LOT test result](https://lh4.googleusercontent.com/Nj--\_MnI--i-pyGr-9LfJfW5nF4l9aa-oGLx3WtNWx2y6AeQKSaqetjfoe0sNhqsHITl0GIKCsuJB1nZnAgaxze1n74rG3S5EDSnqpFmWGUbmyJUptoTOl8LVtDodkTmQGILHUDl)

It is also possible to manually override some constants used by the algorithm by clicking “Edit custom parameters". It is possible to override the leak off pressure found by the algorithm, pressure loss window and deviation threshold:\
\


![Advanced calculation parameters](https://lh6.googleusercontent.com/9e2YBznXp4b8NY\_\_mD5956mrhmcKrrnAHxTSCJ2dYLWjyonV3KRi2d0AgW7E5IVLsA5ZzkRLsP4oyIAPyyX\_RjG8K1FDQhiolgAmpolci0-iSzaCJVie\_LEFst\_A8IYWrjGdcqLf)

### **Formation Integrity Test (FIT)**

Another possible test is the Formation Integrity Test (FIT), the usage is similar to the previous test where it must also select a period of time over which to test then select the asset and channels to test, but this algorithm does not require to specify a linear interval. \


The result is shown below:\


![FIT test result](https://lh3.googleusercontent.com/-82FuAV5cuUeZmjy61IKszPtio7dU9Nb\_X9SPE1A71OiJfviVL24MLnnaBGSbTGSxPJYz2LNCAPSeMF3FUloRzpCQI9N\_47zKly0mfnAeJfMXKnSBb1MgKTGua3cYtWiXKDMP4R1)

Like in the other test this result can also be stored as an annotation:

![FIT Test note detail](https://lh6.googleusercontent.com/Fm6ffn7AFe0g3OiOwBZPLtvn36YEnD0rXQ-KsTEvOFWRuP9YoKo90m93kVl7M8Wz8a6Y2w55-IAM-N30Nejn1Xkb0805VIhq6hJqv57gpBqxsSpvi-qT8nsA9UckjvpPWH-ZkV1J)

LOT and FIT annotations differ by the shade of purple:

![Color of LOT and FIT Notes](https://lh6.googleusercontent.com/8BxnoHBfvXq-ULW-ydrWpCpgRbcIwHgpTVA7rIaok5FimoMrhXq6GUgU1gjucoJFXDcucDqzLh7Opi2JKiKzPg8IqpRkVSGxuwF-klG-FvFpk5UVg0F5UO09yaHKh1FHoHvWzpbt)

In the messenger global room the annotations are rendered as follows:\


![Notes of LOT/FIT at the messenger](https://lh5.googleusercontent.com/ippxd3qmKfkoYKKlLtHJw94GdI9MbJ-epEG9DTZNn90a54E2QKUjCrErYJWt67yGCetmIjNn\_KnPYbdj8xxl0UzwnAAcIOJt3kCWHTPDjg11zNhMJTNJvkFc\_oBQJ2my5cuLVxBl)

It is possible to view the details of each test annotation

![Test detail at the messenger](https://lh6.googleusercontent.com/v5bLnbLpw1Uh1buKcPLcN03UiZQF82B\_GSnPS5Np2obWMtqbWlnnnPETdk43obZ2k7m\_BIjKDxn65Y42oujsSCIpgWsTH6JGZc8dPTNzIoMGLkZwJAk5X6MzuxBSaEg3cVKZpQ27)
