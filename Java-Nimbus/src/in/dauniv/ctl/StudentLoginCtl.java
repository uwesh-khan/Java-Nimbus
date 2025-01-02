package in.dauniv.ctl;

import javax.servlet.RequestDispatcher;
import java.util.ResourceBundle;
import in.dauniv.model.StudentLoginModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dauniv.dto.MarksheetPOJO;
import in.dauniv.model.AdminLoginModel;

@WebServlet("/StudentLoginCtl")
public class StudentLoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	Fetch parameter from the user from jsp file
		String name = request.getParameter("username");
		String password = request.getParameter("password");

		RequestDispatcher rd = null;
		MarksheetPOJO.setStudentName(name);
		MarksheetPOJO.setStudentPassword(password);

		//	Authenticate the student
		StudentLoginModel slm = new StudentLoginModel();
		boolean flag = slm.verify();
		if(flag) {	//	student verified
			rd = request.getRequestDispatcher("/StudentMarksheetCtl");// forward to this controller
			rd.forward(request, response);
		}
		else {
			//	forward to error page show invalid student credentials
			rd = request.getRequestDispatcher("/StudentErrorCtl");	//	ctl is an servlet
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
