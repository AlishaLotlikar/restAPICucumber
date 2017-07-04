Feature: My first rest API cucumber test feature

  Scenario: My first rest API cucumber test scenario

    Given the api is "http://localhost:8091"
    When a user setup a get request to "/bananacenter/details"
    And perform the request
    Then the response code should be 200
    And I should see JSON response with pairs on the filtered "Msg" node
      | Message    | Success Location Details |
      | StatusCode | 200                      |
      | isError    | false                    |
      | isSuccess  | true                     |



  Scenario: Post request test scenario

    Given the api is "http://localhost:8091"
    When a user setup a post request to "/bananacenter/details" with below details
      |Movie_Id    | 3 |
      |Location_Id | 5 |
    And perform the post request
    Then the response code should be 200
    And I should see JSON response with pairs on the filtered "Msg" node
      | Message    | Success Location Details |
      | StatusCode | 200                      |
      | isError    | false                    |
      | isSuccess  | true                     |


