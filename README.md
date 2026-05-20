# Selenium Automation Practice

A UI test automation framework built with **Selenium WebDriver**, **Java**, **TestNG**, and **Maven**, featuring **Allure Reports** for test reporting. Test scenarios are based on **automationcentral.com** practice site.

---

## 🛠️ Tech Stack

| Tool               | Version |
| ------------------ | ------- |
| Java               | JDK 21  |
| Selenium WebDriver | 4.23.0  |
| TestNG             | 7.10.2  |
| Maven              | Latest  |
| Allure Reports     | 2.25.0  |

---

## 📁 Project Structure

```
Selenium_Practise/
├── src/
│   ├── main/java/
│   └── test/java/
│       └── com.automation.test/
│           ├── AlertsTest.java
│           ├── BrowserNavigationTest.java
│           ├── ButtonsTest.java
│           ├── CheckboxesTest.java
│           ├── ConfirmTest.java
│           ├── CookiesTest.java
│           ├── DropdownTest.java
│           ├── FrameAndIFramesTest.java
│           ├── LinksTest.java
│           ├── PromptsTest.java
│           ├── RadioButtonsTest.java
│           └── TextboxTest.java
├── allure-report/
├── test-output/
├── pom.xml
└── README.md
```

---

## ✅ Test Scenarios Covered

| Test File               | What it Tests                          |
| ----------------------- | -------------------------------------- |
| `AlertsTest`            | JS alert handling — accept and dismiss |
| `BrowserNavigationTest` | Forward, back, refresh navigation      |
| `ButtonsTest`           | Button click interactions              |
| `CheckboxesTest`        | Checkbox select and deselect           |
| `ConfirmTest`           | Confirm dialog — accept and cancel     |
| `CookiesTest`           | Add, get, delete browser cookies       |
| `DropdownTest`          | Select dropdown by value, index, text  |
| `FrameAndIFramesTest`   | Switch between frames and iFrames      |
| `LinksTest`             | Link click and navigation              |
| `PromptsTest`           | JS prompt — input and dismiss          |
| `RadioButtonsTest`      | Radio button selection                 |
| `TextboxTest`           | Text input and validation              |

---

## 🚀 How to Run

### Run all tests:

```bash
mvn clean test
```

### Run specific test:

```bash
mvn clean test -Dtest=AlertsTest
```

### Generate Allure Report:

```bash
mvn allure:report
```

### Open Allure Report:

```bash
mvn allure:serve
```

---

## ⚙️ Setup

### Prerequisites:

- JDK 21 installed
- Maven installed
- Chrome browser installed

### Clone and run:

```bash
git clone https://github.com/YOUR_USERNAME/Selenium_Practise.git
cd Selenium_Practise
mvn clean test
```

---

## 👨‍💻 Author

**Saurav Manandhar**
QA Engineer | Kathmandu, Nepal
[GitHub](https://github.com/SauravManandhar023)
