Feature: NopCommerce User Flow
  As a customer
  I want to register, login, add products, and checkout
  So that I can complete my shopping journey

  Scenario: Launch browser and open homepage
    Given the user launches the browser
    When the user opens the nopCommerce homepage
    Then the page title should contain "nopCommerce"

  Scenario: Register a new user
    Given the user navigates to the register page
    When the user enters valid registration details
    Then the user should be registered successfully

  Scenario: Login with registered user
    Given the user navigates to the login page
    When the user enters valid credentials
    Then the user should be logged in successfully

  Scenario: Add a product to the cart
    Given the user navigates to the Computers -> Desktops section
    When the user adds the first product to the cart
    Then the product should be added successfully

  Scenario: Select product attributes
    When the user selects RAM from the dropdown
    And the user selects HDD using radio button
    Then the user adds the configured product to the cart

  Scenario: Open shopping cart
    When the user opens the shopping cart
    Then the cart page should be displayed

  Scenario: Increase quantity in cart
    Given the user is on the cart page
    When the user increases quantity to 2
    Then the cart should reflect quantity 2

  Scenario: Open shipping page
    When the user clicks on Estimate Shipping
    Then the shipping popup should be displayed

  Scenario: Enter shipping details
    When the user selects country "India" and enters postal code
    And chooses shipping method "Next Day Air"
    Then the shipping details should be applied

  Scenario: Proceed to checkout
    Given the user accepts the terms of service
    When the user clicks on checkout
    Then the checkout page should be displayed

  Scenario: Navigate to Digital Downloads
    When the user clicks on Digital Downloads
    Then the Digital Downloads page should open

  Scenario: Navigate to Books
    When the user clicks on Books
    Then the Books page should open
