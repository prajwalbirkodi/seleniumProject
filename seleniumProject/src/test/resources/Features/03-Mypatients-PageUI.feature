@DietitianLogin
Feature: UI Validation of My Patients Page 
  
Background: User is logged into the application
  Given User is on the dashboard page
  When User clicks on My Patients button
  
  Scenario: Validate page header and  search components
    Then  the following elements should be displayed:
      | Element            | Expected Value |
      | page header        | My Patients    |
      | search bar         | visible        |
      | search icon        | visible        |
      | placeholder text   | Search...      |

 
  Scenario: Validate patient table column headers
  Then the following columns should be displayed:
    | Patient Id      |
    | Name            |
    | Details         |
    | Last Visit Date |
    | Actions         |
    | Edit/Delete     |
 
  @mypatients
  Scenario: Validate sorting icon on Patient Id column
  #Then Up and Down arrow icons should be displayed in the Patient Id column header 
  Then Up and Down arrow icons should be displayed in the Patient Id of My Patients Page column header 
  
  Scenario: Validate sorting icon on Name column
  Then Up and Down arrow icons should be displayed in the Name column header 
     

