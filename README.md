# PAYMENT API DOCUMENTATION (DESIGN AND ARCHITECTURE)
### Table of Contents

1. **Introduction**
   - 1.1 Purpose
   - 1.2 Scope
   - 1.3 Background

2. **Architecture Overview**
   - 2.1 High-Level Architecture
   - 2.2 Design Principles
   - 2.3 Core Components

3. **Configuration Management**
   - 3.1 Pipeline Configuration
     - 3.1.1 Purpose and Usage
     - 3.1.2 Bean Definitions
   - 3.2 Dependency Injection
     - 3.2.1 Use of `ObjectProvider`
     - 3.2.2 Integration with Pipelinr

4. **Controller Layer**
   - 4.1 PaymentController
     - 4.1.1 Purpose
     - 4.1.2 REST Endpoint Definitions
     - 4.1.3 Interaction with Pipeline

5. **Data Access Layer**
   - 5.1 PaymentRepository
     - 5.1.1 Purpose
     - 5.1.2 Static Repository Implementation
     - 5.1.3 Future Database Considerations

6. **DTOs (Data Transfer Objects)**
   - 6.1 Purpose of DTOs
   - 6.2 DTO Definitions
     - 6.2.1 `GetPaymentsCommand`
     - 6.2.2 `PaymentRequest`
     - 6.2.3 `PaymentResponse`
     - 6.2.4 `PaymentResponseDto`
     - 6.2.5 `PaymentTypeResponse`

7. **Enumerations**
   - 7.1 PaymentType Enumeration
     - 7.1.1 Purpose
     - 7.1.2 Usage in PaymentFactory

8. **Exception Handling**
   - 8.1 Custom Exceptions
     - 8.1.1 Purpose
     - 8.1.2 Types and Use Cases

9. **Factory Pattern Implementation**
   - 9.1 PaymentFactory
     - 9.1.1 Purpose
     - 9.1.2 Integration with Payment Parsers
     - 9.1.3 Handling Unknown Payment Types

10. **Models**
    - 10.1 Payment Entity
      - 10.1.1 Purpose
      - 10.1.2 Attributes

11. **Parser Pattern**
    - 11.1 Purpose of Parsers
    - 11.2 PaymentParser Interface
    - 11.3 CardParser Implementation
    - 11.4 PaymentParser Usage

12. **Use Case Layer**
    - 12.1 GetPaymentUseCase
      - 12.1.1 Purpose
      - 12.1.2 Interaction with PaymentRepository
    - 12.2 MakePaymentUseCase
      - 12.2.1 Purpose
      - 12.2.2 Interaction with PaymentRepository
    - 12.3 PaymentStorage Interface
      - 12.3.1 Purpose
      - 12.3.2 Implementation in PaymentRepository

13. **Testing**
    - 13.1 Groovy Test Cases
      - 13.1.1 Purpose
      - 13.1.2 Coverage
      - 13.1.3 Use of Groovy for Test Cases
   
##1. Introduction
### 1.1 Purpose
The purpose of this document is to provide a comprehensive overview of the design and architecture of the Payment API design.

### 1.2 Scope
The scope of this document encompasses the design patterns, components, and their interactions within the payment API design.

### 1.3 Background
In response to the growing demand for a robust and efficient payment processing solution, I embarked on the development of two payment API. The APIs caters to diverse payment types, employs configurable pipelines, and integrates a range of design patterns to ensure flexibility and maintainability. This document explores the foundational aspects of the system, delving into its architecture, key components, and the rationale behind design decisions. Understanding this background is crucial for anyone involved in the development, maintenance, or enhancement of the Payment System.

## 2. Architecture Overview
### Makepayment design
![structurizr-Container-001](https://github.com/NkanorJ/payment-API/assets/71755372/e342eea2-0b38-4297-b554-b27b7ccdacef)

Get payment deisgn
![structurizr-SystemContext-001](https://github.com/NkanorJ/payment-API/assets/71755372/9d422166-2957-4be5-8e07-bb670423f888)


## 3. Configuration Management
In our Payment Processing System, configuration management is handled intelligently through the use of pipelines and dependency injection.

### 3.1 Pipeline Configuration
#### 3.1.1 Purpose and Usage
Purpose: The pipeline orchestrates the flow of commands, notifications, and middlewares intelligently, adapting to different scenarios dynamically.

Usage: During application initialization, the pipeline is configured to create a flexible and modular processing sequence, enabling customizable handling of various requests.

#### 3.1.2 Bean Definitions
The PipelinrConfiguration class defines beans responsible for creating the primary processing pipeline. Instances of command handlers, notification handlers, and middlewares are dynamically obtained and configured, promoting a modular and adaptable design.

#### 3.2 Dependency Injection
3.2.1 Use of ObjectProvider
The use of ObjectProvider showcases intelligent dependency injection, allowing for dynamic retrieval of handlers and middlewares. This promotes adaptability by accommodating new components without modifying existing code.

#### 3.2.2 Integration with Pipelinr
The pipeline bean seamlessly integrates with the Pipelinr library, configuring the processing pipeline based on dynamically obtained instances. This integration ensures efficient processing of requests, maintaining a clean separation of concerns and fostering system maintainability and extensibility.

## 4. Controller Layer
PaymentController
Purpose
The PaymentController serves as a crucial component in our system, acting as the entry point for handling payment-related requests.

REST Endpoint Definitions
This section defines the RESTful endpoints within the PaymentController. For example, there's an endpoint for making payments (/make-payment) and retrieving payment information (/getPayments).

Interaction with Pipeline
The PaymentController interacts with the processing pipeline, utilizing the configured pipeline to handle incoming payment requests. This ensures a structured and consistent approach to processing different types of payment-related actions.

## 5. Data Access Layer
### PaymentRepository
#### Purpose
The PaymentRepository is responsible for data access related to payment information. Its purpose includes managing static data in the absence of a database and preparing for potential future database integration.

Static Repository Implementation
Currently, the repository employs a static implementation, providing mock data for account identifiers and payment information.

Future Database Considerations
The implementation hints at future considerations for integrating with a database, allowing for seamless scalability and persistence of payment data.

## 6. DTOs (Data Transfer Objects)
### Purpose of DTOs
DTOs serve as a means to transfer data between layers, encapsulating information related to payment requests and responses.

### DTO Definitions
GetPaymentsCommand: Represents a command to retrieve payment information.
PaymentRequest: Contains information required for making a payment.
PaymentResponse: Represents the response to a payment request.
PaymentResponseDto: A DTO providing a structured format for payment responses.
PaymentTypeResponse: Represents the response to a payment type request.

## 7. Enumerations
PaymentType Enumeration
Purpose
The PaymentType enumeration defines different types of payments, providing a structured approach to categorizing payment methods.

Usage in PaymentFactory
This enumeration is likely used within the PaymentFactory to determine the type of payment and guide the parsing process.

## 8. Exception Handling
Custom Exceptions
Purpose
Custom exceptions are designed to handle specific error scenarios gracefully, enhancing the system's ability to communicate issues effectively.

Types and Use Cases
These exceptions cater to various error types, ensuring clear identification and handling of issues that may arise during payment processing.

## 9. Factory Pattern Implementation
PaymentFactory
Purpose
The PaymentFactory implements the factory pattern, dynamically creating instances of payment-related components based on input.

Integration with Payment Parsers
The factory integrates with payment parsers to determine the type of payment and dynamically create the corresponding payment type response.

Handling Unknown Payment Types
In cases where the payment type is unknown or unsupported, the factory gracefully handles this scenario, providing a response indicating an unknown payment type.

## 10. Models
Payment Entity
Purpose
The Payment entity represents the core data structure for storing payment-related information.

Attributes
Attributes within the Payment entity likely include information such as payment ID, email, amount, currency, payment type, and contact details.

## 11. Parser Pattern
Purpose of Parsers
Parsers play a crucial role in interpreting and processing different types of payments. They extract relevant information from input strings.

### 11.1 PaymentParser Interface
The PaymentParser interface defines a common contract for parsing payment-related information.

### 11.2 CardParser Implementation
An implementation of the PaymentParser interface, likely focusing on parsing information from card-related payments.

### 11.3 PaymentParser Usage
Parsers are utilized in the payment processing flow, extracting details from payment requests to facilitate further processing.

## 12. Use Case Layer
### - 12.1 GetPaymentUseCase
#### - 12.1.1 Purpose
The GetPaymentUseCase encapsulates the logic for retrieving payment information, abstracting this functionality into a separate use case.

####  - 12.1.2 Interaction with PaymentRepositoryGetPaymentUseCase
This use case likely interacts with the PaymentRepository to fetch payment information.

MakePaymentUseCase
Purpose
The MakePaymentUseCase is responsible for handling the logic related to making payments.

Interaction with PaymentRepository
This use case likely interacts with the PaymentRepository to store payment-related information.

PaymentStorage Interface
Purpose
The PaymentStorage interface defines a contract for storing payment information.

Implementation in PaymentRepository
The PaymentRepository implements the PaymentStorage interface, ensuring a consistent approach to storing payment data.

## 13. Testing
Groovy Test Cases
Purpose
The Groovy test cases serve as a suite of tests to ensure the robustness and correctness of the payment processing system.

Coverage
These tests cover various scenarios, including making payments, retrieving payment information, and handling different payment types.

Use of Groovy for Test Cases
Groovy is employed as the testing language, providing a concise and expressive syntax for creating effective test cases.

This breakdown provides an overview of each section's purpose and its role within the Payment Processing System based on the information you provided.
