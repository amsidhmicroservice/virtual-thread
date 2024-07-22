# API performance test using Jmeter
Before running below command, set spring.threads.virtual.enabled=true in application.properties
Do some sanity of the api. at least 10 request for each api.

First run only jmeter, import TripPlanRequest.jmx, disable all listeners and save the file. Close the jmeter.

Open new cmd and run the following command

jmeter -n -t TripPlanRequest.jmx -l ..\jtl\VirtualThreadTripPlanRequest.jtl

Now set spring.threads.virtual.enabled=false in application.properties
jmeter -n -t TripPlanRequest.jmx -l ..\jtl\PlatformThreadTripPlanRequest.jtl

Now open jmeter only using command line

Enable all listener and import above files VirtualThreadTripPlanRequest.jtl and PlatformThreadTripPlanRequest.jtl in 
respective listener created.
And Go to setting in listener change the value to 30 points and see the result.

