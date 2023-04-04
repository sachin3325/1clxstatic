Feature: 1CLX Product Testing
Scenario Outline: individual user Sign-in Testing
    Given user able to enter 1clx sign-in page 
    When the user enters the "<Mail>" and "<Password>"
    And the user clicks the SignIn button.
    Then User gets the results depends on their credentials
    

    Examples: 
      | Mail | Password  |
      |sachin33.theinfinityhub@gmail.com|Sachin@3333|
      |       |      |
      |sachinanand01@gmail.com|jBond@007|
      
       
      
