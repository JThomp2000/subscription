Subscription Restful API Instructions

Below are the instructions for the use of the Subscription Restful API.  All access calls begin at the URL of:  http://localhost:8080/subscription
Headers are required for the use of the API for corresponding XML and JSON calls.  The following headers must be present in each request:
Content-Type    :   application/json    or    text/xml
Accept   :   application/json     or     text/xml

The following below lists the API calls and their purpose as well as the required requests and the corresponding responses.  All API requests will be represented in JSON but the equivalent XML counterpart will be accepted.  The variable type will be represented next to the variable name.
Create a subscription
Link : http://localhost:8080/subscription
Request type : POST
This will create a subscription.  It requires a list of message types with minimum requirement of (1) message.  A status code of 201 will be returned upon successful creation.
Request
{
	"messageTypes": [
	  {
	    "messageType": "String",
	    "message": "String"
	  }
	]
}

Response

{
  "identifier": long,
  "errorMessage": "String",
  "eventsCount": [
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    }
  ],
  "messageTypes": [
    {
      "identifier": long,
      "messageType": "String",
      "message": "String"
    }
  ],
  "_links": {
    "self": {
      "href": "String"
    },
    "PUT": {
      "href": "String"
    },
    "POST": {
      "href": "String"
    }
  }
}

Update a subscription
Link : http://localhost:8080/subscription/{subscriptionID}
Request type : PUT
This will update a subscription.  It requires a list of message types with minimum requirement of (1) message.  All messages will be overwritten / replaced on updating a subscription.  A status code of 200 will be returned upon successful creation.
Request
{
	"messageTypes": [
	  {
	    "messageType": "String",
	    "message": "String"
	  }
	]
}

Response

{
  "identifier": long,
  "errorMessage": "String",
  "eventsCount": [
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    }
  ],
  "messageTypes": [
    {
      "identifier": long,
      "messageType": "String",
      "message": "String"
    }
  ],
  "_links": {
    "self": {
      "href": "String"
    },
    "PUT": {
      "href": "String"
    },
    "POST": {
      "href": "String"
    }
  }
}









Read a subscription
Link : http://localhost:8080/subscription/{subscriptionID}
Request type : GET
This will get a subscription.  It does not require any input body.  A status code of 200 will be returned upon successful creation.
Response

{
  "identifier": long,
  "errorMessage": "String",
  "eventsCount": [
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    }
  ],
  "messageTypes": [
    {
      "identifier": long,
      "messageType": "String",
      "message": "String"
    }
  ],
  "_links": {
    "self": {
      "href": "String"
    },
    "PUT": {
      "href": "String"
    },
    "POST": {
      "href": "String"
    }
  }
}

Post  a message
Link : http://localhost:8080/subscription/{subscriptionID}/message
Request type : POST
This will post a message to  a subscription.  It requires a message type.  The message will be added to the existing messages.  A status code of 201 will be returned upon successful creation.
Request
{
	 "messageType": "String",
	 "message": "String"
}

Response

{
  "identifier": long,
  "errorMessage": "String",
  "eventsCount": [
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    },
    {
      "requestType": "String",
      "accessCount": int
    }
  ],
  "messageTypes": [
    {
      "identifier": long,
      "messageType": "String",
      "message": "String"
    }
  ],
  "_links": {
    "self": {
      "href": "String"
    },
    "PUT": {
      "href": "String"
    },
    "POST": {
      "href": "String"
    }
  }
}

