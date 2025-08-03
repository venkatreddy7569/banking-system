# 💻 Banking System with GUI & PDF Export

Welcome to the **Banking System**, a full-featured desktop application built entirely with **core Java** — no SQL, no frameworks, just pure OOP, file handling, and a stylish **Swing-based GUI**!

This project simulates real banking operations like account creation, authentication, deposits, withdrawals, and transfers, while storing all data securely using **Java object serialization**. You can even **export your transaction history as a PDF** using the integrated iText library. 🧾

Perfect for:
- 🧑‍🎓 **Final year BTech students** as a full-stack Java project
- 💼 Learning **file-based data handling**
- 🖥️ Practicing **GUI design in Swing**
- 📚 Understanding **Object-Oriented Programming (OOP)** in Java


## ✨ Features

- 👤 **Login & Register System** with PIN authentication
- 💼 **User Dashboard** to manage account
- 💰 Deposit, Withdraw, and Transfer funds
- 📜 View Transaction History
- 📄 Export History as PDF using iText
- 💾 Data stored using **file serialization** (No SQL or DB)
- 🖥️ GUI built with **Java Swing**

---

## 📁 Project Structure

```
BankingSystem/
│
├── main/
│ └── Main.java
├── gui/
│ ├── LoginFrame.java
│ ├── RegisterFrame.java
│ └── DashboardFrame.java
├── utils/
│ └── PdfGenerator.java
├── Account.java
├── AccountManager.java
├── Transaction.java
├── .gitignore
├── README.md
└── lib/
└── itext-2.1.7.jar
```
### 1. 🧱 Compile

javac -cp ".;lib/itext-2.1.7.jar" main/*.java gui/*.java utils/*.java

# 2. Run

java -cp ".;lib/itext-2.1.7.jar" main.Main
📌 Windows users: Use ; in classpath. On Linux/Mac, replace ; with :.

# 📦 Dependencies
✅ iText 2.1.7 (Download JAR)

# 🙌 Author
Venkat Reddy
Final Year BTech Student | Java & Full Stack Developer
🌐 Made with ❤️ for academic & portfolio use.

# 🪪 License

MIT License – Free to use for learning purposes.
