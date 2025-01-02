<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid Credentials</title>
</head>
<style>

#error-message {
    text-align: center;
    background: #fff3f3;
    color: #d9534f;
    padding: 2rem;
    border: 1px solid #d9534f;
    margin-top: 2rem;
    border-radius: 5px;
}

#error-message h2 {
    color: #c9302c;
}

.actions button {
    background: #d9534f;
    color: #fff;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    font-size: 1rem;
    border-radius: 5px;
}

.actions button:hover {
    background: #c9302c;
}


</style>
</head>
<body>

	 <div class="container">
        <header>
            <h1>Student Login Error</h1>
        </header>

        <main>
            <section id="error-message">
                <h2>Invalid Credentials</h2>
                <p>The username or password you entered is incorrect. Please try again.</p>
                <div class="actions">
                    <a href="StudentLogin.jsp"><button>Go Back to Login</button></a>
                </div>
            </section>
        </main>

        <footer>
            <p>&copy; 2024 Marksheet Management System</p>
        </footer>

</body>
</html>
</style>
<body>

</body>
</html>