# 🏷️ Auction Web Application – Bid & Win Antiques

An interactive online auction platform built using **Java Servlets**, **JSP**, **HTML/CSS**, and **MySQL** that allows users to register, add antique products, place bids, and view their bids in real time. Perfect for learning how real e-commerce bidding systems work!
No admin page here, cause buyers and sellers are present here.
---

## 🚀 Features

- 👤 **User Registration & Login**
- 🛒 **Add and Manage Auction Products**
- 🏆 **Bid on Available Antiques**
- 📦 **View Products and Your Bids**
- 🧾 **Bill generation after winning**
- 🧠 **Frontend using HTML, CSS, Bootstrap & jQuery**
- ☕ **Backend powered by JSP and Servlets**
- 🗄️ **MySQL for Data Persistence**

---

## 🖼️ Interface Preview

> 🎯 Simple UI with categories like:  
> - Art  
> - Collectibles  
> - Antiques  
>  
> 🧾 User Dashboard includes:
> - My Products  
> - My Bids  
> - My Cart  
> - Billing Page  

Add your antique item → it appears in the marketplace → others can view and bid.

---

## 🛠️ Technologies Used

| Frontend                 | Backend            | Database     | Build Tool               |
|--------------------------|--------------------|--------------|--------------------------|
| HTML, CSS, JS, Bootstrap | Java Servlet & JSP | MySQL        | NetBeans (optional: Ant) |

---

## 🗄️ MySQL Database Setup

You must create a MySQL database with the following structure:

### 📌 Database Name: `auction_db`

### 📋 Tables & Structure:

#### `users`
| Column Name | Type           | Extra                       |
|-------------|----------------|-----------------------------|
| `id`        | INT (11)       | PRIMARY KEY, AUTO_INCREMENT |
| `name`      | VARCHAR(50)    |                             |
| `email`     | VARCHAR(100)   |                             |
| `password`  | VARCHAR(50)    |                             |
| `created_at`| TIMESTAMP      | DEFAULT CURRENT_TIMESTAMP   |

#### `products`
| Column Name | Type           | Description                 |
|-------------|----------------|--------------------------   |
| `id`        | INT (11)       | PRIMARY KEY, AUTO_INCREMENT |
| `name`      | VARCHAR(100)   | Product name                |
| `description`| TEXT          | Description of the product  |
| `price`     | DOUBLE         | Starting price              |
| `image`     | VARCHAR(255)   | Path to product image       |
| `user_id`   | INT (11)       | Foreign key from users      |

#### `bids`
| Column Name | Type         | Description                   |
|-------------|--------------|-------------------------------|
| `id`        | INT          | PRIMARY KEY, AUTO_INCREMENT   |
| `user_id`   | INT          | Foreign key from users        |
| `product_id`| INT          | Foreign key from products     |
| `bid_price` | DOUBLE       | Bid amount                    |
| `bid_time`  | TIMESTAMP    | DEFAULT CURRENT_TIMESTAMP     |

> ⚠️ Modify table and field names.

---

## ⚙️ How to Run the Project

> 🎯 **In Action_\src\java\com\tech\dao (ProductDAO.java & BidDAO.java)**
> 🎯 **In Action_\src\java\com\tech\helper (ConnectionProvider.java)**
> 🎯 **In Action_\src\java\com\tech\servelet (Login_Servelet.java)**

`conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product","your_database_username","pasword");`

> 🎯 **And In RegistrationServelet.java**

`// Database connectivity details`
`String url = "jdbc:mysql://localhost:3306/on_product"; // Update with your database URL`
`String dbUser = "database_username"; // Update with your database username`
`String dbPassword = "password"; // Update with your database password`


- ### 🧾 Here add your Database's `username` and `password`

---

## ⚙️ How to Run the Project

### 🧑‍💻 Locally with NetBeans

1. **Open NetBeans**
2. Click on **File → Open Project**
3. Navigate to the folder and open the `Action_` project
4. Set your MySQL connection in the Java code (DB URL, username, password)
5. Clean and Build the project
6. Run it on Apache Tomcat or any local servlet container

---

## 🧭 How to Use the Website After Running

1. 🌐 Open the website in your browser (`localhost:8080/...`)
2. 📝 **Create a new account** (sign up)
3. 🔐 **Log in** using your registered credentials
4. 🛍️ Go to **"My Products"** section in the dashboard
5. ➕ **Add a new product** with all required details:
    - Product name
    - Description
    - Image
    - Price
6. 📤 Submit — it will now appear on the **main home page** under the relevant category.
7. 🧐 Browse other items and place bids if available
8. 🧾 Visit **"My Bids"** to track your placed bids
9. 🛒 Once you win, proceed to **"Bill Page"** to generate your final billing

---

## 📁 Project Folder Structure

```plaintext
Action_/
│
├── src/                    # Java source code (Servlets)
├── web/                    # Frontend HTML, CSS, JSP files
│   ├── css/
│   ├── img/
│   └── JSPs
├── nbproject/              # NetBeans project files
├── .gitignore              # Files to ignore in version control
├── README.md               # You're reading it :)
