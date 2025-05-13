@Smoke @Sanity @Regression
Feature:Careers - Job Search Functionality

 @Smoke @Sanity @Regression
   Scenario: User initiates the career website and the website loads successfully
    Given The user initiates the career website
   Then Verify that the website loaded successfully
   
  @Smoke @Sanity @Regression
  Scenario: Validate the UI elements on Career Page
  Given The user initiates the career website
  When The User navigates to Search Roles
  Then Validate that the Dropdowns, KeyWord Search textbox and Search button are visible on the Search Roles page
   
  @Sanity @Regression
  Scenario: Search for a job using single dropdown
   Given The user initiates the career website
   When The User navigates to Search Roles
    And The user searches the job with single dropdown
    Then The results should contain the city keyword "Ahmedabad"
   
@Regression
  Scenario: Search for a job using multiple dropdown filters
  Given The user initiates the career website
  When The User navigates to Search Roles
  And The user searches the job with multiple dropdown options
   Then The results should contain the keyword "QA"
 
 @Smoke @Sanity @Regression
  Scenario: Search for a job using a valid keywords
  Given The user initiates the career website
  When The user navigates to Search the role with keyword search
  And The user searches the job by passing valid keywords "Full stack engineer" to Keyword field
  Then The results should contain the keyword that have been passed in Keyword field "Full stack engineer"
 
 @Smoke @Sanity @Regression
  Scenario: Search by Valid Job ID
  Given The user initiates the career website
  When The user navigates to Search the role with keyword search
  And The user searches the job by passing Job ID "R0381475" to Keyword field
  Then The results should contain the Job ID that have been passed in Keyword field "R0381475"
 
 @Sanity @Regression
  Scenario: Click on a job result
  Given The user initiates the career website
  When The user navigates to Search the role with keyword search
  And The user searches the job by passing Job ID "R0381475" to Keyword field
  Then Validate when clicked on job link, the user should be navigated to job details page
 
 
 @Regression
 Scenario: Search for a job using a invalid keywords
  Given The user initiates the career website
   When The user navigates to Search the role in RoleTitle field
  And  The user searches the job by passing invalid keywords "abcdef" to role title field
  Then Verify that a popup is displayed with this message "Sorry, no matching options"
   
   
 