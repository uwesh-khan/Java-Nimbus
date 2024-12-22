<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Admin Dashboard</h1>
        </header>

        <main>
            <section id="admin-operations">
                <h2>Manage Students</h2>
                <div class="operations">
                    <a href="add-student.jsp"><button>Add New Student</button></a>
                    <a href="update-marks.jsp"><button>Update Marks</button></a>
                    <a href="delete-marksheet.jsp"><button>Delete Marksheet</button></a>
                    <a href="view-all-students.jsp"><button>View All Students</button></a>
                </div>
            </section>
        </main>

        <footer>
            <p>&copy; 2024 Marksheet Management System</p>
        </footer>
    </div>
</body>
</html>
