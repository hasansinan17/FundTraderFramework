Feature: Login

  @negativeLogin
  Scenario: Login with invalid credential
    When user enter invalid "<UserName>","<Password>", and user see "<ErrorMessage>" 
   
      
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid credentials |
      | Hello    | Syntax123! | Invalid credentials |
