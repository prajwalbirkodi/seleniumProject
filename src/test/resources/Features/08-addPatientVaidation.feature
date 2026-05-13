@DietitianLogin
Feature: Add Patient dialog validations

  Background: User logged into application and opens New Patient dialog
    Given User is on Dashboard page
    When User clicks on New Patient in the header section

  Scenario: Title of the dialog box
    Then User should see Add Patient Details on the dialog box

  Scenario: Presence of 9 input fields
    Then User should see 9 input boxes in the Add Patient Details dialog box

  Scenario: Presence of 3 dropdowns
    Then User should see 3 dropdowns in the Add Patient Details dialog box

  Scenario: Presence of a Date Picker field
    Then User should see a date picker for DOB field with MM/DD/YYYY displayed

  Scenario: Presence of file Upload option
    Then User should see exactly 1 file upload option in Add Patient Details dialog box

  Scenario: Presence of Submit button
    Then User should see one Submit button

  Scenario: State of Submit button
    Then User should see one Submit button in disabled state

  Scenario: Presence of Close button
    Then User should see one Close button

  Scenario: State of Close button
    Then User should see one Close button in enabled state

  Scenario: Placeholder for first field - firstname
    Then User should see mandatory field with placeholder "First name"

  Scenario: Placeholder for second field - lastname
    Then User should see mandatory field with placeholder "Last name"

  Scenario: Placeholder for third field - Email
    Then User should see mandatory field with placeholder "Email"

  Scenario: Placeholder for second field - Contact Num
    Then User should see mandatory field with placeholder "Contact Number"

  Scenario: Placeholder for dropdown - Allergies
    Then User should see mandatory dropdown with placeholder "Allergies"

  Scenario: Placeholder for dropdown - Food Preference
    Then User should see mandatory dropdown with placeholder "Food Preference"

  Scenario: Placeholder for dropdown - Cusine Category
    Then User should see mandatory dropdown with placeholder "Cusine Category"

  Scenario: Placeholder for DOB field
    Then User should see mandatory DOB with placeholder "Date of Birth"

  Scenario: Placeholder for Vitals section - Weight
    Then User should see non-manadatory field placeholder with "Weight"

  Scenario: Placeholder for Vitals section - Height
    Then User should see non-manadatory field placeholder with "Height"

  Scenario: Placeholder for Vitals section - Temperature
    Then User should see non-manadatory field placeholder with "Temperature"

  Scenario: Placeholder for Vitals section - SP
    Then User should see non-manadatory field placeholder with "SP"

  Scenario: Placeholder for Vitals section - DP
    Then User should see non-manadatory field placeholder with "DP"

  Scenario: Presence of Upload Health Report
    Then User should see text Upload Health Report

  Scenario: Presence of No file Chosen when no files uploaded
    Then User should see text No file Chosen

  Scenario: Presence of scroll bar on the dialog box
    Then User should see a scroll bar at the right side of dialog box
