Feature: this file contains product test cases.

Scenario: Verify search result for polo men.

#Given chrome browser should open.
Given myntra url should launch.
When user search for polo tshirt.
Then all result should be related polo tshirt.