$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Pet.feature");
formatter.feature({
  "line": 2,
  "name": "Testing Post, Put, Get, Delete API features of Pet",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-pet",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Pet_API"
    },
    {
      "line": 1,
      "name": "@Petstore"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Posting the new values of Pet",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-pet;posting-the-new-values-of-pet",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Post_Pet"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User Posts the new details for Pet",
  "keyword": "Given "
});
formatter.match({
  "location": "PetApiMethod.PostRequest()"
});
formatter.result({
  "duration": 2858346200,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Updating the exisiting values of Pet",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-pet;updating-the-exisiting-values-of-pet",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@Put_Pet"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User updates the existing details for Pet",
  "keyword": "Given "
});
formatter.match({
  "location": "PetApiMethod.PutRequest()"
});
formatter.result({
  "duration": 61906100,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 12,
      "value": "#@PostImage_Pet"
    },
    {
      "line": 13,
      "value": "#Scenario: Updating the exisiting values of Pet Image"
    },
    {
      "line": 14,
      "value": "#Given User uploads images"
    }
  ],
  "line": 17,
  "name": "Getting the value of Pet",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-pet;getting-the-value-of-pet",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@Get_Pet"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "User gets the pet details by \"available\"",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "User gets the pet details by \"Mark\"",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "User gets the pet details by \"12\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "available",
      "offset": 30
    }
  ],
  "location": "PetApiMethod.GetRequest(String)"
});
formatter.result({
  "duration": 80952000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mark",
      "offset": 30
    }
  ],
  "location": "PetApiMethod.GetRequest(String)"
});
formatter.result({
  "duration": 71493700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "12",
      "offset": 30
    }
  ],
  "location": "PetApiMethod.GetRequest(String)"
});
formatter.result({
  "duration": 30845100,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Deleting the value of Pet",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-pet;deleting-the-value-of-pet",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@Delete_Pet"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "User deletes the Pet ID \"10\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 25
    }
  ],
  "location": "PetApiMethod.DeleteRequest(String)"
});
formatter.result({
  "duration": 40840500,
  "status": "passed"
});
formatter.uri("Store.feature");
formatter.feature({
  "line": 2,
  "name": "Testing Post, Put, Get, Delete API features of Store",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-store",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Store_API"
    },
    {
      "line": 1,
      "name": "@Petstore"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Posting the new values of Pet",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-store;posting-the-new-values-of-pet",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Post_Store"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User Posts the new details for Store",
  "keyword": "Given "
});
formatter.match({
  "location": "StoreApiMethod.PostRequest()"
});
formatter.result({
  "duration": 30069900,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Getting the inventory by Status and Order ID",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-store;getting-the-inventory-by-status-and-order-id",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@Get_Store"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User gets the Store details by order id \"10\"",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "User gets the inventory details by status",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 41
    }
  ],
  "location": "StoreApiMethod.GetByOrderID(String)"
});
formatter.result({
  "duration": 39399000,
  "status": "passed"
});
formatter.match({
  "location": "StoreApiMethod.GetInvertorybyStatus()"
});
formatter.result({
  "duration": 28659900,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Deleting the purchase order",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-store;deleting-the-purchase-order",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@Delete_Store"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "User deletes the Order ID \"10\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 27
    }
  ],
  "location": "StoreApiMethod.DeleteRequest(String)"
});
formatter.result({
  "duration": 25303600,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "User validating whether the order details got deleted by trying get the status of deleted order",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-store;user-validating-whether-the-order-details-got-deleted-by-trying-get-the-status-of-deleted-order",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@Get_Store1"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "User validates whether order details deleted or not by getting the order id",
  "keyword": "Given "
});
formatter.match({
  "location": "StoreApiMethod.GetDeletedRequest()"
});
formatter.result({
  "duration": 33796100,
  "status": "passed"
});
formatter.uri("User.feature");
formatter.feature({
  "line": 2,
  "name": "Testing Post, Put, Get, Delete API features of User",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@User_API"
    },
    {
      "line": 1,
      "name": "@Petstore"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Creating a single and multiple user data",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-user;creating-a-single-and-multiple-user-data",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Post_User"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Creating a new user",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Creating a list of user",
  "keyword": "Then "
});
formatter.match({
  "location": "UserApiMethod.CreateSingleUser()"
});
formatter.result({
  "duration": 26144600,
  "status": "passed"
});
formatter.match({
  "location": "UserApiMethod.CreateListOfUser()"
});
formatter.result({
  "duration": 22737100,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Updating the exisiting data of the user",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-user;updating-the-exisiting-data-of-the-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@Put_User"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Updating the existing details of \"John\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "John",
      "offset": 34
    }
  ],
  "location": "UserApiMethod.UpdatesTheUser(String)"
});
formatter.result({
  "duration": 27269700,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Making the user logging in getting the details of the user then logging out the user",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-user;making-the-user-logging-in-getting-the-details-of-the-user-then-logging-out-the-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@Get_User"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "User login to the system by using username \"John\" and password \"12345\"",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Getting the user detail of \"John\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "User is logging out",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "John",
      "offset": 44
    },
    {
      "val": "12345",
      "offset": 64
    }
  ],
  "location": "UserApiMethod.GetUserLogIn(String,String)"
});
formatter.result({
  "duration": 22626500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "John",
      "offset": 28
    }
  ],
  "location": "UserApiMethod.GetUser(String)"
});
formatter.result({
  "duration": 38762400,
  "status": "passed"
});
formatter.match({
  "location": "UserApiMethod.GetUserLogout()"
});
formatter.result({
  "duration": 26079300,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Deleting the user",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-user;deleting-the-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@Delete_User"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "Deleting the user \"John\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "John",
      "offset": 19
    }
  ],
  "location": "UserApiMethod.DeleteUser(String)"
});
formatter.result({
  "duration": 32067900,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Validating whether the user  got deleted by trying get the status of user name",
  "description": "",
  "id": "testing-post,-put,-get,-delete-api-features-of-user;validating-whether-the-user--got-deleted-by-trying-get-the-status-of-user-name",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@Get_User1"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Validating whether user got deleted or not by getting the username",
  "keyword": "Given "
});
formatter.match({
  "location": "UserApiMethod.UserDeletedRequest()"
});
formatter.result({
  "duration": 26475500,
  "status": "passed"
});
});