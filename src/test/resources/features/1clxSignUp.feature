Feature: 1CLX Product Testing
Scenario Outline: Business User Sign-up Testing
    Given user able to enter 1clx sign-up page 
    When the user enters the "<Name>","<Mail>",and "<Password>"
    And the user clicks the Create Account button.
    Then User gets the results depends on their entering credentials
    

    Examples: 
      | Name  | Mail | Password  |
      
      |Sachin|sachinanand584@gmail.com|Sachin@1111|
      |      |       |      |
      |3235524390|223647890@gmail.com|Welcome@373|
      |Sdvk281|sdvkktesting009@gmail.com|SdVrJjyy@333455|
      |fagaga|   |Weje@33|
      |   |sachin@gmail.com|ewr@37EE|
      |Dinesh|dinesh@gmail.com|   |
      