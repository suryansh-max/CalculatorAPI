package com.assingment.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
                              [ CLIENT (Postman, UI, etc.) ]
                                          |
                                          | HTTP POST
                                          v
                          --------------------------------------
                          |  CalculatorController (REST API)   |
                          |------------------------------------|
                          | - @PostMapping("/calculate")       |
                          | - @PostMapping("/calculate-chained")|
                          --------------------------------------
                                          |
                                Validates @RequestBody
                                          |
              ---------------------------------------------------
              |                   |                            |
              v                   v                            v
       Valid Input         Invalid Input JSON        Missing / Invalid Field
              |                   |                            |
              v                   v                            v
  ------------------     --------------------------     ----------------------------
  | CalculatorService|     | HttpMessageNotReadable |     | @Valid + @NotNull fails |
  | (Business Logic) |     | Exception thrown       |     | -> MethodArgumentNotValid|
  ------------------      --------------------------     ----------------------------
              |                                              |
              v                                              |
    OperationHandler executes                                 |
              |                                               |
              v                                               |
      Returns Result                                          |
              |                                               |
              v                                               |
       HTTP 200 OK <------------------------------------------
              |
              v
        JSON Response

*/

/*
                          [ EXCEPTION HANDLING (ControllerAdvice) ]

             ---------------------------------------------------------
             |                      GlobalExceptionHandler            |
             ---------------------------------------------------------
             | @ExceptionHandler(MethodArgumentNotValidException)     |
             | --> Handles validation failures (e.g. missing fields)  |
             ---------------------------------------------------------
             | @ExceptionHandler(HttpMessageNotReadableException)     |
             | --> Handles malformed JSON or type mismatch            |
             ---------------------------------------------------------
             | @ExceptionHandler(ArithmeticException)                 |
             | --> Handles / by zero, etc.                            |
             ---------------------------------------------------------
             | @ExceptionHandler(Exception)                          |
             | --> Generic fallback                                   |
             ---------------------------------------------------------

     => Each handler builds a structured error response with:
         - timestamp
         - status
         - error message
         - detailed field messages (if applicable)
         - HTTP 400 / 500 accordingly
*/
@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

}
