# Secure File Encryptor

A Java-based application that encrypts files and folders using AES, RSA, or XOR algorithms. Encrypted files are securely stored in a MySQL database along with SHA-256 file hashes for verification.

## 🔐 Features

- 🔒 Encrypt individual files or entire folders
- 🧠 Supports AES, RSA, and XOR encryption
- 📦 Stores encrypted content in MySQL
- 🧵 Multithreaded file processing for faster performance
- 🔍 SHA-256 hash generation for data integrity
- 📁 Simple CLI for selecting file/folder and encryption method
- 🛠️ Modular and extensible Java package structure

## 🖥️ Technologies Used

- Java 11+
- MySQL (JDBC)
- Java Cryptography Extension (JCE)
- Maven for project management
- IntelliJ IDEA (or any Java IDE)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/secure-file-encryptor.git
cd secure-file-encryptor


- Setup MySQL Database


Create a database and table:

```sql
CREATE DATABASE secure_file_db;

USE secure_file_db;

CREATE TABLE encrypted_files (
    id INT PRIMARY KEY AUTO_INCREMENT,
    file_name VARCHAR(255),
    type VARCHAR(50),
    hash VARCHAR(64),
    content LONGBLOB
);




- Configure Database Credentials

Create a file at: `src/main/resources/config.properties`

Add your DB credentials:

```properties
db.url=jdbc:mysql://localhost:3306/secure_file_db
db.user=your_username
db.password=your_password


