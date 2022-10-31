---
description: >-
  Live plugin-spectrum provides pipes functions to calculate the FFT of a
  time-domain signal helping to identify problems that are better seen in the
  frequency domain
---

# FFT spectrum

{% hint style="info" %}
Plugin-spectrum is at _Beta_ version
{% endhint %}

## Introduction

The `plugin-spectrum` it is a Live plugin that provides pipes functions to analyse signals in the frequency domain using FFT (_Fast Fourier Transform_).&#x20;

![Signal processing of plugin-spectrum from time domain to frequency domain with FFT](<../.gitbook/assets/image (258).png>)

Some of the benefits of frequency analysis are improved well safety monitoring and issue prevention:

![Benefits of analyse signal in frequency domain](<../.gitbook/assets/image (39).png>)

Drilling systems are subject to torsional, axial, and lateral vibrations that are excited by bit-rock or by drillstring-formation interaction forces. These oscillations can be distinguished by mode shape and frequency. High-frequency torsional oscillations have natural modes reaching 400 Hz. Stick/slip oscillations are characterized by low frequencies usually below 1 Hz and affect the entire drill-string.&#x20;

![Drilling modes of vibration: lateral, longitudinal and torsional](<../.gitbook/assets/image (250).png>)

The next table shows the frequency ranges of common vibration interaction forces and modes:

| Mechanism      | Mode of vibration       | Frequency range |
| -------------- | ----------------------- | --------------- |
| Stick-Slip     | Torsional               | 0-5Hz           |
| Bit Bounce     | Axial                   | 1-10Hz          |
| Bit Chatter    | Lateral                 | 50-350Hz+       |
| Bit Whirl      | Lateral/Torsional       | 5-100Hz         |
| BHA Whirl      | Lateral/Torsional       | 5-20Hz          |
| Modal Coupling | Axial/Lateral/Torsional | 0-20Hz          |

The stick-slip phenomenon is most typically related to higher compressive strength formations related to torsional vibration (0-5Hz). When drilling with too low RPM or too high WOB (weight on bit), the drill string may enter the stick-slip window:

![Drilling efficiency diagram and stick slip window](<../.gitbook/assets/image (17).png>)

## Live FFT

The `signal.FFT()` pipes function receives a `double array of timestamp series`, a `double array of signal`, the `sampling rate` of signal and a `boolean convertToDecibel` that flags whether or not to convert the output magnitude to decibel:

![Pipe function to calculate FFT](<../.gitbook/assets/image (274).png>)

The example below shows generated sine wave signals in the left charts and their FFTs to the right. The first with one harmonic, the second with three harmonics increasing amplitudes, and the third with noised sine signal.

![Generated sine harmonic signals with calculated FFT](<../.gitbook/assets/image (137).png>)

With a Cartesian chart, it is possible to plot the FFT signal based on the example query below. It is also possible to replace the generated signal with a real signal:&#x20;

```
=> over last 10 min every sec 
=> count() as times, random() as rand over all every item 
=> times, 20*sin(2/10*pi()*times) as sin every item
=> signal.FFT(times, sin, 1,false) as fftResultData 
over last 20 min every 1 min 

=> fftResultData:json():jsonparse() as result 
=> result->magnitudes:seq as mag, result->frequencies:seq as freq 
=> @for range(freq:len()) as i, mag, freq => mag[i] as y, freq[i] as x
=> @set '#106621' as color => @set 1 as lineWidth
=> @set true as __clear
```

The next images show each example with its related FFT:

![Left: sine wave with 10 seconds period. Right output with 0.1Hz peak frequency](https://lh3.googleusercontent.com/8xwRL47XBJewDKu558fhm-ESB0aCH6LNmdz3Ec6mvgU0O85aNa2b-N4\_-OUk8YuwJEJWTL8aKcyDtFqVubLERW6d0DGnyZYgxoEZ4XqVtguV8ctpkR\_kkCCyEZ5F0fVIZZxST55Pl7I)

In a temporal chart with the query bellow it is possible to generate a sine signal:

```
=> over last 10 min every sec 
=> count() as times, random() as rand over all every item
=> sin(2/10*pi()*times) as sin every item
```

![Example of generated sine](<../.gitbook/assets/image (245).png>)

In a Cartesian chart with the query bellow it is possible to generate the fft of the sine signal:

```
=> over last 10 min every sec 
=> count() as times, random() as rand over all every item
=> times, sin(2/10*pi()*times) as sin every item
=> signal.FFT(times, sin, 1,false) as fftResultData 
over last 10 min every 1 min

=> fftResultData:json():jsonparse() as result
=> result->magnitudes:seq as mag, result->frequencies:seq as freq
=> @for range(freq:len()) as i, mag, freq
=> mag[i] as y, freq[i] as x

=> @set '#106621' as __color
=> @set 1 as __lineWidth
=> @set true as __clear
```

![FFT calculated based on generated sine signal](<../.gitbook/assets/image (293).png>)

In a temporal chart with the query bellow it is possible to generate sine with harmonics:

```
=> over last 10 min every sec 
=> count() as times, random() as rand over all every item
=> sin(2/10*pi()*times) + 2*sin(3/10*pi()*times)  
+ 3*sin(4/10*pi()*times) as sin every item
```

![Sine signal generated with harmonics](<../.gitbook/assets/image (384).png>)

In a Cartesian chart with the query bellow it is possible to generate the FFT of the harmonics sine signal:

```
=> over last 10 min every sec 
=> count() as times, random() as rand over all every item
=> times, sin(2/10*pi()*times) + 2*sin(3/10*pi()*times)  + 
3*sin(4/10*pi()*times) as sin every item

=> signal.FFT(times, sin, 1,false) as fftResultData over all every 10 min
=> fftResultData:json():jsonparse() as result
=> result->magnitudes:seq as mag, result->frequencies:seq as freq
=> @for range(freq:len()) as i, mag, freq
=> mag[i] as y, freq[i] as x

=> @set '#106621' as __color
=> @set 1 as __lineWidth
=> @set true as __clear
```

![FFT calculated with harmonics](<../.gitbook/assets/image (479).png>)

In a temporal chart with the query bellow it is possible to generate sine with noise:

```
=> over last 10 min every sec 
=> count() as times, random() as rand over all every item
=> 20*sin(2/10*pi()*times) +20*random() as sin every item
```

![Sine signal generated with noise](<../.gitbook/assets/image (218).png>)

In a Cartesian chart with the query bellow it is possible to generate the FFT of the noised sine signal:

```
=> over last 10 min every sec 
=> count() as times, random() as rand over all every item
=> times, 20*sin(2/10*pi()*times) +20*random() as sin every item


=> signal.FFT(times, sin, 1,false) as fftResultData over all every 10 min
=> fftResultData:json():jsonparse() as result
=> result->magnitudes:seq as mag, result->frequencies:seq as freq
=> @for range(freq:len()) as i, mag, freq
=> mag[i] as y, freq[i] as x

=> @set '#106621' as __color
=> @set 1 as __lineWidth
=> @set true as __clear
```

![FFT calculated based on noised sine ](<../.gitbook/assets/image (89).png>)
