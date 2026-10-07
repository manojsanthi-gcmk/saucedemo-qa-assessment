# SauceDemo E2E Automation Test

End-to-end automated test for the SauceDemo web application using **Java + Playwright**.

## Test Flow

Covers one complete end-to-end user journey:

1. Login with `standard_user`
2. Verify successful login (inventory page URL)
3. Add a product (Sauce Labs Backpack) to the cart
4. Verify product name and cart badge count
5. Open cart and proceed to checkout
6. Fill customer information (first name, last name, postal code)
7. Complete the order
8. Verify the order confirmation message: **"Thank you for your order!"**

## Prerequisites

- Java 11 or higher (JDK)
- Maven
- Google Chrome browser

## Setup

```bash
# Clone the repository
git clone https://github.com/manojsanthi-gcmk/saucedemo-qa-assessment.git
cd saucedemo-qa-assessment

# Install dependencies
mvn clean install

# Install Playwright browsers (first time only)
mvn exec:java -e -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"
