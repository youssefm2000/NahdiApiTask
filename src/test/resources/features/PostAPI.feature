Feature: Post API Tests

  Scenario: Create a new post
    Given the API is available
    When I create a post with title "foo", body "bar" and userId 1
    Then the response status should be 201
    And the response should contain title "foo" and body "bar"

  Scenario: Get all posts
    Given the API is available
    When I retrieve all posts
    Then the response status should be 200
    And the total number of posts should be 100

  Scenario: Get post with ID 20
    Given the API is available
    When I retrieve the post with ID 20
    Then the response status should be 200
    And the response should contain ID 20

  Scenario: Get non-existent post
    Given the API is available
    When I retrieve the post with ID 9999
    Then the response status should be 404
