@DietitianLogin
Feature: Navigation to View Patient Test Reports

  Background: User is logged into the dietician application
    Given User is on the dashboard page
    When User clicks on My Patients button

  Scenario: Navigate to View Previous Test Reports
    Given Patient records exist in the system
    When User clicks "View Previous Test Reports" under Actions column for a patient
    Then User should be navigated to the "View Patient Test Reports" page