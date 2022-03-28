@Pet_API @Petstore
Feature: Testing Post, Put, Get, Delete API features of Pet

@Post_Pet
Scenario: Posting the new values of Pet
Given User Posts the new details for Pet

@Put_Pet
Scenario: Updating the exisiting values of Pet
Given User updates the existing details for Pet

#@PostImage_Pet
#Scenario: Updating the exisiting values of Pet Image
#Given User uploads images

@Get_Pet
Scenario: Getting the value of Pet
Given User gets the pet details by "available"
Given User gets the pet details by "Mark"
Given User gets the pet details by "12"

@Delete_Pet
Scenario: Deleting the value of Pet
Given User deletes the Pet ID "10"