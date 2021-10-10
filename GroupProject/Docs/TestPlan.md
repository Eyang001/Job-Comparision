# Test Plan

**Author**: Team100

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

## 2 Test Cases

### General Testing
Test Case | Purpose | Steps | Expected Result | Actual Result | Pass/Fail Info | Additional Info
------------------------------------------------------------------------------------------------
Code Linting | Ensure code meets established standards | We will integrate our linter into our workflow. This will allow the feedback to be integrated prior to pushing commits and merging into our master branch. | Some code will need to be modified | actual result=TBD | pass/fail = TBD | other |

Data Flow Analysis | Analyze code coverage, and identify potential vulnerabilities | We will use queries provided by CodeQL’s API to assess our coverage and to check for potential vulnerabilities | Our code is kept clean and secure | actual result=TBD | Pass/Fail Info=TBD | other |

### Specific Case Testing
Test Case | Purpose | Steps | Expected Result | Actual Result | Pass/Fail Info | Additional Info
------------------------------------------------------------------------------------------------
Test 1)Testing jobComparison function under different scenarios | User will input 0 jobs initially using enterJobs function | Expecting that an error will pop up to user to let them know 2 jobs are required to output job comparison | actual result = TBD | pass/fail = TBD | other |

Test 2) Testing jobComparison function under different scenarios | User will input 1 job using enterJobs function | Expecting that an error will pop up to user to let them know 2 jobs are required in the app to perform job comparison | actual result = TBD | pass/fail = TBD | other |

Test 3) Testing jobComparison function under different scenarios | User will input 2 jobs using enterJobs function | Expecting a standard output for the user comparing the requested jobs | actual result = TBD | pass/fail = TBD | other |

Test 4) The test will make sure methods such as editCurrentJob (including addLocation), enterJobOffer and adjustWeights behave properly when user input is blank | Invoke save method while the user input is blank for each field | Expect the blank is not saved and/or  error is presented | Actual result = TBD | pass/fail = TBD | other |

Test 5) This test will make sure editCurrentJob (including addLocation), enterJobOffer and adjustWeights methods returns proper error message for illegal types of input | User inputs illegal data type for each input field | Expect the app to throw an error message of illegal input for respective fields | Actual result = TBD | pass/fail = TBD |other |

Test 6)This test will make sure editCurrentJob, enterJobOffer and adjustWeights methods returns proper error message for overflow input | User inputs numerical or character values greater than that supported by primitive data type for each field | Expect the app throw an overflow error message for respective input fields | Actual result = TBD | pass/fail = TBD |other |

Test 7)This test will make sure editCurrentJob and enterJobOffer methods returns proper error message for input that violates explicit data constraints | User inputs telework days for x<0 and x>5, and gym allowance x<0 and x>500 and remaining numerical attributes where x<0, such as salary and bonus (this test case will be split into individual tests when implementing) | Expect the app throw an error message for violation of data constraint | Actual result = TBD | pass/fail = TBD |other |

Test 8) Cost-of-Living Consistency check | This test will ensure that the cost of living index is consistent for identical locations | Create job 1, Create job 2 with the same location as job 1, but a different cost of living index, check that cost of living index for job 1 is now updated to the cost of living index for job 2 | expect that the cost of living indices are identical | actual result = TBD | pass/fail = TBD | other |
