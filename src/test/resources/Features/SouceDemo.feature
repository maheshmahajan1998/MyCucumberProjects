Feature: test login functionality

 @InvalidCredential  
  Scenario: check login with Invalid credential
    Given browser is opened
    And user is in login page
    When user enters Invalid username as "abc" and password as "abc123"
    And user clicks on login
    Then user is not navigated to the home page
    
@ValidCredential
  Scenario: check login is successful with valid credential
    Given browser is opened
    And user is in login page
    When user enters username as "standard_user" and password as "secret_sauce"
    And Verify the login button text is capitalized
    And user clicks on login
		Then user clicks on logout
 
 
 @VerifyHomePage
  Scenario: Verify the Home Page
    Given browser is opened
    And user is in login page
    When user enters username as "standard_user" and password as "secret_sauce"
    And user clicks on login
    Then verify default filter dropdown is A-Z
    
@AddProduct
  Scenario: Add Product to the Cart
	  Given browser is opened
	  And user is in login page
	  When user enters username as "standard_user" and password as "secret_sauce"
	  And user clicks on login
	  When Add the first product to the cart
	  And Verify the cart badge has 1 product
	  And Add the last product to the cart
	  Then Verify the cart badge value is increased
	  And Remove the first product from the cart
	  And Verify the cart badge has 1 product
	  And Click on the cart
	  Then Verify the added product is available
	
@FilterData
	Scenario: Filter the data
	  Given browser is opened
	  And user is in login page
	  When user enters username as "standard_user" and password as "secret_sauce"
	  And user clicks on login
	  When Add the first product to the cart
	  And Verify the cart badge has 1 product
	  And Add the last product to the cart
	  Then Verify the cart badge value is increased
	  And Remove the first product from the cart
	  And Verify the cart badge has 1 product
	  And Click on the cart
	  Then Verify the added product is available
		And Click on the continue shopping
		And Change the price filter from low to high
		Then Verify the price sorted properly
	 
 @PlaceOrder
	Scenario: Place order
	  Given browser is opened
	  And user is in login page
	  When user enters username as "standard_user" and password as "secret_sauce"
	  And user clicks on login
	  When Add the first product to the cart
	  And Verify the cart badge has 1 product
	  And Add the last product to the cart
	  Then Verify the cart badge value is increased
	  And Remove the first product from the cart
	  And Verify the cart badge has 1 product
	  And Click on the cart
	  Then Verify the added product is available
	  When user want to checkout
	  And Add Checkout: Your Information
	  And check the order details
	  Then order placed

   