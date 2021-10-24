# Test Plan (Version 2)

**Author**: Team100
## Change Log

* Added instructions for automated tests, section 1.6 (Oct. 23, 2021)
* Edited Test Cases section 2 with additional tests and included updated results (Oct. 23, 2021)

## 1 Testing Strategy

### 1.1 Overall strategy


Testing will be performed on each segment of code that is built. This will allow us to verify functionality of our lowest level components. Tests will be written in pairs, the primary tester will be the developer of the code being tested, the secondary tester will be selected as available. The role of the primary tester is to actually write the test cases for the code they wrote. The role of the secondary tester is to ask questions to the primary tester to ensure that all cases are covered in the testing. Testing will follow a bottom-up approach where we begin with unit-testing, then integration-testing, followed by system-testing and after refactoring (if needed) we will conduct regression-testing.

### 1.2 Test Selection

#### White-Box Techniques (Covers Unit and Integration Testing)
- Linting [Checkstyle](https://checkstyle.org/)
- Data-Flow Analysis [CodeQL](https://codeql.github.com/docs/)

#### Black-Box Techniques (Covers Unit, Integration, and System Testing)
- Fuzzing [Monkey](https://developer.android.com/studio/test/monkey)

### 1.3 Adequacy Criterion

All testing methodologies have areas they excel at identifying problems, and areas where they are not able to observe problems. This allows us to use a variety of testing methodologies in conjunction with each other to cover the majority of our code. 

We will assess the quality of our test cases by comparing the results from our fuzzing and data-flow tests against the comparable unit/integration/system tests. If a comparable test does not exist, it will be added. If the comparable test does not cover the same or similar user behavior from the fuzzing test, a test-case for that user behavior will be added. 

### 1.4 Bug Tracking

We will use [GitHub Issues](https://github.gatech.edu/gt-omscs-se-2021fall/6300Fall21Team100/issues) to report bugs and track feature requests. This will also support allowing our team to assign members to action specific bugs and features.

### 1.5 Technology

- [JUnit 4+](https://junit.org/junit4/) 
- [Espresso (UI Tests)](https://developer.android.com/training/testing/espresso#java)
- [Checkstyle](https://checkstyle.org/) 
- [CodeQL](https://codeql.github.com/docs/)
- [Monkey](https://developer.android.com/studio/test/monkey)

### 1.6 Instructions for Running Automated Tests
* JUnit 4+
  * Find the unit test files in JobCompare6300/app/src/test/java/edu/gatech/seclass/jobcompare6300 and either run all by right clicking the folder in Android Studio and selecting Run or right click the individual files and Run each one individually.
* Espresso (UI Tests)
  * Find the test files in JobCompare6300/app/src/androidTest/java/edu/gatech/seclass/jobcompare6300 and either run all by right clicking the folder in Android Studio and selecting Run or right click the individual files and Run each one individually.

## 2 Test Cases

### General Testing
Test Case | Purpose | Steps | Expected Result | Actual Result | Pass/Fail Info | Additional Info
----------|---------|-------|-----------------|---------------|----------------|----------------
Code Linting | Ensure code meets established standards | We will integrate our linter into our workflow. This will allow the feedback to be integrated prior to pushing commits and merging into our master branch. | Some code will need to be modified | Android studio's built-in linter posed several warnings for possible typos and unused portions of code. | pass | The team reviewed the warnings and, where relevant, made updates. 
Data Flow Analysis | Analyze code coverage, and identify potential vulnerabilities | We will use queries provided by CodeQL’s API to assess our coverage and to check for potential vulnerabilities | Our code is kept clean and secure | We did not identify any application vulnerabilities | Pass | other
Fuzzing | Ensure code can handle unexpected user inputs | run monkey on emulator (see additional info for precise steps) | Expect the fuzzer to validate that our program is sufficiently robust, and that it handles unexepected inputs | Application successfully prevented fields from getting saved with invalid inputes | pass | Steps:\\ - the emulator device must be running first (otherwise adb can't "see" the device\\ - set an alias from the adb binary to adb. On windows powershell, with default installs: `set-alias -name adb -value %USERPROFILE%\AppData\Local\Android\Sdk\platform-tools\adb.exe`\\ - run `adb -e shell` , this will bring you into the emulator's CLI\\ - from the emulator's CLI, run `monkey -p edu.gatech.seclass.jobcompare6300 <num events to inject>` , this will generate a series of random button clicks and data entries in the emulator (feel free to watch as it does it's thing!)

### Specific Case Testing
Test Case | Purpose | Steps | Expected Result | Actual Result | Pass/Fail Info | Additional Info
----------|---------|-------|-----------------|---------------|----------------|----------------
Test 1) | Testing jobComparison function under different scenarios | User will input 0 jobs initially using enterJobs function | Button will be disable until 2 jobs are entered | button is disabled on main menu | pass | other
Test 2) | Testing jobComparison function under different scenarios | User will input 1 job using enterJobs function | Button will be disable until 2 jobs are entered | button is disabled on main menu | pass | other
Test 3) | Testing jobComparison function under different scenarios | User will input 2 jobs using enterJobs function | Button is enabled; when pressed it takes the user to the job comparison window where they can select two jobs to compare | Button becomes enabled and takes the user to the comparison window | pass | other
Test 4) | The test will make sure methods such as editCurrentJob (including addLocation), enterJobOffer and adjustWeights behave properly when user input is blank | Invoke save method while the user input is blank for each field | Expect the blank is not saved and/or error is presented | Errors are presented to user when saving blank fields | pass | other
Test 5) | This test will make sure editCurrentJob (including addLocation), enterJobOffer and adjustWeights methods return proper error message for illegal types of input | User inputs illegal data type for each input field | Expect the app to throw an error message of illegal input for respective fields | Field validation does type checking, thus preventing invalid character input | pass | other
Test 6) | This test will make sure editCurrentJob, enterJobOffer and adjustWeights methods return error message for overflow input | User inputs numerical or character values greater than that supported by primitive data type for each field | Application sets an error for the field, does not save values, and stays on the current screen | pass |other
Test 7) | This test will make sure editCurrentJob and enterJobOffer methods returns proper error message for input that violates explicit data constraints | User inputs telework days for x<0 and x>5, and gym allowance x<0 and x>500 and remaining numerical attributes where x<0, such as salary and bonus (this test case will be split into individual tests when implementing) | Expect the app throw an error message for violation of data constraint | Expect the app throw an error message for respective input fields | fields display appropriate errors on field validation. Validation occurs after attempting to save the job | pass | other
Test 8) Cost-of-Living Consistency check | This test will ensure that the cost of living index is consistent for identical locations | Create job 1, Create job 2 with the same location as job 1, but a different cost of living index, check that cost of living index for job 1 is now updated to the cost of living index for job 2 | expect that the cost of living indices are identical | Cost-of-living updates get tracked at the location level, and stay consistent. | pass | other
Test 9) Current Job Database check | This test will ensure that the current job is being properly stored in the database and that persistence is acheived | Enter current job details in the Enter Current Job layout fields, then press Save. Close the app, reopen it and check that the current job details are still there in Enter Current Job layout fields. | Enter Current Job layout fields will be populated with pre-saved data |  Enter Current Job layout fields populated with pre-saved data | pass | other
Test 10) Job Offer Database check | This test will ensure that job offers are being properly stored in the database and that persistence is acheived | Enter job offer details in the Enter Job Offer layout fields, then press Save. Add another Job Offer by pressing Enter Another Offer, then input different details specific to the second job the same way as the first, then press Save. Close the app, reopen it and check that the job offers populate in the spinner dropdown menu in the Compare Job Offers layout. | All the job offers entered and saved will populate the spinner dropdown menu in Compare Job Offers layout |  All the job offers entered and saved populated the spinner dropdown menu in Compare Job Offers layout | pass | other
Test 11) Comparison Weights Database check | This test will ensure that comparison weights are being properly stored in the database and that persistence is acheived | Enter comparison weights (positive integer, other than the default value of 1) in the Adjust Comparison Weights layout fields, then press Save. Close the app, reopen it and check that the comparison weights in the Adjust Comparison Weights layout fields match what was inputted. | All the comparison weights entered and saved will populate the fields in the Adjust Comparison Weights layout | All the comparison weights entered and saved populated the fields in the Adjust Comparison Weights layout | pass | other
