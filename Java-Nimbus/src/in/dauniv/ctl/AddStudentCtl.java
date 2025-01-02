package in.dauniv.ctl;

import in.dauniv.dto.MarksheetPOJO;
import in.dauniv.model.UniversityImpl;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentCtl")
public class AddStudentCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String rollNo = request.getParameter("rollNo");
		String physics = request.getParameter("physics");
		String chemistry = request.getParameter("chemistry");
		String maths = request.getParameter("maths");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		RequestDispatcher rd = null;
		// Validation at frontEnd 
		//	Mutating the values in mutator
		MarksheetPOJO.setStudentName(name);
		MarksheetPOJO.setStudentName(rollNo);
		MarksheetPOJO.setStudentName(physics);
		MarksheetPOJO.setStudentName(chemistry);
		MarksheetPOJO.setStudentName(maths);
		MarksheetPOJO.setStudentName(email);
		MarksheetPOJO.setStudentName(gender);
		
		//	Add data to the DATABASE!
		UniversityImpl un = new UniversityImpl();
		if(un.add()) {
			rd = request.getRequestDispatcher("StudentMarksheetCtl");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("AdminDashboardCtl");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
