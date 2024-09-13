# native-app-automation - Test Framework

This READ.ME provides instructions for running tests from the mobile test framework.

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java Development Kit (JDK)** version **15** (at least 15)
- **Apache Maven** version **3.9.1**
- **Android SDK** version **12.0** (API level 31) | version **13.0** (API level 33)
- **Appium** version **2.11.3**
- **Node.js** version **v18.20.4**
- **Allure** version **2.30.0** (CLI)

## Configuration File

Before starting the tests, check the configuration settings in the `environment.properties` file. The following
parameters are already set with appropriate values for your convenience:

```properties
app.path=apps/ApiDemos.apk
app.package=io.appium.android.apis
driver.implicitWait=10
isRetryTest=true
retry.count=1
driver.newCommandTimeoutSeconds=60
device.jsonPath=devices/android.json
thread.count=1 
```



### Create an Emulator in Android Studio

You need to create an emulator in Android Studio with the following configuration:

```Emulator Name: pixel_8```

``Configuration: The emulator settings can meets your testing requirements.``

**Note on Emulator Startup:**
The emulator starts automatically during test execution, so you do not need to manually start it before running your
tests.

## Running Tests

### Run All Tests

To run all tests in the project, use the following Maven command:

```bash
mvn clean test
```

### Run Specific Test Classes/Group

To run tests that are part of a specific group/class, you can specify the group/class name in the command line. Use
the ```-Dgroups``` option to include the desired group/class:

```mvn clean test -Dtest=AnimationTest```
```mvn clean test -Dgroups=search```

Available groups: ```regression```, ```smoke```.

# Generating Allure Reports

#### Serve Allure Report Locally

To view the Allure report locally, use:

```bash
mvn allure:serve
```

This command will start a local server and open the Allure report in your default web browser. You can view and interact
with your test results through this interface.

## Running Tests in Parallel

(Note: perform not stable testing due to android 'Force stopping' application)

To run tests in parallel across multiple devices, follow these steps to configure your environment and testng.xml file
properly.

### 1. Configure ```android.json``` with Device Information

First, ensure that you have specified the required number of devices in the ```android.json``` file.

Example ```android.json``` file for two devices:

```json
[
  {
    "deviceName": "emulator-5554",
    "platformVersion": "13",
    "udid": "emulator-5554"
  },
  {
    "deviceName": "emulator-5556", 
    "platformVersion": "13", 
    "udid": "emulator-5556"
  }
]
```

### 2. Configure testng.xml for Parallel Execution

In your ```testng.xml file```, configure the parallel attribute and thread-count according to the number of devices.

Example ```testng.xml```:

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestSuite" parallel="methods" thread-count="2">
...
</suite>
```

### 3. Set Thread Count in ```environment.properties```

Make sure to set the appropriate thread count in your ```environment.properties``` file to match the number of devices.

Example: ```thread.count=2```

### 4. Run maven command:

```mvn clean test```
