@DietitianLogin
Feature: Delete Patient Popup Info Validation

  Background:
    Given User is on the My Patient page

  Scenario Outline: Verify delete patient popup details
    When User clicks the Delete icon for a particular patient in the patient table
    Then "<Validation>" should be "<Value>"

    Examples:
      | validation  		| value                                  |
      | Alert title 		| Confirm                                |
      | Alert text 			 | Are you sure to delete [Patient Name]? |
      | Alert  Yes button     |  Yes                           |
      | Alert  No button      |    No                         | 