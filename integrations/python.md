---
description: Live provides a console to execute python code via REST integration
---

# Python

{% hint style="warning" %}
Dependencies required:

live-python-server-1.0.0+&#x20;

plugin-py-1.1.0+

live-3.24.0+
{% endhint %}

The python server can run via Docker container image available on Intelie Marketplace with some code validation and common machine learning libraries pre installed:

* Tensorflow/Keras
* Numpy
* Pandas
* Scikit-Learn
* Matplotlib
* Pytorch

{% hint style="info" %}
The integration does not support image rendering.
{% endhint %}

First install plugin-py and check that is valid at the admin of plugins:

![Python plugin valid at the admin](https://lh6.googleusercontent.com/qtwn6aQ67CI6\_qZNWmsB3KEHJsDZkPAKlLoIgTt05ZJiKNiuwkV7nA5JAer-6tlNxegJjymNLDSATxbo6E0yeEj3hIR9rqAaSfkpsDtju1nCNmcOveo8FF9yb7h3E3eaDEMwkhnNhNITgN85OA)

Configure the server host name and port:

![Python server host and port configuration](https://lh6.googleusercontent.com/iGCo01CMsMTyaOou\_vD-1P19DdX4RV-B5URho6Y81xoZbuO2rFzH\_3\_cyQwkLYK1NEXkuDMkHbDncPSZ8RePh3oN\_Q6Ww8Mjj1Qq8hcS8nBV4kz5Dl7dWlyetjCC5LV0H01Z5vNtgE6Jzf7Ezw)

The option to open python console will be available at the header:

![](<../.gitbook/assets/image (225).png>)

It is possible to execute code or drag and drop a python file into the console area:

![Python console](https://lh6.googleusercontent.com/Qrucr-DkZWLbn8wiQUZxaRV9CHyb-9tCOmlXUIEfpY\_xEt0sWFQW22L-nYFYjOxzB6p\_fyglsscOWBCu4yT1XOxNXfEKq2AZef-6ALQdK4wt55I6VmJ2QUzYi4PLPSEy4JTM9aLcqxQZabdkHg)

The result will be shown for each print statement call invocation:

![Python console results and expressions](https://lh4.googleusercontent.com/jr-PgARKVwwKpyDC4OVE15x5bAT0i6b5MexXhE1GinS4W5kl72wqIpjKDM5ERiY5GwP60ebtJS9p10x1MUNDmgDXv-dQCqmJQxNGwQi29NTHvPWbmBPjfGs9HtKizjn5y2XD\_CHARZp2lbJ-CA)

It is possible to clear, export, copy and paste files on the upper options:

![Python console actions](https://lh3.googleusercontent.com/n6ZftznM9Yd1hga2KAcoPivN\_jOakhF4FbGADkpvow35L0T0-iPxtFd4r-BZoPFZg38HfLZYTqxyRc5QTi5Q5Xrv7hHQQ\_MW96Ls\_VGSB9X5NlU90uuvMLPTS6kiQV-dSAnzS4gXfcx3J9uUCw)

Python Exceptions are captured and indicated in the response:

![Python console exceptions](https://lh5.googleusercontent.com/dbFuWQFBE\_qrfBcJygBnhs0S4b5BGPxnN\_y27Vf6NVJ0Hi3QVqgCq2XE0eTgfbIsenBDlv8tjp7DyThJfCwL\_3YaNKNtQOr3U2eemJa5JCGnDmanzrKV5AxysaYoQ5PpObVVipS76SAE\_gWoBw)

There are also a few modules, which are considered harmful, that are restricted by default:

![Restricted modules](https://lh5.googleusercontent.com/SmscN0uyA2QKU3o6kFfNS3lNyFHHJFz9-3npqsPSV4zyWSVH-1YxhY4CEcC6SP7v2QNFX4N50lcAiXoB0kawdfSk0LLwVFt7GwlcZRIC9chyqFwNYUHTCNRlpXB3bv9WQSvfjFMTUK9oRnRNrw)

If the option “persist as result event” is checked the result will be persisted as events on Live storage. It is possible to custom the event\_type to be persisted or use default “py”:

![Event persitence](https://lh3.googleusercontent.com/QVY9zqD-lECr8Vo82Qjl4BBS-NTtyoXiMffteF3AqVHQGm-Zv5cjEmhi4YyOGLbcRZr0N0i-UhFc8yR\_i3zoUxYfwvT7GpnJ1cu6PBElxTTO1P3FnnFYg47FzZcAMJbwTTghGRB3BcmDxju4mw)

By executing the query \_\_src:'pysrc' \_\_type:'py' on pipes console it is possible to see the persisted results:

![Events consumed](https://lh3.googleusercontent.com/T--tZC1\_tQnaP2aveFpNb7l5GhYHj5nb0F8Nwx0biwYweca5J6je3skRfNzRuDX42cbvNwNk00NyNkhWBfGZb\_1dRyojKbaoMKkOBecNFKTpmRtoSKn6DTdkGab\_HgePLzTTKYWK4Y-ky3te2w)

It is possible to execute for example Tensorflow and Keras statements and save results as other event types:

![Tensorflow and Keras machine learning libraries code execution](https://lh4.googleusercontent.com/UU-8kMrq2vjpZUPgsqAchOjRqzibIDWGNfE72Um-y6f0v3cS0FGxXUxXU6ljlKTcl9HP0dXFxWdq4vkyxtZ5ccwgDOcOOblYXQW38EJDyK4HzapA-SI4E\_mgl6ry012uc8TJIoLm7fj6azQJgA)

By consuming the evets with \_\_src:’pysrc’ it is possible to find result events with different event\_types:

![Events consumed with different event types](https://lh4.googleusercontent.com/UcM0WnR7JpmfOjhMpf91\_0lGagsGYvnv-hDnX8eAz-f8A7U0oStOMiugDbCaxuPpTuzEdIwEl958KzwXhwC2rnqiC0zEC97XmmEnOWjzrMiNatV2\_rXunCj8SThv2sKD2GQtVw7r4NEQ1J1eYA)

#### Reading data from Live storage

By executing run\_query inside the console it is possible to retrieve data from events with Live incoming events:

_`from pipes.query import run_query`_

_`data = run_query(expression="=> random() * 200 as value every 2 seconds", span="last 10 seconds")`_

_`for i in data: print(data)`_

![](https://lh3.googleusercontent.com/i-8BWFnQyWR-g8hjDK3vpPz1NYBvBUDTttDmg9zdRe6xIR\_XA0hGINyaxoNQF\_elSpq339e3uDMtFfPendt1JnbFw7\_eCwZ86v47X2P6Sz0RgQIVVLPqsGAM6fb6mzSzG1AVmN98ND7YooCfN5Q)

Or it is possible to retrieve data from an asset:

![](https://lh3.googleusercontent.com/iGGM8kQN8h1sGI5pO0l6OKrcsC1LtEycwmGKyni7mqXDUS4dIO-MC5Pk9IYBpai76sy6DbK0dK7PBWFzPUObjbalkgrPMO2mNcjiMWYge9TqyBNpofInazCONTo0S2YBBkcIDYdh0k--g8Bwl9o)

_`from pipes.query import run_query`_

_`data = run_query(expression="=> well('mywell') at the end", span="")`_

_`for i in data: print(data)`_

### **Structured result**

For structured result as a object use send\_event method specifying the object with fields as example below:

![Python console structured result](https://lh5.googleusercontent.com/0aS6\_fC9oAVF2JAixGolmDxvZOEhO1TcG4GgEJ8943gLfS2XpJiaOuqjxrXsy1kgoOROyXUUzq2vUmQNogUismDfsvzCAgjCMQ37N4waOq6OZKTOJCDyrWobL-Pm-D3wrJnGAHqjz-5Qqfk4L60)

### Multiple files persistence

Live provides the multiple files support for executing and saving python statements

{% hint style="warning" %}
plugin-py-1.3.0+  required
{% endhint %}

<figure><img src="../.gitbook/assets/image (322).png" alt=""><figcaption><p>Python tree of files and actions</p></figcaption></figure>
