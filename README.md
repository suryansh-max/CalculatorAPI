# 🧮 Calculator API - Spring Boot Application

This is a simple, extensible calculator REST API built using Spring Boot. It was developed as part of an assignment to demonstrate clean code practices, use of enums, validation, and a layered architecture.

---

## 🚀 Features
- RESTful API for performing basic arithmetic operations
- Enum-based operation handling (`ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`)
- Case-insensitive operation input (e.g., `"add"`, `"Add"`, `"ADD"` are all valid)
- Input validation with `@Valid`
- Clear separation between controller, service, and model layers

---

## 🛠 Technologies Used

- Java 17
- Spring Boot 3.x
- Maven
- Lombok (for boilerplate reduction)
- Jackson (for JSON parsing)

---

## 📨 API Usage

### Endpoint

POST http://localhost:8080/api/calculator/calculate
POST http://localhost:8080/api/calculator/calculate-chained




### Request Body

**Normal operations**

{
  "operation": "add",   // or "ADD", "Add"
  "number1": 10,
  "number2": 5
}

**Chained Operations:**

{
  "initialValue": 5,
  "steps": [
    {
      "operation": "ADD",
      "value": 3
    },
    {
      "operation": "MULTIPLY",
      "value": 2
    },
    {
      "operation": "SUBTRACT",
      "value": 4
    }
  ]
}

---

Supported Operations
- add
- subtract
- multiply
- divide

---

**Response**
Numeric

---

### Architecture:
![Image](https://github.com/user-attachments/assets/f934d398-2a93-486e-97d6-1534020a601b)



### ❗ Error Handling
![Image](https://github.com/user-attachments/assets/52b4f278-b64c-4973-ac8f-6dbf7783b298)


- Division by zero returns 400 Bad Request

- Unsupported operations return 400 Bad Request

▶️ Running the Application

**Prerequisites**
- Java 17
- Maven

		# Clone the repo
		git clone https://github.com/suryansh-max/CalculatorAPI/
		cd calculator

		# Build the project
		mvn clean install

		# Run the app
		mvn spring-boot:run
---
## 🧪 Testing
Run tests using:
mvn test

## ✍️ Author
Suryansh Patel


