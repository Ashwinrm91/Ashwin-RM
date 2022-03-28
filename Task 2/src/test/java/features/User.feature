@User_API @Petstore
Feature: Testing Post, Put, Get, Delete API features of User

@Post_User
Scenario: Creating a single and multiple user data
Given Creating a new user
Then Creating a list of user

@Put_User
Scenario: Updating the exisiting data of the user
Given Updating the existing details of "John"

@Get_User
Scenario: Making the user logging in getting the details of the user then logging out the user
Given User login to the system by using username "John" and password "12345"
Then Getting the user detail of "John"
Then User is logging out

@Delete_User
Scenario: Deleting the user
Given Deleting the user "John"

@Get_User1
Scenario: Validating whether the user  got deleted by trying get the status of user name
Given Validating whether user got deleted or not by getting the username
