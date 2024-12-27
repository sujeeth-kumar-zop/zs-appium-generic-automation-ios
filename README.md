# zs-appium-generic-automation-ios
## Introduction
This repository contains the automation scripts for testing iOS application under the Zopping project. The tests are automated using Appium, TestNG, and other relevant tools. The goal of this project is to ensure the stability and functionality of various iOS applications.
## Applications Automated
- Tamimi
- Vijetha
## Technologies Used
- Appium
- TestNG
- Maven
- Java
- ExtentReports
## Project Structure

```plaintext
├── .github
│   └── workflows
│       └── CI.yml                  # Continuous Integration workflow configuration
├── .idea                           # IDE-specific files
│   ├── *.xml                       # IntelliJ IDEA project configuration files
├── logs
│   ├── debug.log                   # Debug logs for troubleshooting
│   ├── main.log                    # Main execution logs
├── reports
│   └── ExtentReport.html           # HTML report for test execution summary
├── resources
│   ├── utils
│   │   ├── login_details.xlsx      # Login data for tests
│   │   └── log4j2.xml              # Logging configuration
├── src
│   └── main
│       └── java
│           └── com.zs
│               ├── constants       # Constants used across the framework
│               │   └── Constants.java
│               ├── locators        # Element locators for different modules
│               │   ├── TamimiLocators.java
│               │   └── VijethaLocators.java
│               ├── pages           # Page Object Model (POM) implementation
│               │   ├── common      # Common page objects
│               │   │   ├── CartPage.java
│               │   │   ├── CheckOut.java
│               │   │   ├── LoginPage.java
│               │   │   ├── OrderPage.java
│               │   │   ├── ProfilePage.java
│               │   │   └── SearchPage.java
│               │   ├── tamimi      # Tamimi-specific page objects
│               │   │   ├── HomePageTamimi.java
│               │   │   └── LoginPageTamimi.java
│               │   ├── vijetha     # Vijetha-specific page objects
│               │       ├── HomePageVijetha.java
│               │       ├── LoginPageVijetha.java
│               │       └── SearchPageVijetha.java
│               └── utils           # Utility classes
│                   ├── CommonUtils.java
│                   ├── ExcelUtils.java
│                   ├── ExtentReport.java
│                   └── LoggerUtil.java
├── test
│   └── java
│       ├── config                  # Test configuration files
│       │   ├── BaseTest.java
│       │   └── readCredentials.java
│       └── test                    # Test cases
│           ├── AddToCartTest.java
│           ├── CheckOutTest.java
│           ├── IncrementProductQuantityInCartTest.java
│           ├── LoginTest.java
│           ├── OrderCancellationTest.java
│           └── SearchProductTest.java
├── target
│   ├── testingTamimi.xml           # Tamimi-specific test configuration
│   └── testingVijetha.xml          # Vijetha-specific test configuration
├── pom.xml                         # Maven project configuration
```
## Setting up the Project
### Prerequisites
- Java
- Maven
- Appium
- XCode
- ExtentReports
### Installation and Setup
* Clone the Repository:
  ```
  git clone <repo-url>
  cd <project-directory>
  ```
* Install the following tools
    - Brew
    - Node
    - Appium
    - XCode and necessary pods
* Set PATHs for all tools into your system
    - Java
    - Maven
    - (might be: appium, node)
* Install - Device Specific Appium Driver
    - ios
* Install Dependencies: ``` mvn install ```
* Set up Appium and iOS simulator
* Run Tests: Run the tests using the respective ```testng.xml``` file of the application.
## Execution Result
The reports are generated and can be viewed in the ```/reports``` folder.
