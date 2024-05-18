#### Title: Selenium WebDriver Automation Project for E2E Testing of https://www.saucedemo.com/ ####

````
1. Introduction:
This report presents a Selenium WebDriver automation project designed to execute end-to-end (E2E) testing scenarios on the website https://www.saucedemo.com/. The project consists of two scenarios: Scenario 1 involves the standard user journey, while Scenario 2 simulates the performance glitch user journey.

2. Scenario 1:
    - 2.1. Login as a Standard User:
        * Utilizing Selenium WebDriver, the project initiates a browser session and navigates to the login page of https://www.saucedemo.com/.
        * The automation script inputs valid credentials for a standard user and submits the login form.

    - 2.2. Add three Products to Cart and Checkout:
        * After successful login, the script navigates to the inventory page and adds three products to the cart.
        * It then proceeds to the cart page, verifies the presence of the added products, and initiates the checkout process.
  
    - 2.3. Add and Remove Product on Cart Page:
        * Upon reaching the cart page, the script adds another product to the cart and subsequently removes it.
        * Verification steps are implemented to ensure successful addition and removal of the product.

3. Scenario 2:
    - 3.1. Login as a Performance Glitch User:
        * Similar to Scenario 1, the automation script initiates a browser session and logs in using credentials associated with a performance glitch user.

    - 3.2. Add three Products to Cart and Checkout:
        * Following successful login, the script proceeds to add three products from inventory page to the cart.
        * It then proceeds to the cart page, verifies the presence of the added products, and initiates the checkout process.

    - 3.3. Add and Remove Product on Cart Page:
        * On the cart page, an additional product is added to the cart, and then removed.
        * Verification steps are implemented to ensure successful addition and removal of the product under the performance glitch user account.

4. Implementation Details:
    - The automation project is developed using Selenium WebDriver in conjunction with a Java programming language.
    - Test scripts are structured using a maven build tool/framework to enable modularization.
    - XPath or CSS selectors are employed to locate and interact with web elements on the application pages.
    - JUnit Assertions and verifications are incorporated to validate expected behaviors and outcomes throughout the test scenarios.

5. Conclusion:
    - The Selenium WebDriver automation project facilitates comprehensive testing of the E2E journeys on https://www.saucedemo.com/, covering both standard and performance glitch user scenarios.
    - By automating repetitive tasks and validating critical functionalities, the project enhances the efficiency and reliability of testing processes, contributing to overall software quality assurance efforts.

````