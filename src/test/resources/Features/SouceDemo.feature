Feature: test login functionality

 @InvalidCredential  
  Scenario Outline: check login with Invalid credential
    Given browser is opened
    And user is in login page
    When user enters Invalid username as <username> and password as <password>
    And user clicks on login
    Then user is not navigated to the home page
    Examples:
    |username|password|
     |abc|abc123|
    
@ValidCredential
  Scenario Outline: check login is successful with valid credential
    Given browser is opened
    And user is in login page
   When user enters Invalid username as <username> and password as <password>
    And Verify the login button text is capitalized
    And user clicks on login
		Then user clicks on logout
 Examples:
    	|username|password|
     |standard_user|secret_sauce|
 
 @VerifyHomePage
  Scenario Outline: Verify the Home Page
    Given browser is opened
    And user is in login page
    When user enters Invalid username as <username> and password as <password>
    And user clicks on login
    Then verify default filter dropdown is A-Z
    Examples:
    	|username|password|
     |standard_user|secret_sauce|
     
@AddProduct
  Scenario Outline: Add Product to the Cart
	  Given browser is opened
	  And user is in login page
	   When user enters Invalid username as <username> and password as <password>
	  And user clicks on login
	  When Add the first product to the cart
	  And Verify the cart badge has 1 product
	  And Add the last product to the cart
	  Then Verify the cart badge value is increased
	  And Remove the first product from the cart
	  And Verify the cart badge has 1 product
	  And Click on the cart
	  Then Verify the added product is available
	Examples:
    	|username|password|
     |standard_user|secret_sauce|
     
     
@FilterData
	Scenario Outline: Filter the data
	  Given browser is opened
	  And user is in login page
	   When user enters Invalid username as <username> and password as <password>
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
	 Examples:
    	|username|password|
     |standard_user|secret_sauce|
	 
	 
 @PlaceOrder
	Scenario Outline: Place order
	  Given browser is opened
	  And user is in login page
	 When user enters Invalid username as <username> and password as <password>
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
Examples:
    	|username|password|
     |standard_user|secret_sauce|
   