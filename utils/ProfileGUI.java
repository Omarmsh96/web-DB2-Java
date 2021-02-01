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
 * Servlet implementation class Profile
 */
@WebServlet("/view_profile")
public class ProfileGUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileGUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String sessionEmail;
			String email;
			
			String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
			
			if(action.equals("myProfile")){
				sessionEmail= request.getParameter("sessionEmail");
				email = sessionEmail;
			}
			else {
				sessionEmail = request.getParameter("sessionEmail");
				email = request.getParameter("email");
			}
			System.out.println(">ProfileGUI(get)> sessionEmail: " + sessionEmail);
			System.out.println(">ProfileGUI(get)> email: " + email);
			
			// ToDo 
			// instead of user, make a query to return the users data
			User user = new User("email@gmail.com","yosry","nothing");
			
			// ToDo
			// instead of createdProjects, make a query to return all projects
			// created by the email request.setAttribute("email", request.getParameter("email"));
			ArrayList<Project> createdProjects = new ArrayList();
			Project project = new Project(1, "title", "des", "status", 3.1, "email@gmail.com", "UbuntuPre", 3, 2.1,"yosry"); 
			Project project2 = new Project(2, "title2", "des2", "status2", 3.1, "email@gmail.com", "UbuntuPre2", 3, 2.1,"yosry"); 
			Project project3 = new Project(3, "title3", "des3", "status3", 3.1, "email@gmail.com", "UbuntuPre2", 3, 2.1,"yosry"); 
			createdProjects.add(project);
			createdProjects.add(project2);
			createdProjects.add(project3);
			
			int createdCount = createdProjects.size();
			
			// ToDo
			// instead of supportedProjects make a query to return all projects
			// created by the email request.setAttribute("email", request.getParameter("email"));
			ArrayList<Project> supportedProjects = new ArrayList();
			Project project11 = new Project(1, "title", "des", "status", 3.1, "email1@gmail.com", "UbuntuPre", 3, 2.1,"Michael"); 
			Project project22 = new Project(2, "title2", "des2", "status2", 3.1, "email2@gmail.com", "UbuntuPre2", 3, 2.1,"Michael"); 
			Project project33 = new Project(3, "title3", "des3", "status3", 3.1, "email3@gmail.com", "UbuntuPre2", 3, 2.1,"Michael"); 
			supportedProjects.add(project);
			supportedProjects.add(project2);
			supportedProjects.add(project3);
			
			int supportedCount = supportedProjects.size();
			
			request.setAttribute("sessionEmail", sessionEmail);
			request.setAttribute("email", email);
			
			request.setAttribute("user", user);
			request.setAttribute("createdCount", createdCount);
			request.setAttribute("supportedCount", supportedCount);
			
			request.setAttribute("createdProjects", createdProjects);
			request.setAttribute("supportedProjects", supportedProjects);
			request.setAttribute("pagetitle", "Profile View");
			request.getRequestDispatcher("/view_profile.ftl").forward(request, response);
		} catch (Exception e) {
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


