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

## Class Diagram

```plaintext
+---------------------+
|      User           |
+---------------------+
| - userId: int       |
| - name: String      |
| - email: String     |
| - password: String  |
+---------------------+
| + createAccount()   |
| + login()           |
+---------------------+

+---------------------+
|      Account        |
+---------------------+
| - accountId: int    |
| - userId: int       |
| - balance: double   |
+---------------------+
| + credit(amount)    |
| + debit(amount)     |
| + transfer(target)  |
+---------------------+

+---------------------+
|     Transaction     |
+---------------------+
| - transactionId: int|
| - accountId: int    |
| - amount: double    |
| - type: String      |
| - date: Date        |
+---------------------+
| + getTransaction()  |
| + addTransaction()  |
+---------------------+

+---------------------+
|     Database        |
+---------------------+
| - connection: Connection |
+---------------------+
| + getConnection()   |
| + executeQuery()    |
+---------------------+
