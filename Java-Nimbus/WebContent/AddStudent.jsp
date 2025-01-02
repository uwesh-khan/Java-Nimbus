<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input, select, textarea {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Add Student</h1>

    <form action="AddStudentCtl" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="rollNo">Roll Number:</label>
        <input type="number" id="rollNo" name="rollNo" required>

        <label for="physics">Physics:</label>
        <input type="number" step="0.01" id="physics" name="physics" required>
        
        <label for="chemistry">Chemistry:</label>
        <input type="number" step="0.01" id="chemistry" name="chemistry" required>

        <label for="maths">Maths:</label>
        <input type="number" step="0.01" id="maths" name="maths" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z]+.[a-zA-Z]{2,}$">
<% //  To enhance security Regex for ensuring the input matches to the specified string %>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="">Select Gender</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>

        <button type="submit">Add Student</button>
    </form>
</body>
</html>
