# Signal Processing

{% hint style="info" %}
Requirement: plugin-processing-1.0.0+
{% endhint %}

Live provides pipe functions to help apply signal processing

### Filters

The pipe function for filter signals enables removing unwanted harmonic component to have a more clear curve.

<figure><img src="../.gitbook/assets/image (259).png" alt=""><figcaption><p>Signal filter pipe function</p></figcaption></figure>

Sine Wave Combined with Multiple Frequencies and Gaussian White Noise

```
def sine_wave(x, f=60, amp=1, theta=0): amp * sin(2*pi()*f*x + theta);

=> over all every sec
=> count() as x, normrandom(0, 2) as noise over all every item
=> sine_wave(x, 1/60, 10)
  + sine_wave(x, 1/30, 5)
  + sine_wave(x, 1/15, 2.5)
  + noise as y, x every item

```

<figure><img src="https://lh5.googleusercontent.com/Q2vLpq__BeVYfHcyn5YxCs3JD5Nd73E4FCCzSGJTljShpC0TBJZH1Xyph5IDKZVa2tx48K2ZFMWYv0qWop_jkK9YyewK8LwmGK86At6SpKvOyLtf0sNzw8e0oW_mOeoKCk0TU5RDx-I8Mo0_1aqNCvGFSObo0kZIv5LYaf_B80SbT1szXju1iHt6K_A-" alt=""><figcaption><p>Sine noised wave</p></figcaption></figure>

Generate FFT of Original Signal

```
def sine_wave(x, f=60, amp=1, theta=0): amp * sin(2*pi()*f*x + theta);

=> over last min every sec
=> count() as x, normrandom(0, 2) as noise over all every item
=> sine_wave(x, 1/60, 10)
  + sine_wave(x, 1/30, 5)
  + sine_wave(x, 1/15, 2.5)
  + noise as y, x every item

=> signal.FFT(x, y#, 1, false) as fftResultData over last 5 min every min
=> fftResultData:json():jsonparse() as result
=> result->magnitudes:seq as mag, result->frequencies:seq as freq
=> @for range(freq:len()) as i, mag, freq
=> mag[i] as y, freq[i] as x
```

<figure><img src="https://lh3.googleusercontent.com/hgs7RLJiwCEt1fqZTS31TkwbVADk2D3-pq-GiSig5wYqRR7-BJ4d1WZc2gGnd09fQMCWrxIzAb9ZOla72XzehWFZcDMlMQ44QliWJAMk6U111fcoWbRyGkPA86zHcsbjqx0hT6NpoqpoW31SJW_V9MpIe3cvtGoB9TVOXHynt5Xnjwv8Y_EX5KxCXu_R" alt=""><figcaption><p>FFT of the original sine</p></figcaption></figure>

Applying Low Pass IIR Butterworth Filter

```
def sine_wave(x, f=60, amp=1, theta=0): amp * sin(2*pi()*f*x + theta);

=> over all every sec
=> count() as x, normrandom(0, 2) as noise over all every item
=> sine_wave(x, 1/60, 10)
  + sine_wave(x, 1/30, 5)
  + sine_wave(x, 1/15, 2.5)
  + noise as y, x every item
 
=> signal.filter(x, y, 0, 1/60, 1, 1, "low", "butterworth") as result, 
y over all every min
=> result:json():jsonparse() as res, y
=> res->result:seq as yArr, res->timestamps:seq as xArr
=> @for range(xArr:len()) as x, yArr
=> yArr[x] as y_filtered, x as x
```

<figure><img src="https://lh6.googleusercontent.com/Xi_Ti1Y7zTlRGhAeWpSJH_vUNM7B6_robK2qywsfv1PvdQLObN1C4P7mutPbI2IDOUDBDURemfQ4HeosMd6NY7D0UM5wSMIJl2flKBSmic8tVsNuf7TtHbnlZoRAT7oN4ie-EzjpwlbEyOROLJKpFQcAX4dGFwxIonumTUg8QP2fnd97AW8jSk_Tuc5k" alt=""><figcaption><p>Low pass filter on noised sine</p></figcaption></figure>

FFT of the Filtered Signal

```
def sine_wave(x, f=60, amp=1, theta=0): amp * sin(2*pi()*f*x + theta);

=> over last min every sec
=> count() as x, normrandom(0, 2) as noise over all every item
=> sine_wave(x, 1/60, 10)
  + sine_wave(x, 1/30, 5)
  + sine_wave(x, 1/15, 2.5)
  + noise as y, x every item
 
=> signal.filter(x, y, 0, 1/60, 1, 1, "low", "butterworth") as result, 
y over all every 10 sec
=> result:json():jsonparse() as res, y
=> res->result:seq as yArr, res->timestamps:seq as xArr
=> @for range(xArr:len()) as x, yArr
=> yArr[x] as y, x as x

=> signal.FFT(x, y#, 1, false) as fftResultData over last 5 min every min
=> fftResultData:json():jsonparse() as result
=> result->magnitudes:seq as mag, result->frequencies:seq as freq
=> @for range(freq:len()) as i, mag, freq
=> mag[i] as y, freq[i] as x
```

<figure><img src="https://lh4.googleusercontent.com/21yS_G3k5tojgEO0UbVUsEeUt9bzchcXSdCppmRHvRYK9HkPvRWIX99Q8czX0VUkDECgvyQqAuqKjLlSM9S6L0-mSc3KllbSNztsnciM9xwu5ZUxml2mL7hdekkxA5SO1WkC9762UzSS2dXENdBDSHfFuiy4R6vP-eMUPySrYZUlP1wA1E1akYnRMQTE" alt=""><figcaption><p>FFT of the filtered signal</p></figcaption></figure>

### Peak Detection

The pipe function to find peaks is used to determine the peak or a local maximum that is a sample whose two direct neighbours have a smaller amplitude.

<figure><img src="../.gitbook/assets/image (260).png" alt=""><figcaption><p>Signal find peaks pipe function</p></figcaption></figure>

<figure><img src="../.gitbook/assets/image (258).png" alt=""><figcaption><p>Signal find troughs pipe function</p></figcaption></figure>

Detecting Peaks and Troughs on a Channel

```
event_type mnemonic:MNEMONIC => value, timestamp

=> signal.findPeaks(timestamp#, value#) as res at the end
=> res:get("indexes") as xArr, res:get("heights") as yArr
=> @for range(xArr:len) as x, xArr, yArr
=> yArr[x] as peak, xArr[x] as timestamp
```

```
event_type mnemonic:MNEMONIC => value, timestamp

=> signal.findTroughs(timestamp#, value#) as res at the end
=> res:get("indexes") as xArr, res:get("heights") as yArr
=> @for range(xArr:len) as x, xArr, yArr
=> yArr[x]#:abs() as trough, xArr[x] as timestamp

```

<figure><img src="https://lh4.googleusercontent.com/1GQeuikmQpQ_aI-KqnGdWhyudpEGvVQFzlQQ3ZjWF70liBBmulYWa03DIFBMIJ7WUpgwKd8-aftpASr9TdNpsaxAogE5oiD0hf67WRLjHcjHjAt5ZXBunFOuAqyTN4i6_SFRC8WcAAOBLGH0gcicxcvrf8q-eJJ_HrHlvlfhL04_8w5Z3tyc4zehXNat" alt=""><figcaption><p>Peak detection</p></figcaption></figure>

### Wave Generation

Sine Waves

```
=> over last 10 min every sec
=> count() as x over all every item
=> signal.generate_wave("sin", x, 0.01, 0, 0) as y_0_deg,
   signal.generate_wave("sin", x, 0.01, 45/pi(), 0) as y_45_deg,
   signal.generate_wave("sin", x, 0.01, 60/pi(), 0) as y_60_deg
```

<figure><img src="https://lh3.googleusercontent.com/FbBoC15c2uXU8HqVcqQgC7GZm4P_Oh8As-FakcqEVOS3NQUD_SbUckyweRtzB_ufaUOTkrNs7qD-c3Bx1gzuxGEP6dJgvf_XtRVudbPCGtnxqHJUO4-x7x7VScRWjfDN_Tvfl6vOBYgKF_ySbUH7YBWNSR7flALHi7eJURG3RcYANceiKzo-zNehUId8kg" alt=""><figcaption><p>Sine wave generated</p></figcaption></figure>

Sine Wave with Noise

<pre><code><strong>=> over last 10 min every sec
</strong>=> count() as x over all every item
=> signal.generate_wave("sin", x, 0.01, 0, 0.02) as y_0_deg,
   signal.generate_wave("sin", x, 0.01, 45/pi(), 0.03) as y_45_deg,
   signal.generate_wave("sin", x, 0.01, 60/pi(), 0.04) as y_60_deg
</code></pre>

<figure><img src="https://lh6.googleusercontent.com/dLqGKauaO7wVE_iFa7TuEuN8gC_40idZWPV2YN-QYLZvvFevgDmP8EjqLM9_VzPSSn3Ju248CBaoXRnnN1vtV6xatRTdHDAnRcCCurT1GQFsnMIsQxFFPk5jpMDOrZXJ5-m2DbZL1z3Sh9EqUd0QOnLLJfzHdRk0Bob3ZRzrpHIIhRNFgP-d2EszjYProQ" alt=""><figcaption><p>Sine noised wave generated</p></figcaption></figure>

Square Wave

```
=> over last 10 min every sec
=> count() as x over all every item
=> signal.generate_wave("square", x, 0.01, 0, 0) as y_0_deg
```

<figure><img src="https://lh3.googleusercontent.com/R1DeSWP3l85Ky1BkhUWM6rhA0XRgxiQU0R1CfziONEX1zNrd4y4QOs2rY3mC7TnkQaFAewVQojLdiSNGnw_ikJnmyCd8UaQ7ltqVvkHCYzOyeo8jP4g9Y6A1sx0mX_hqxyysbXHjGqqQ8CK4IlBCMxm1YpHXj7VSZBAvQdakd_Kc8DhGNLWxor1Lcv92pQ" alt=""><figcaption><p>Square wave generated</p></figcaption></figure>

Square Wave with Noise

```
=> over last 10 min every sec
=> count() as x over all every item
=> signal.generate_wave("square", x, 0.01, 0, 0.05) as y_0_deg
```

<figure><img src="https://lh3.googleusercontent.com/nbWoPkiMYDwnswwynocjpJvlzx-OB7DfSw8j4HlSGs-llyy2nA5prHHlmP2wCHCDhVFGGdR6y9Z0jnKUf9xONdW18R8Aoha3U6EEfXFg1vi8iH9DbnEeca1IODN8ko7npitYH6NpiTVwNtWVpLzGlhDO4ov92Ebc0rVJvziqe8jZ_hScHNyYyaZNkRjPdw" alt=""><figcaption><p>Square Wave with Noise</p></figcaption></figure>

Square Wave with differents Duty Cycles

```
=> over last 10 min every sec
=> count() as x over all every item
=> signal.generate_wave("square", x, 0.01, 0, 0, 0.10) as y_10,
   signal.generate_wave("square", x, 0.01, 0, 0, 0.50) as y_50
```

<figure><img src="https://lh3.googleusercontent.com/oC_-dxCrDoAjrcFxq8ql-ZutgG0lb8XYBs1bcF62ARykVke-aLiAdR8BkQ5IFkNHlqbopzE_6GkoDhlU6cvt9zvtEdZm8OI7EmKJVS-_GPAEafg4czcdWGNP79ym3MokPySjR63eK2lbgYZTFp_qeLFfeGxm6VIGlPn7GpYZ7WI7kOMAd1bKWAzsvbsqGg" alt=""><figcaption><p>Square Wave with differents Duty Cycles</p></figcaption></figure>

### Outliers Removal

An outlier is an observation that is unusually far from the other values in a data set. Remove outlier is a common process to have a more clear data.

<figure><img src="../.gitbook/assets/image (257).png" alt=""><figcaption><p>Remove outliers pipe funn</p></figcaption></figure>

Remove the top 5% and bottom 5% values

```
data_with_outliers
=> signal.removeOutliers(timestamp#, value#, 'top_bottom') as filteredData 
over all every 10 minutes
=> filteredData->timestamps as xArr, filteredData->values as yArr
=> @for range(xArr:len) as x, xArr, yArr
=> yArr[x] as filtered, xArr[x] as timestamp
```

<figure><img src="https://lh6.googleusercontent.com/V1rD9BdoUHpsDotatmDYKVD3OM2L7tvPIKlhJ3UsU_icOwH3XcJLHIFC8kM6ki5T8FgXoyYHusRrW24jC6B209c4Jk4t_5U0La4dSDbz6WlebIu153vfi2gABVK6LupYQsQT1oeTFHePW_u6eUGgFI5O16ftMgpfP7xjictgaOT5lK4Ih5fhY19ZXWu6wA" alt=""><figcaption><p>Outliers removal</p></figcaption></figure>
