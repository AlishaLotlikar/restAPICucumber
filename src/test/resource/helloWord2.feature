Feature: My second rest API cucumber test feature

  Scenario: My second rest API cucumber test scenario

    Given the 2nd api is "http://localhost:8091"
    When b user setup a get request to "/bananacenter/details"
    And send the request
    Then the response code is 200
    And I should see JSON response with pairs under the filtered "Msg" node
      | Message    | Success Location Details |
      | StatusCode | 200                      |
      | isError    | false                    |
      | isSuccess  | true                     |



  Scenario: 2nd Post request test scenario

    Given the 2nd api is "http://localhost:8091"
    When b user setup a post request to "/bananacenter/details" with below details
      |Movie_Id    | 3 |
      |Location_Id | 5 |
    And send the post request
    Then the response code is 200
    And I should see JSON response with pairs under the filtered "Msg" node
      | Message    | Success Location Details |
      | StatusCode | 200                      |
      | isError    | false                    |
      | isSuccess  | true                     |


