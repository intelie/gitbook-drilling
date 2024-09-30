---
description: >-
  Live provides BOP annotation tool at the dashboards and components
  configuration at the rig parameters.
---

# BOP status register

{% hint style="info" %}
Dependencies required: plugin-wells 3.0.0+ and plugin-bop 1.0.0+
{% endhint %}

At the rig parameters tab it is possible to configure bop for each rig:\


![](https://lh6.googleusercontent.com/f47ZSV1OmSErWpxSdygp7wCP0e9HRElNmA4m2Jk3k-N2pXoQJ4HSTDpKNLdEhM8OsOi8tLPTwQaUST0CRW3MUeQ\_WXZBpwGp1AS6HmQ9-so6CjAPsDQ9jUH7Q4CAftlVJ\_DoKs46)

### **Registering BOP components**

Clicking on the edit button of the bop configuration card will open a new window where it will be possible to add new components and configure allowed status Open/Close or Open/BLocked/Close:

![BOP component register](https://lh4.googleusercontent.com/Tmokhg\_GT77NQO4ycU31BRHk6-YFJr5W4rKOcimg5pOMPkoEkJla599Jw48V0MHzgti4\_MhOVtVYkArHF4Do1d38V1SSOhC5Wt3B3t88GTsByGIsDo5RKlpBGONUMvYXsZUf8Zdp)

After saving the entered data, the component names will also be displayed on the BOP configuration card.\


![BOP configuration card](https://lh6.googleusercontent.com/eBfhcvl-ZmPRb1e48mhVV3z2tCYv5Bz9yrWa0IFyaJdVLoXJ3ElFaZndbYHvq7zD4XsSURdAHLJUsmukQ1S\_FlBRkr1dNyhan74CWBGeMTTKoK\_pZpX2hJNQaGXUqKeZpv6eEqa6)

### **Creating BOP annotations**

First it is required to configure the permission of BOP annotation at the admin tab:&#x20;

![BOP permission configuration](<../../.gitbook/assets/image (253).png>)

To create an annotation of the type of BOP status it is necessary to go to the dashboard, click on the timeline and select the option  _Register bop status_\


![](https://lh5.googleusercontent.com/Snf1KkXdpqLkf232V-jP7oc53Og2ocwm3krbcMoVY7uGPk0Rc-ICmVaVcL2cqXqOoklAZmB1mRsjXOFNR2n7id-veR-nZe3m\_jrNODXxddxaZpvdSPtpd\_vLhYgJJQ0JESktA-7a)

In the screen below it is possible to select the desired rig. If the selected rig has no components registered, as per previous steps, no component will be displayed and the note cannot be saved.\


![Rig selection in BOP status register at dashboard timeline](https://lh3.googleusercontent.com/YIEBBYc38AYktBDkDa5qdYykQt1O5VIM\_kLY5PxqPUEohaiLoozvJkmlUAiDFURoij6S2Q4ZDPiNL7UuH2S\_hejKLHeOWfLXjk-cBWIIKNgpuGHSiQZWAB8H2T2X0KiJSt53COWC)

The information for the selected rig will be displayed:\


![BOP components status at the dashboard timeline](https://lh5.googleusercontent.com/eaevbolHwnpPOQxd0Ylt6U02-cupD7pfUnlVlfKK76h4V8AuiF94DIS5HmOmf20ks8N7OAaZNaw93cYqOmFuiqtMohJupqtxKGLlviI4Donh3MAnqdV9ifZ3Z8kT1MYWGUqE9Suq)

Select the state for each of the components and click save. After saving, the note will be highlighted in the timeline, clicking on this indicator will display the basic information of the note.\


![BOP note in timeline](https://lh5.googleusercontent.com/tcSmIXCjRKbBjfHPnFm-IU\_Xl8ht8aUhVQzj\_YAE4UBzMeZOqk61lr\_zPmkcI2-y7-9V506jXwteyfTYBTf-ONfLPdM8cxskcf4NyDxwB4eAnpuRUGJda-vPSfxEujTTz2R8sSBC)

Clicking on the note will display more detailed information.\


![BOP note detail](https://lh4.googleusercontent.com/YOqfZYt3dHDc\_dZK\_1LYOLrq8oZtB0E1CUZZ0xtjSDwhUVvVgY99hn7nsiS7PjQERuEZSZuI29VvEzUx6pMhsdbuBon7B8S-b4h\_HAmT76tVeQP-S-C-gJiV6jGiqSKC98AfJgWI)

To edit or delete the note, just use the buttons at the top right of the note.\


![BOP note ad](https://lh4.googleusercontent.com/E7UoxXpPJcppFPZnHX\_rcgvLtNBM4qNnkzemO1RoaXpeeptB5-jQKxyrkZL5DS6AvonunbwwswsFDY7cXPZ-k5EbtnLgkLSJ1Ir1sz2o9321UCqswhN-eAZIK8pez2P3CoJT0jtl)

At the pipes console it is possible to get BOP notes :\


![BOP query for annotations](https://lh3.googleusercontent.com/DsyCbObSPjDONdM9kkePIE7CKsgr-GYNJ0rSxXUt2tG4DczqKU33hrfWD9POwXtDpyNGXrfM3qro-C6EnHrN\_Cwi2\_y2elXuJik8gohdzBlbTF2emVa-SJQ9t-LZVTF8SONLwTVL)

```
__annotations __src:'bop'
```

\
