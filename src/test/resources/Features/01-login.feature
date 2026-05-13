@Login
Feature: Dietician Application - UI and Functional Validation

  Background:  user is on the browser 

  # ------------------ UI VALIDATION ------------------
 
  Scenario Outline: Validate login page UI elements
    When user enters application URL
    Then "<element>" should have "<Action>" as "<value>"

    Examples:
      | element            						| Action           | value                 |
      | navigation bar title on left side     	| text             | NumpyNinja  		   |
      | navigation bar home icon on left side   | visibility       | visible               |
      | navigation bar            				| background-color | blue-purple           |
      | login card Heading       				| text             | Dietician Application |
      | username label     						| text             | Username:             |
      | password label     						| text             | Password:             |
      | username label    						| alignment        | justify               |
      | password label     						| alignment        | justify               |
      | username field     						| visibility       | visible               |
      | password field     						| visibility       | visible               |
      | input fields       						| count            | 2                     |
      | login button       						| visibility       | visible               |
      | login button       						| enabled          | true                  |
      | login button       						| background-color | blue-purple           |
      | login button       						| text-color       | white                 |

#-------------------------------------Login Functionality---------------------------------------------------------
# ------------------ LOGIN FUNCTIONALITY ------------------
@validlogin
Scenario: Login with valid credentials
Given User is on the login page
When User logs in as "validUser"
Then User should see the dashboard

Scenario: Login with non-existing user
Given User is on the login page
When User logs in as "invalidUser"
Then An error message "Invalid username or password" should be displayed

Scenario: Login with special characters in username
Given User is on the login page
When User logs in as "specialCharUser"
Then An error message "Invalid username or password" should be displayed

Scenario: Login with short username
Given User is on the login page
When User logs in as "shortUser"
Then An error message "Invalid username or password" should be displayed

Scenario: Login with wrong password
Given User is on the login page
When User logs in as "wrongPasswordUser"
Then An error message "Invalid username or password" should be displayed

Scenario: Login with special characters in password
Given User is on the login page
When User logs in as "specialCharPasswordUser"
Then An error message "Invalid username or password" should be displayed

Scenario: Login with empty username
Given User is on the login page
When User logs in as "emptyUsername"
Then An error message "Username is Required" should be displayed

Scenario: Login with empty password
Given User is on the login page
When User logs in as "emptyPassword"
Then An error message "Password is Required" should be displayed
 
