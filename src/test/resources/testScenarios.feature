#Author: Ashish Sonkamble

Feature: Simple request steps to explore rest assured framework
  I want to perform different Rest API functions

  #@testThis
  Scenario: Perform get operation
    Given I setup baseUri
    And I enter the endpoint
    When I perform get operation
    #Then I get the response
    And I get status code as 200

  @testThis
  Scenario: Perform get operation
    Given I setup baseUri
    And I enter the endpoint for purchase
    When I perform get operation
    And I get status code as 200
    
    #@testThis
  Scenario: Perform post operation
  	Given I setup baseUri
  	And I enter the endpoint
  	And I create the request payload
    #When I perform get operation
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
