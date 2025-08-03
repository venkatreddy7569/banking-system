# 💳 Java Banking System

A file-based Java Banking System with a beautiful Swing GUI and PDF export functionality — no SQL or database needed!

---

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
