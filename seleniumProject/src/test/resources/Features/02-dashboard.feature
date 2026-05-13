@DietitianLogin
Feature: DietitianApplication Dashboard

Background: user is on the browser 

 Scenario: Validate dashboard navigation links count
 Given User is on the login page
 When user logs in with valid credentials
 Then user should see 4 navigation links in the navbar
 
 Scenario Outline: Validate dashboard navigation
 Given User is on the Dashboard page
 When User clicks on "<link>"
 Then user should navigate to "<Pages>" 

    Examples:
      | links          |Pages                       |
      | My Patients    | My Patients page           |
      | New Patient    | New Patient page           |
      | Logout         | user logged out            |
      | Home icon      | dashboard page             |
