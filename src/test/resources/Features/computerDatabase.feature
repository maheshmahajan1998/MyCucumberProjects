Feature: test Computer Database functionality

@VerifyTheData
  Scenario: Verify the computer database website
    #Given browser is open
    And user nevigate to computer database page
    When Verify the title as Computers database
    And Verify the page header is the same as the page title
    Then User must see the filter by computer name text box
    And User able to see add a new computer button
    And User able to see the filter by name button
    And User able to see the table and the headers as follows
    Then The user should see the pagination

  @AddComputer
  Scenario: Add a new computer
   # Given browser is open
    And user nevigate to computer database page
    When add a new cumputer
    And Click on create this computer
    And User should see the red background on the computer name field
    Then Enter the computer name
    And Select the company as Nokia
    And Submit the form
    Then Successful message should be displayed

#@smoke
  #Scenario: Searching the Data
  #	Given browser is open
    #And user nevigate to computer database page
    #When add a new cumputer
    #And Click on create this computer
    #And User should see the red background on the computer name field
    #Then Enter the computer name
    #And Select the company as Nokia
    #And Submit the form
    #Then Successful message should be displayed
    #When After adding the computer count should be increased
    #And Search the created data
    #Then result should be visible
   #
