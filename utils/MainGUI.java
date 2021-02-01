package de.unidue.inf.is.utils;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Project;
import de.unidue.inf.is.domain.User;

/**
 * Servlet implementation class MainGUI
 */
@WebServlet("/view_main")
public class MainGUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainGUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
		
		try {
			
			request.setAttribute("pagetitle", "Main");
			String email = (String)request.getAttribute("sessionEmail");
			String email2 = request.getParameter("sessionEmail");
			if(email == null)
				email = email2;
			System.out.println(">MainGUI sessionEmail: " + email);
			// System.out.println("This is my email " + request.getParameter("email"));
			// System.out.println("This is my name " + request.getParameter("name"));
			// ToDo 
			// instead of user, make a query to return the users data
			User user = new User(email,"yosry","nothing");
			
			// ToDo
			// instead of openProjects, make a query to return all projects with status opened
			ArrayList<Project> openProjects = new ArrayList();
			Project project = new Project(1, "title", "des", "opened", 3.1, "email1@gmail.com", "UbuntuPre", 3, 2.1,"yosry"); 
			Project project2 = new Project(2, "title2", "des2", "opened", 3.1, "ema2il@gmail.com", "UbuntuPre2", 3, 2.1,"yos2ry"); 
			Project project3 = new Project(3, "title3", "des3", "opened", 3.1, "emai3l@gmail.com", "UbuntuPre2", 3, 2.1,"yo3sry"); 
			openProjects.add(project);
			openProjects.add(project2);
			openProjects.add(project3);
			

			// ToDo
			// instead of supportedProjects make a query to return all projects
			// created by the email request.setAttribute("email", request.getParameter("email"));
			ArrayList<Project> closedProjects = new ArrayList();
			Project project11 = new Project(1, "title", "des", "status", 3.1, "email1@gmail.com", "UbuntuPre", 3, 2.1,"Michael"); 
			Project project22 = new Project(2, "title2", "des2", "status2", 3.1, "email2@gmail.com", "UbuntuPre2", 3, 2.1,"Michael"); 
			Project project33 = new Project(3, "title3", "des3", "status3", 3.1, "email3@gmail.com", "UbuntuPre2", 3, 2.1,"Michael"); 
			closedProjects.add(project);
			closedProjects.add(project2);
			closedProjects.add(project3);

			request.setAttribute("user", user);
			request.setAttribute("sessionEmail", email);
			request.setAttribute("openProjects", openProjects);
			request.setAttribute("closedProjects", closedProjects);
			
			request.getRequestDispatcher("/view_main.ftl").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
