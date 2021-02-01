package de.unidue.inf.is.utils;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Account;
import de.unidue.inf.is.domain.Project;
import de.unidue.inf.is.domain.User;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/edit_project")
public class EditGUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
	
		request.setAttribute("id", request.getParameter("id"));
		String sessionEmail = request.getParameter("sessionEmail");
		String id = request.getParameter("id");
		
		System.out.println(">EditGUI(get)> : id: " + request.getParameter("id"));
		System.out.println(">EditGUI(get)> : sessionEmail: " + request.getParameter("sessionEmail"));
		
		// ToDo
		// instead of project make a query to return the project 
		// with id from Integer.parseInt(request.getParameter("id"))
		Project project = new Project(Integer.parseInt(id),
				"title", "des", "status", 3.1, "email@gmail.com", "UbuntuPre", 3, 2.1,"name1"); 
		
		//ToDo
		// instead of createdProjects, make a query to return all the projects
		// made by this user(project.creator)
		ArrayList<Project> createdProjects = new ArrayList();
		Project project2 = new Project(2, "title2", "des2", "status2", 3.1, "email@gmail.com", "UbuntuPre2", 3, 2.1,"name2"); 
		Project project3 = new Project(3, "title3", "des3", "status3", 3.1, "email@gmail.com", "UbuntuPre3", 3, 2.1,"name3"); 
		createdProjects.add(project2);
		createdProjects.add(project3);
		
		request.setAttribute("sessionEmail", sessionEmail);
		request.setAttribute("id", id);
		request.setAttribute("project", project);
		request.setAttribute("createdProjects", createdProjects);
		
		request.setAttribute("pagetitle", "Edit Project");
		request.getRequestDispatcher("/edit_project.ftl").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
		
		if(action.equals("editProject")){
			
			
			
			String sessionEmail = request.getParameter("sessionEmail");
			String id = request.getParameter("id");
			
			System.out.println(">EditGUI(post)> id: " + id);
			System.out.println(">EditGUI(post)> sessionEmail: " + sessionEmail);
			
			
			String title = (String) request.getParameter("title");
			String description = (String) request.getParameter("description");
			String fundingLimit = (String) request.getParameter("fundingLimit");
			String parent = (String) request.getParameter("parent");
			String category = (String) request.getParameter("category");
			
			System.out.println(">EditGUI(post)> Title: " + title + " Description: "+ description+ " fundingLimit: "
			+ fundingLimit+ " parent: " + parent + " Category: " + category);
			
			//ToDo
			// Add in the database 
			
			
			request.setAttribute("sessionEmail", sessionEmail);
			request.setAttribute("id", id);
			request.setAttribute("pagetitle", "Main");
			request.getRequestDispatcher("/view_project").forward(request, response);
		}else {
			doGet(request,response);
		}
	}

}
