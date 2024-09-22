# ZEEBU UI/API Automation Selenium WebDriver TestNG Framework By Suraj

## Overview

This repository contains an UI/API test cases of :
1. Balancer Pools Page Validation for Ethereum, Avalanche, Arbitrum and many more.
2. Balancer Individual Pool page Validation
3. Balancer API's data validation with UI
4. Balancer Swap Page Validation
5. Balancer Home Page Validation

## Stack & Libraries
- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports and logging
- Rest Assured

## Prerequisites
- IDE (Eclipse or Intellij)
- JDK
- Maven configuration

### Easy way to configure Maven (Mac)
<details>
  <summary>Click to view instructions</summary> 

1. Download Maven (tar.gz for mac) from [here](https://maven.apache.org/download.cgi)
2. Move the downloaded apache-maven-3.6.3 folder to your Home directory (This is the folder with your username)

In terminal:

1. Set system variables:
```
export M2_HOME=/Users/<YOUR USER NAME>/apache-maven-3.6.3/
```
2. Append the Maven bin folder to the path:
```
export PATH=$PATH:/Users/<YOUR USER NAME>/apache-maven-3.6.3/bin/
```
3. If you don't have a bash profile, create one:
```
touch .bash_profile
```
4. If you do have one, or after creating one, open the bash profile to edit:
```
open .bash_profile
```
5. Paste the two paths from step 1 and 2
6. Save and close
7. Now Maven will be installed for all sessions. To verify Maven is installed, type:
```
mvn --version
```
</details>

## How to run tests
In terminal:
```
git clone https://github.com/Suraj-vyas/Zeebu_TestNG.git
```
Change directory to the location of cloned project folder and run Maven clean
```
mvn clean
```
To run the test
```
mvn test
```

## Project components
- Page objects are in the directory *src/test/java/com/zeebu/projects*
- Test classes are in the the directory *src/test/java/com/zeebu/tests*
- Reusable class is in the directory *src/test/java/com/zeebu/reusableLibrary*
- configuration File is in the directory *src/main/resources/config.properties*

## Highlights
- This framework supports Chrome/Edge,Firefox and Safari browser
- Screenshot on test failure: A screenshot of the active browser is captured and stored in the screenshots folder
- Extent reporting and logging: After the test finishes, a visual report is generated for all the executed test cases from the suite. This report can be found in the 'test-output' folder
- This framework configuration can be changed with the help of Configuration file
- This framework has inbuild dataProvider where data can be read from Excel, CSV and Json File
- This framework supports both UI and API, for API, RestAssured library is used.
