Feature: Shopping Cart

  Scenario: Add item to cart
    Given I have a product named "Laptop" priced at 1000
    When I add the product to my cart
    Then my cart total should be 1000

  Scenario: Checkout cart
    Given I have a cart with a total of 1000
    When I checkout
    Then my cart should be empty

  Scenario: Add multiple items to cart
    Given I have products named "Laptop" priced at 1000 and "Phone" priced at 500
    When I add both products to my cart
    Then my cart total should be 1500

  Scenario: Apply discount to cart
    Given I have a cart with a total of 1000
    When I apply a discount of 100
    Then my cart total should be 900

  Scenario: Attempt to checkout with insufficient funds
    Given I have a cart with a total of 1000
    And I have only 500 in my account
    When I checkout multiple products
    Then I should see an error message "Insufficient funds"
