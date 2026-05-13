@DietitianLogin
Feature: View Test Report

  Background:
   Given User is in My Patients page

    Scenario Outline: UI elements should be visible on vew patients test reports page
      When User clicks View Previous Test Reports button for a particular record
      Then <ElementsToBeDisplayed>
      Examples:
            |ElementsToBeDisplayed|
            |Title View Patient Test Reports should be displayed  |
            |Patient ID field should be displayed |
            |Name field should be displayed |
            |Email should be displayed  |
            |Contact Number field should be displayed |
            |Close icon x should be displayed |

  Scenario: Report table is displayed
    When User clicks View Previous Test Reports button for a particular record
    Then Reports table should be displayed

  Scenario Outline: Table headers column are displayed
    When User clicks View Previous Test Reports button for a particular record
    Then Table headers should have below "<fields>"
  Examples:
    |fields|
        |Record Number|
        |File|
        |Uploaded Time|
        |File/Report Name|
        |Vitals|
        |Identified Health Conditions|

  Scenario: Pagination controls are displayed
    When User clicks View Previous Test Reports button for a particular record
    Then Pagination controls First, previous, next, last arrows should be displayed

  Scenario: View PDF button display
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display View PDF button

  Scenario: Vitals order
    When User clicks View Previous Test Reports button for a particular record
    Then Vitals should be displayed in the order Weight → Height → Temperature → SP → DP

  Scenario: Vitals displayed in multiline format
    When User clicks View Previous Test Reports button for a particular record
    Then Vitals should be displayed in multiLines

  Scenario: Health conditions display
    When User clicks View Previous Test Reports button for a particular record
    Then Each report should display Identified health conditions

  Scenario: Health conditions displayed in multiline format
    When User clicks View Previous Test Reports button for a particular record
    Then Identified health conditions should be displayed in multiLines

  Rule: "View PDF" for dietician

    Background:
      Given User is in My Patients page

      Scenario: Corresponding PDF report opens for a record
       When User clicks View PDF button for a particular record
        Then Corresponding report for that record should be opened

  Rule: Pagination management - User records with multiple test reports must be available

    Background:
      Given User is in View Patient Test Reports page with multiple pages of record

    Scenario Outline: Navigate between pages using pagination arrows
      Given User is in "<startCondition>"
      When User clicks the "<arrow>" pagination arrow
      Then "<expectedResult>" should be displayed

      Examples:
        | startCondition                                       | arrow | expectedResult                        |
        | View Patient Test Reports page with multiple records | >     | Next set of patient records           |
        | Report table of View Patient Test Reports page       | <     | Previous set of patient records       |
        | any page except first page of Report table           | <<    | First page of patient records         |
        | any page except last page of Report table            | >>    | Last page of patient records          |

    Scenario: Pagination count is updated correctly
      Given User is in any page of Report table
      When User clicks any page navigation arrow
      Then Pagination text should display the correct range and total number of patients

    Scenario: Pagination is displayed when patient records exceed one page
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to any page
      Then Pagination controls should be displayed


    Scenario Outline: Pagination arrow states based on page navigation
      Given User is in View Patient Test Reports page with multiple pages of record
      When User navigates to "<navigateTo>"
      Then "<arrow>" should be "<state>" state
      Examples:
        |      navigateTo               | arrow | state    |
        | first page of patient record  | <     | disabled |
        | first page of patient record  | <<    | disabled |
        | first page of patient record  | >     | enabled  |
        | first page of patient record  | >>    | enabled  |
        | any page after the first page | <     | enabled  |
        | any page after the first page | <<    | enabled  |
        | any page except the last page | >>    | enabled  |
        | any page except the last page | >     | enabled  |
        | last page of patient record   | >     | disabled |
        | last page of patient record   | >>    | disabled |

  Rule: Pagination management - User records with single test reports must be available

  Background: Only one patient record already exist in the system for that user

    Scenario: All pagination arrows disabled when only one page exists
      Given User is in My Patients page
      When User clicks on View Patient Test Reports button
      Then First, previous, next, last arrows should be disabled

  Rule: Pagination management - when no data exists in the table

    Background: User logged into the application without patient added to that user

    Scenario: Pagination when no patient data exists
      Given User is in My Patients page
      When User clicks on View Patient Test Reports button
      Then "Showing 0 to 0 of 0 patients" should be displayed

    Scenario: All pagination arrows disabled when no data exists
      Given User is in My Patients page
      When User clicks on View Patient Test Reports button
      Then First, previous, next, last arrows should be disabled

  Rule: Pagination management with maximum record in a page

    Background: User is in view patient test report page with multiple records already exist in the system for that user

    Scenario: Each page should display only 2  records
      Given User is in dietician application dashboard page
      When User clicks on my Patients button
      Then User should see only 2 records in each page

