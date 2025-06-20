# Opencart BDD Automation

This is a BDD-based web automation project for the OpenCart Admin application. It uses Selenium WebDriver for browser automation and Cucumber (JUnit) for behavior-driven testing. The framework follows the Page Object Model (POM) design pattern and incorporates Log4j for logging and `cucumber-html` for reporting.

---

## Tech Stack

| Tool/Library      | Purpose                              |
|-------------------|--------------------------------------|
| Java              | Programming language                 |
| Selenium WebDriver| Web automation                       |
| Cucumber (JUnit)  | BDD framework & test runner          |
| Log4j             | Logging mechanism                    |
| cucumber-html     | HTML report generation               |
| Page Object Model | Test code structure/design pattern   |
| Maven             | Dependency and build management      |

---

## Features

- BDD implementation using Gherkin syntax
- Page Object Model for clean and maintainable code
- Parameterized step definitions
- Detailed logs using Log4j
- Rich HTML reports using `cucumber-html`
- Modular test design for easy scalability

---

## Test Coverage
This project covers the following OpenCart Admin functionalities:

- Login

- Logout

- Add Customer

- Search Customer

- Delete Customer

---

## Getting Started

### Prerequisites
- XAMPP and OpenCart Admin Application, *follow instructions from timestamp in this video: [53:00](https://www.youtube.com/watch?v=5zfgqqPr8o8&t=3180s)*
- Java 8 or later
- Maven installed

### How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/adityagupta700/Opencart-BDD-Automation.git
   ```
2. Navigate to the project directory:
   
   ```bash
   cd Opencart-BDD-Automation
   ```
3. Run the tests using Maven:
   ```bash
   mvn clean test
   ```
Test execution reports will be generated in the `target/` directory.
