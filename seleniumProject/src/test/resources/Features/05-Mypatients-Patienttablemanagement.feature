@DietitianLogin
Feature: Validate sorting and search functionality for patient table

Background: User is in dietician dashboard page with patient records 
  Given Patient records exist in the system and User is in My Patients page

Scenario Outline: Validate sorting functionality
  When User clicks "<arrow>" arrow in "<column>" column
  Then Patient records should be sorted in "<order>" order by "<column>"

Examples:
  | column     | arrow | order      |
  | Patient Id | up    | ascending  |
  | Patient Id | down  | descending |
  | Name       | up    | ascending  |
  | Name       | down  | descending |

Scenario Outline: Validate search functionality
  When User searches using "<type>" with value "<value>"
  Then Matching patient details should be displayed

Examples:
  | type | value |
  | name | John  |
  | patientid   | P123  |

Scenario: Validate clear search
  Given User entered text in search box
  When User clears the search text
  Then All patient records should be displayed again