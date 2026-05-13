@DietitianLogin
Feature: Add Patient Details Validation

  Background: Navigation to Add Patient Dialog box
    Given User is logged into the Dietitian application
    When User clicks on "New Patient" Link
    Then User is on Add Patient Details Dialog Box

  @UI_Validation
  Scenario Outline: Verify Patient Details UI validation for various fields
    When User enters for "<TestCaseID>" from Excel sheet "PatientData" and navigates to next field
    Then User should see the expected error for "<TestCaseID>"

    Examples:
      | TestCaseID                          |
      | First Name  Numeric Data            |
      | First Name Special Characters       |
      | First Name Mandatory                |
      | Last Name Numeric                   |
      | Last Name Special Characters        |
      | Last Name Mandatory                 |
      | Email Start With Number             |
      | EmailWithout @ Symbol               |
      | Email With Special Charact          |
      | Email without .com                  |
      | Email Already Exists                |
      | Email Mandatory                     |
      | Contact Number Alphabets            |
      | Contact Number Special Characters   |
      | Contact Number Too Short            |
      | Contact Number Too Long             |
      | Contact Number Mandatory            |
      | Allergies Field Empty               |
      | Food Preference Field Empty         |
      | Cuisine Category Field Empty        |
      | Date of Birth Empty                 |
      | Weight with Valid Data              |
      | Weight With Special Characters      |
      | Weight With Alphabets               |
      | Height With Valid Data              |
      | Height With Special Characters      |
      | Height With Alphabets               |
      | Temperature with valid data         |
      | Temperature With Special Characters |
      | Temperature With Alphabets          |
      | SD DP with Valid Data               |
      | SP DP With Special Characters       |
      | SP DP With Alphabets                |
      | Upload Valid Pdf File               |
      | Invalid File Type Upload            |
      | File Exceeding Size Limit           |

  @UploadWithoutFile
  Scenario: Validate submission without selecting a file
    Given User has entered all valid patient details except for a file upload
    When User clicks the Submit button without selecting a file
    Then User should see the new patient record added successfully on the My Patient page

  @TestReportVerification
  Scenario: Verify the presence of record details in test report
    Given User has successfully submitted a patient form with a "pdf" health report
    When User clicks "View Previous Test Report" in the Test Report section
    Then User should see the record number, PDF file, upload date, and health conditions in the  view report page

  @Navigation
  Scenario: Close Patient dialog box using the Close button
    Given User has completed a patient data submission
    When User clicks the Close button on the confirmation dialog
    Then Add Patient dialog should close and redirect the user to the My Patient page
