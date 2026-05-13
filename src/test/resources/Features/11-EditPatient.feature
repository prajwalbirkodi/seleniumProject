@DietitianLogin
  Feature: Edit Patient - Dialog Box Validation

    Background:
      Given Patients already exists and Dietitian is in My patients page

    Scenario: Title of the dialog box
      When User clicks edit icon for the particular patient
      Then User should see Edit Patient page on the dialog box

    Scenario: Presence of Submit button
      When User clicks edit icon for the particular patient
      Then User should see submit button

    Scenario: State of submit button
      When User clicks edit icon for the particular patient
      Then User should see submit button in enable mode

    Scenario: Presence of Close button
      When User clicks edit icon for the particular patient
      Then User should see close button

    Scenario: State of close button
      When User clicks edit icon for the particular patient
      Then User should see close button in enable mode

    Scenario: Presence of 9 input fields
      When User clicks edit icon for the particular patient
      Then User should see 9 input fields

    Scenario: Presence of 3 drop downs
      When User clicks edit icon for the particular patient
      Then User should see 3 drop downs

    Scenario: Presence of file upload option
      When User clicks edit icon for the particular patient
      Then User should see exactly 1 file upload option

    Scenario: Presence of first name of the patient
      When User clicks edit icon for the particular patient
      Then User should see the "First Name" field populated with the value entered during patient creation

    Scenario: Presence of last name of the patient
      When User clicks edit icon for the particular patient
      Then User should see the "Last Name" field populated with the value entered during patient creation

    Scenario: Presence of Email of the patient
      When User clicks edit icon for the particular patient
      Then User should see the "Email" field populated with the value entered during patient creation

    Scenario: Presence of Contact Number of the patient
      When User clicks edit icon for the particular patient
      Then User should see the "Contact Number" field populated with the value entered during patient creation

    Scenario: Presence of allergy info of the patient
      When User clicks edit icon for the particular patient
      Then User should see the "Allergy" field populated with the value entered during patient creation

    Scenario: Presence of patients food preference
      When User clicks edit icon for the particular patient
      Then User should see the "Food Preference" field populated with the value entered during patient creation

    Scenario: Presence of patients cuisine preference
      When User clicks edit icon for the particular patient
      Then User should see the "Cuisine Category" field populated with the value entered during patient creation

    Scenario: Presence of patients DOB info
      When User clicks edit icon for the particular patient
      Then User should see the "Date of Birth" field populated with the value entered during patient creation

    Scenario: Presence of Vitals subtitle
      When User clicks edit icon for the particular patient
      Then User should see vitals title after DOB field

    Scenario: Presence of SP field
      When User clicks edit icon for the particular patient
      Then User should see SP placeholder in SP field

    Scenario: Presence of DP field
      When User clicks edit icon for the particular patient
      Then User should see DP placeholder in DP field

    Scenario: Presence of Weight field
      When User clicks edit icon for the particular patient
      Then User should see Weight placeholder in Weight field

    Scenario: Presence of Height field
      When User clicks edit icon for the particular patient
      Then User should see Height placeholder in Height field

    Scenario: Presence of Temperature field
      When User clicks edit icon for the particular patient
      Then User should see Temperature placeholder in Temperature field

    Scenario: Vitals fields should not have mandatory indicator
      When User clicks edit icon for the particular patient

      Then User should not see mandatory indicators for Vitals Information fields

    Scenario: Presence of Upload health report label
      When User clicks edit icon for the particular patient
      Then User should see "Upload health report :" text for Upload button

    Scenario: Presence of No File Chosen text
      When User clicks edit icon for the particular patient
      Then User should see "No File Chosen" text

    Scenario: Close button color
      When User clicks edit icon for the particular patient
      Then Close button should have red color


    Scenario Outline: Pre-populated fields should show patient creation values
      When User clicks edit icon for the particular patient
      Then User should see the "<field>" field populated with the value entered during patient creation

      Examples:
        | field            |
        | First Name       |
        | Last Name        |
        | Email            |
        | Contact Number   |
        | Allergy          |
        | Food Preference  |
        | Cuisine Category |
        | Date of Birth    |


    Scenario Outline: Vitals fields should show correct placeholders
      When User clicks edit icon for the particular patient
      Then User should see "<vital>" placeholder in "<vital>" field

      Examples:
        | vital       |
        | SP          |
        | DP          |
        | Weight      |
        | Height      |
        | Temperature |