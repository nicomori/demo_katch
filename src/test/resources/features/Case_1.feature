@Regression @zipcode
Feature: zipCode feature

Scenario Outline: set a zipcode and press the button search

Given I start the browser with emulation to mobile in "<mobile>"
And I access to this url "<url>"
And I set the zip code "<zipcode>"
Then I press in the button search

Examples:
| url     							| mobile | zipcode |
| http://staging.healthplans.com 	| false  | 91324   |
| http://staging.healthplans.com 	| true   | 91324   |
