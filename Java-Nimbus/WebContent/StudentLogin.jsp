<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Student Login</h1>
        </header>
        <main>
            <section id="student-section">
                <h2>Welcome, Student</h2>
                <form action="/student-dashboard" method="post">
                    <label for="student-id">Student ID:</label>
                    <input type="text" id="student-id" name="student_id" required>
                    <label for="student-password">Password:</label>
                    <input type="password" id="student-password" name="password" required>
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
