@Store_API @Petstore
Feature: Testing Post, Put, Get, Delete API features of Store

@Post_Store
Scenario: Posting the new values of Pet
Given User Posts the new details for Store

@Get_Store
Scenario: Getting the inventory by Status and Order ID
Given User gets the Store details by order id "10"
Given User gets the inventory details by status

@Delete_Store
Scenario: Deleting the purchase order
Given User deletes the Order ID "10"

@Get_Store1
Scenario: User validating whether the order details got deleted by trying get the status of deleted order
Given User validates whether order details deleted or not by getting the order id