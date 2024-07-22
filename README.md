# Banking Application

## Overview
This is a simple banking application that allows users to create accounts, credit and debit money, and transfer funds between accounts.

## Features
- **Account Management**: Create and view accounts.
- **Transactions**: Credit, debit, and transfer money.

## Technologies Used
- Java
- JDBC
- Servlet & JSP
- HTML, CSS, JavaScript
- SQL/PLSQL
- Oracle
- Eclipse

## Project Structure
- **src/main/java**: Contains the main Java code for the application.
- **src/main/webapp**: Contains JSP and HTML files for the web interface.
- **src/main/resources**: Contains configuration files.

## Class Descriptions

### User
Handles user-related operations such as account creation and login.
- **Attributes**:
  - `userId`: int
  - `name`: String
  - `email`: String
  - `password`: String
- **Methods**:
  - `createAccount()`
  - `login()`

### Account
Manages account operations like crediting, debiting, and transferring money.
- **Attributes**:
  - `accountId`: int
  - `userId`: int
  - `balance`: double
- **Methods**:
  - `credit(amount)`
  - `debit(amount)`
  - `transfer(target)`

### Transaction
Logs transaction details and retrieves transaction history.
- **Attributes**:
  - `transactionId`: int
  - `accountId`: int
  - `amount`: double
  - `type`: String
  - `date`: Date
- **Methods**:
  - `getTransaction()`
  - `addTransaction()`

### Database
Manages the database connection and query execution.
- **Attributes**:
  - `connection`: Connection
- **Methods**:
  - `getConnection()`
  - `executeQuery()`


# Banking Application

## Overview
This is a simple banking application that allows users to create accounts, credit and debit money, and transfer funds between accounts.

## Features
- **Account Management**: Create and view accounts.
- **Transactions**: Credit, debit, and transfer money.

## Technologies Used
- Java
- JDBC
- Servlet & JSP
- HTML, CSS, JavaScript
- SQL/PLSQL
- Oracle
- Eclipse

## Project Structure
- **src/main/java**: Contains the main Java code for the application.
  - **DAO**: Data Access Objects for database operations.
  - **Servlets**: Servlets for handling web requests.
  - **bean**: JavaBeans for encapsulating data.
- **src/main/webapp**: Contains JSP and HTML files for the web interface.
- **src/main/resources**: Contains configuration files.

## Class Descriptions

### `DBConnection`
Manages the database connection.
- **Attributes**:
  - `con`: Connection
- **Methods**:
  - `getConnection()`: Returns the database connection.

### `UserDao`
Handles user-related database operations.
- **Attributes**:
  - `con`: Connection
- **Methods**:
  - `createAccount(UserBean userBean)`: Creates a new account.
  - `deposit(UserBean userBean)`: Deposits money into an account.
  - `withdraw(UserBean userBean)`: Withdraws money from an account.
  - `transfer(UserBean userBean, String targetAccountNo)`: Transfers money between accounts.
  - `getBalance(String accountNo)`: Retrieves the account balance.

### `UserBean`
Encapsulates user data.
- **Attributes**:
  - `accountNo`: String
  - `userName`: String
  - `password`: String
  - `amount`: float
  - `address`: String
  - `phone`: String
- **Methods**:
  - Getter and setter methods for each attribute.

### `Balance`
Servlet for checking account balance.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

### `Create`
Servlet for creating a new account.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

### `Deposit`
Servlet for depositing money.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

### `Login`
Servlet for user login.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

### `Logout`
Servlet for user logout.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

### `Register`
Servlet for user registration.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

### `Transfer`
Servlet for transferring money.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

### `Withdraw`
Servlet for withdrawing money.
- **Methods**:
  - `doPost(HttpServletRequest req, HttpServletResponse resp)`: Handles POST requests.

## Class Diagram

Below is a hand-drawn class diagram:

![Class Diagram](attachment://class_diagram.png)

This class diagram includes the key classes found in the `src/main/java` directory, displaying their attributes and main methods. If you need a more detailed class diagram or have specific preferences, please let me know.

