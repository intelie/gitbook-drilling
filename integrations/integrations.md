# Introduction

Intelie Live is a platform for processing real-time data streams. It receives data from drilling rigs and other systems, making it available, in a standardized way, to be used by simple queries and visualizations or for more demanding analysis provided by Intelie Live itself or by external applications.

&#x20;External applications, running on external processes and servers may connect to Intelie Live via a network connection. In this scenario, there are no restrictions regarding programming languages and execution environments. External applications could be written in Python, R, Matlab and be hosted on Windows servers, for example.

Applications may receive data from Intelie Live, manipulate this data and feed its results back to Live in order to provide data or new visualizations to another application. To make this integration easier, Intelie Live offers two complementary integration mechanisms:\


* Rest Output: Used when an application needs to receive data from Intelie Live;
* Rest Input: Used when an application need to send data to Intelie Live\
  \


#### Assumptions

* There is a network connection between the application and Intelie Live
* The application is capable of making HTTP requests and process its responses as described on this document
* The event frequency must be lower or equal to 1 kB/s (eg: one event of 1 kB every second)
