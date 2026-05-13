@DietitianLogin
Feature: Validate Patient Table on My Patients Page
  Validate patient table behavior for users with and without patient records

Background: User is logged into the application
  Given User is on the dashboard page
  When User clicks on My Patients button

Rule: Patient Table With Records
  System should display patient data when records exist

  Background:
    Given Patient records exist in the system

  Scenario: Validate patient table data
    Then All columns should have values for each patient record

  Scenario: Validate patient details
    Then Following patient details should be displayed:
      | field           |
      | Patient Id      |
      | Patient name    |
      | phone number    |
      | email           |
      | date of birth   |
      | last visit date |

  Scenario: Validate data formats
    Then Following formats should be valid:
      | field           | format        |
      | email           | valid email   |
      | phone number    | numeric       |
      | date of birth   | dd-mm-yyyy    |
      | last visit date | dd-mm-yyyy    |

  Scenario: Validate actions column for each patient
    Then The following actions should be displayed for each patient:
      | action                     |
      | View Previous Test Reports |
      | View Previous Diet Plans   |
      | Create New Report/plan     |
    Then Edit icon should be displayed for each patient
    Then Delete icon should be displayed for each patient

Rule: Patient Table Without Records
  System should display empty table

  Background:
    Given No patient records exist in the system

  Scenario: Validate empty patient table
    Then My Patients page should display with empty table
    Then Pagination details should be displayed:
      | text                          |
      | Showing 0 to 0 of 0 patients  |
    Then The following pagination controls should be disabled:
      | First    |
      | Previous |
      | Next     |
      | Last     |