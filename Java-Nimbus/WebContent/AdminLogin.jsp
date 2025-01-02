<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin-Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Admin Login</h1>
        </header>
        <main>
            <section id="admin-section">
                <h2>Welcome, Admin</h2>
                <form action="AdminLoginCtl" method="post">
                    <label for="admin-username">Username:</label>
                    <input type="text" id="admin-username" name="username" required>
                    <label for="admin-password">Password:</label>
                    <input type="password" id="admin-password" name="password" required>
                    <button type="submit">Log In</button>
                </form>
            </section>
        </main>
        <footer>
            <p>&copy; 2024 Marksheet Management System</p>
        </footer>
    </div>
</body>
</html>
