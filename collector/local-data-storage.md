# Local data storage

All the data received by the collector, independently of the format, is either stored locally and sent to INTELIE Live as-is. That is, no modification is performed on the collected data inside the collector.

All the data is stored in the file `/opt/intelie/liverig/data/data.log.` Simultaneously, a thread pool is reading this file and sending all of the data to INTELIE Live. The process takes just a few milliseconds.

In this file, it is possible to see the **original data** (3), and also some **control information** (1) and **some metadata** (2) that are created and transmitted together, as shown in the image below.

![](https://lh4.googleusercontent.com/jYg63Ph2nie-5qnB80QiGqrEVrjOeAaNuQfFpw06TbKrPbnneiut2\_dtXCTjfWfuUpEYT7AXKlkKqBw2BCFO36L6JsgVMAk7p4dGSEy9oJlchA4BqI2kOKVnX4SYNzlY7EJTyb69)

All the collected data is stored locally, on the collector machine’s disk, for 30 days. It guarantees that after any network issue, no data will be lost.
