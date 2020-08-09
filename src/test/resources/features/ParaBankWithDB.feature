@parabankwithDB
Feature: Parabank Assignment_Thamarai

Background:
	Given User Launch the Parabank Application

  Scenario: Register The User and Creating Account and Trasferring
  		
  		When Register The User Using DB
  		Then The user should be able to login into Parabank Using DB
  		Then The user should be able to Create a new Account Using DB
  		Then The user should be able to transferFunds from one accont to another Using DB
  		Then The user should be able to view the list of accounts Using DB