Feature: Login
@Login
Scenario: Login with invalid credentials
Given launch the browser 
	And navigate to application
When Enter username
	And  password
Then Login should be unsuccessful
	

@Login
Scenario Outline: Login with valid credentials
Given Launch the browser
When Enter  <name> 
And Enter <value>
Then Login should be successful

Examples:
    | name  |value | status |
    | abc@gmail.com |  123456   | success|
    | name2 |  7   | Fail   |
