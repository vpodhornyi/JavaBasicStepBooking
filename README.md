# JavaBasicStepBooking

A simple Java console application that simulates an airline ticket booking system. The project supports two user roles — **Admin** and **Client** — and allows users to book and manage flight tickets through a text-based interface.

## 🚀 Features

- **Admin capabilities:**
    - name = root, password = root
    - Generate a flight schedule (database).
    - View all users.
    - Create and delete client accounts.
    - Book or cancel flights for any user.

- **Client capabilities:**
    - NAME IS UNIQ
    - View available flights.
    - Book or cancel flights for themselves.

## 🏗 Architecture

The project follows the **Model-View-Controller (MVC)** pattern:

- **Model** – Handles business logic and data structures (users, flights, tickets).
- **View** – Manages console input/output.
- **Controller** – Manages interactions between users and the system logic.

## 💾 Data Persistence

- The project uses **file-based storage** to persist user and flight data.
- Data is saved in *.dat files, simulating a lightweight database.

## 📋 Logging

- The application includes **logging functionality to text file** to track actions and system events.
- Log messages help with debugging and monitoring application behavior.

## 📂 Project Structure
```plaintext
JavaBasicStepBooking/
├── src/
│ ├── Main.java
│ ├── controllers/
│ ├── dao/
│ ├── exceptions/
│ ├── loger/
│ ├── models/
│ ├── views/
│ └── utils/
├── .gitignore
└── README.md
```

## 🛠 Requirements

- Java Development Kit (JDK) version 17 or higher
- Terminal or command-line interface

## ⚙️ How to Run

1. **Clone the repository:**

```bash
git clone https://github.com/vpodhornyi/JavaBasicStepBooking.git
cd JavaBasicStepBooking/src
```
2 **Compile the source files:**

```bash
javac *.java
```
3 **Run the application:**

```bash
java Main
```