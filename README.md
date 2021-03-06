# service-result [![Build Status](https://travis-ci.org/Viascom/service-result.svg?branch=develop)](https://travis-ci.org/Viascom/service-result) [![Join the chat at https://gitter.im/Viascom/service-result](https://badges.gitter.im/Viascom/service-result.svg)](https://gitter.im/Viascom/service-result?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

## Table of Contents
1. [What is service-result](#what-is-service-result)
2. [Using service-result](#using-service-result)
3. [Structure of a service-result](#structure-of-a-service-result)
4. [License](#license)

## What is service-result

Service result is a structural pattern for RESTful Web Services. This pattern provides a type safe and well structured response format. The surplus value is that you will always get a service-result regardless of whether the response is successful, failed, expected or an error. This is an example for a service-result:

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
  "destination": "ch.viascom.example.handler.TaskHandler",
  "metadata": {
  
  }
}
```
___

## Using service-result

You can add service-result to your project by the following Maven or Gradle dependency.

### Maven
```xml
<dependency>
    <groupId>ch.viascom.groundwork</groupId>
    <artifactId>service-result</artifactId>
    <version>1.4</version>
</dependency>
```

### Gradle
```
compile 'ch.viascom.groundwork:service-result:1.4'
```
___

## Structure of a service-result

| element		| explanation 																							|
| ------------- | ----------------------------------------------------------------------------------------------------- |
| status		| can be successful or failed and is the logical answer to the question: Did you got what you asked for?	|
| type			| fully qualified name of the model																					|
| content		| your plain serialized information																		|
| hash			| hash of the content																					|
| destination	| information about where the response should go (useful for queues and streams)						|													|
| metadata		| key-value pairs for additional related data																	|

## License

[Apache License, Version 2.0, January 2004](http://www.apache.org/licenses/)
