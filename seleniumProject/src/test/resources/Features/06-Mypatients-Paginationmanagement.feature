@DietitianLogin
Feature: Pagination Management on My Patients Page
  Validate pagination behavior for multiple, single, maximum, and no patient records

Background: User is logged into the dietician application
  Given User is on the dashboard page
  When User clicks on My Patients button

Rule: Pagination with multiple records
  System should display multiple pages and correct arrow behavior

  Background:
    Given Multiple patient records exist in the system for that user

  Scenario: Validate pagination navigation and arrows
    When User performs the following pagination actions:
      | Action                             | Arrow Clicked |
      | Navigate to next page              | >             |
      | Navigate to previous page          | <             |
      | Navigate to first page             | <<            |
      | Navigate to last page              | >>            |
      | Navigate to any page               | Any           |
      | Navigate to first page             | <<            |
      | Navigate to last page              | >>            |
      | Navigate to intermediate page      | Any           |
    Then Pagination should behave as expected:
      | Action                             | Expected Result                                               |
      | Navigate to next page              | Next set of patient records displayed                         |
      | Navigate to previous page          | Previous set of patient records displayed                     |
      | Navigate to first page             | First page of patient records displayed                       |
      | Navigate to last page              | Last page of patient records displayed                        |
      | Navigate to any page               | Pagination text displays correct range and total              |
      | Navigate to first page             | Previous/First arrows disabled, Next/Last arrows enabled      |
      | Navigate to last page              | Next/Last arrows disabled, Previous/First arrows enabled      |
      | Navigate to intermediate page      | All arrows enabled except page-specific restrictions          |
      | Previous page arrow disabled first | Previous arrow (<) disabled on first page                     |
      | First page arrow disabled first    | First arrow (<<) disabled on first page                       |
      | Next page arrow enabled first      | Next arrow (>) enabled on first page                          |
      | Last page arrow enabled first      | Last arrow (>>) enabled on first page                         |
      | Previous arrow enabled other pages | Previous arrow (<) enabled on all pages except first          |
      | First arrow enabled other pages    | First arrow (<<) enabled on all pages except first            |
      | Last arrow enabled other pages     | Last arrow (>>) enabled on all pages except last              |
      | Next arrow enabled other pages     | Next arrow (>) enabled on all pages except last               |
      | Next arrow disabled last page      | Next arrow (>) disabled on last page                          |
      | Last arrow disabled last page      | Last arrow (>>) disabled on last page                         |

Rule: Pagination with single record
  System should display single page

  Background:
    Given Only one patient record exists in the system for that user

  Scenario: All pagination arrows should be disabled
    Then Pagination Arrows should be disabled:
      | Arrow    |
      | First    |
      | Previous |
      | Next     |
      | Last     |

Rule: Pagination with no records
  System should handle empty table

  Background:
    Given No patient records exist in the system

  Scenario: Pagination shows 0 to 0 of 0 patients
    Then Pagination text should display:
      | Text                    |
      | Showing 0 to 0 of 0 patients |

  Scenario: All pagination arrows should be disabled
    Then Pagination arrows should be disabled:
      | Arrow    |
      | First    |
      | Previous |
      | Next     |
      | Last     |

Rule: Pagination with maximum records per page
   Validate that pagination works when maximum records per page exist

  Background:
    Given Maximum 5 patient records exist per page

  Scenario: Each page displays only 5 records
    Then User should see only 5 records in each mypatients page

  Scenario: Newly added record moves to the next page when 6th record is added
    Given User is in My Patients page with table displays maximum of 5 record per page
    When User adds 6th record
    Then User should see the newly added record in the next page