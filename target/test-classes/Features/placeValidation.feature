Feature: Validating place APIs
@AddPlace
@Regression
  Scenario Outline: Verify if place is being added using AddPlace API
          Given Add Place API Payload "<name>" "<language>" "<address>"
          When user Calls "AddPlace" api with "Post" https request
          Then the API call is success with status code 200
          And "status" in response body "OK"
          And "scope" in response body "APP"
          And verify "<name>" on hitting "getPlace" API 

          
          Examples:

                  |name     |language|address|
                  |Siddharth|English |Patera |
      #            |Pratiksha|Hindi |Rewa |
      
@deletePlace  
@Regression   
Scenario: Verify place being added can be deleted using DeletePlace API
          Given DeletePlace API Payload 
          When user Calls "deletePlace" api with "Post" https request
          Then the API call is success with status code 200
          And "status" in response body "OK"
         
