package in.dauniv.ctl;
import in.dauniv.model.AdminLoginModel;
import in.dauniv.dto.MarksheetPOJO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
@WebServlet("/AdminLoginCtl")

public class AdminLoginCtl extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	//	servlet to web browser pipeline
		RequestDispatcher rd = null;
		//	Getting data from the form attributes
		//	In case if we don't know the names of the attribute ,Enumeration<String> = request.getAttributeNames();	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//	setter getter to make attribute private
		MarksheetPOJO pojo = new MarksheetPOJO();
		pojo.setAdminName(username);
		pojo.setAdminPassword(password);
		
		// Authenticate the admin from the database!
		AdminLoginModel alm = new AdminLoginModel();
		boolean flag = alm.verify();
		if(flag) {
			rd = request.getRequestDispatcher("/AdminDashboardCtl");
			rd.forward(request, response);
		}
		else {
			//	forward to error page show invalid admin credentials
			rd = request.getRequestDispatcher("/AdminErrorCtl");	//	ctl is an servlet
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
