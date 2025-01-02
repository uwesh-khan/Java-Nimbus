<%@page import="in.dauniv.dto.MarksheetPOJO"%>
<%@page import="in.dauniv.model.UniversityImpl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Marksheet</title>
</head>
<style>

/* Style for the <h1> */
h1 {
    font-size: 2.5rem;
    color: #0056b3;
    margin-top: 20px;
    margin-bottom: 10px;
}

/* Style for the <p> */
p {
    font-size: 1.2rem;
    margin-bottom: 20px;
    color: #555;
}

/* Style for the <a> link */
a {
    display: inline-block;
    font-size: 1rem;
    color: #fff;
    background-color: #007bff;
    text-decoration: none;
    padding: 10px 20px;
    border-radius: 5px;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

/* Hover effect for the link */
a:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}

/* General styling for the body */
body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
    color: #333;
}

/* Styling the container */
.container {
    max-width: 800px;
    margin: 50px auto;
    padding: 20px;
    background-color: #ffffff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
}

/* Header styling */
header {
    text-align: center;
    padding: 10px 0;
    border-bottom: 2px solid #007bff;
}

header h1 {
    margin: 0;
    font-size: 2.5rem;
    color: #007bff;
}

/* Main section styling */
main {
    padding: 20px 0;
}

/* Section heading */
#marksheet-section h2 {
    text-align: center;
    font-size: 1.8rem;
    margin-bottom: 20px;
    color: #343a40;
}

/* Table styling */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

table thead {
    background-color: #007bff;
    color: #ffffff;
}

table th, table td {
    padding: 10px;
    text-align: center;
    border: 1px solid #ddd;
    font-size: 1rem;
}

table tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tbody tr:hover {
    background-color: #f8f9fa;
}

/* Grade-specific styling (optional) */
tbody td:nth-child(3) {
    font-weight: bold;
}

/* Responsive Design */
@media (max-width: 600px) {
    table th, table td {
        font-size: 0.9rem;
        padding: 8px;
    }

    header h1 {
        font-size: 2rem;
    }

    #marksheet-section h2 {
        font-size: 1.5rem;
    }
}
</style>
<body>
	<div class="container">
	<header>
		<h1>Student Marksheet</h1>
	</header>
		
	<main>
		 <section id="marksheet-section">
                <h2>Student Marksheet</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Subject</th>
                            <th>Marks</th>
                            <th>Grade</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% UniversityImpl un = new UniversityImpl(); 
                        	char [] grade = un.getGradeOfStudent(MarksheetPOJO.getRollNo());
                        %>
                        <tr>
                            <td>Physics</td>
                            <td><% MarksheetPOJO.getPhysics();%></td>
                            <td><% System.out.println(grade[0]); %></td>
                        </tr>
                        <tr>
                            <td>Chemistry</td>
                            <td><% MarksheetPOJO.getChemistry(); %></td>
                            <td><%System.out.println(grade[1]); %></td>
                        </tr>
                        <tr>
                            <td>Mathematics</td>
                            <td><%MarksheetPOJO.getMaths(); %></td>
                            <td><%System.out.println(grade[2]); %></td>
                        </tr>
                    </tbody>
                </table>
            </section>
            	<h1>Welcome</h1>
    			<p>Click the link below to go to the Home Page:</p>
    			<a href="HomePage.jsp">Go to Home Page</a>
    			<p>Click the link below to go to the Admin Dashboard:</p>
    			<a href="AdminDashboard.jsp">Go to Admin Page</a>
	</main>
	
	<footer>
		<p>&copy; 2024 Marksheet Management System</p>
	</footer>
	</div>
</body>
</html>