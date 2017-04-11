# service-result
[![Build Status](https://travis-ci.org/Viascom/service-result.svg?branch=develop)](https://travis-ci.org/Viascom/service-result)

## What is service-result

Service result is a structural pattern for RESTful Web Services. This pattern provides a type safe and well structured response format. The surplus value is that you alway will get a service-result regardless of whether the response is successful, failed, expected or an error. This is an example for a service-result:

```
{
  "status": "successful",
  "type": "ch.viascom.example.models.response.GetTasksResponse",
  "content": [
    {
      "id": "3e99c7fb-0ed7-11e7-a7a5-0050569c3e5a",
      "name": "Example Task"
    }
  ],
  "hash": "7bf9c04d1e9f8fe7995e4b8beeac1a4c830e7ea",
  "destination": null,
  "metadata": {}
}
```