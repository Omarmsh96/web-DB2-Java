package de.unidue.inf.is.utils;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Comment;
import de.unidue.inf.is.domain.Project;
import de.unidue.inf.is.domain.Support;

/**
 * Servlet implementation class test
 */
@WebServlet("/view_project")
public class ProjectGUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectGUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// ToDo
			// instead of project make a query to return the project 
			// with id from Integer.parseInt(request.getParameter("id"))
			Project project = new Project(1, "title", "des", "status", 3.1, "email@gmail.com", "UbuntuPre", 3, 2.1,"yosry"); 
			
			String id = (String) request.getParameter("id");
			String sessionEmail = (String) request.getParameter("sessionEmail");
			
			System.out.println(">ProjectGUI(get)> id: " + id);
			System.out.println(">ProjectGUI(get)> sessionEmail: " + sessionEmail);
			System.out.println(">ProjectGUI(get)> title: " + project.getTitle());
			
			// ToDo
			// instead of name of the creator, make a query to return the name of the creator
			String creatorName="Michael";
			
			
			// ToDo
			// instead of list donators, make a query to return list of support
			ArrayList<Support> donators = new ArrayList();
			Support sup = new Support("email1",1, 123, "opened", "Michael");
			Support sup2 = new Support("email2",2, 321, "closed", "yosry");
			donators.add(sup);
			donators.add(sup2);
			
			//ToDo
			// instead of list supporter, make a query to return list of comments
			ArrayList<Comment> comments = new ArrayList();
			Timestamp t1 = new Timestamp(2020,01,18,01,01,01,01);
			Comment com1 = new Comment(4001,"Fuck DB",t1,"privat","Michael");
			Comment com2 = new Comment(4002,"Fuck SWT",t1,"public","Yosry");
			comments.add(com1);
			comments.add(com2);
			
			request.setAttribute("id", id);
			request.setAttribute("sessionEmail", sessionEmail);
			request.setAttribute("project", project);
			request.setAttribute("creatorName", creatorName);
			request.setAttribute("donators", donators);
			request.setAttribute("comments", comments);
			request.setAttribute("pagetitle", "Project View");
			request.getRequestDispatcher("/view_project.ftl").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
		
		if(action.equals("deleteProject")) {
			String sessionEmail = request.getParameter("sessionEmail");
			String id = request.getParameter("id");
			
			// TODO call the function to delete the projects
	    	request.setAttribute("sessionEmail", sessionEmail);
	    	
	    	// TODO return the user with email = sessionEmail
	    	String name="Go To Hell";
			
	    	System.out.println(">ProjectGUI(post)> sessionEmail: " + sessionEmail);
	    	request.setAttribute("sessionEmail", sessionEmail);
	    	request.setAttribute("name", name);
	    	request.setAttribute("pagetitle", "Main");
	    	request.getRequestDispatcher("/view_main").forward(request, response);
		}
		doGet(request, response);
	}

}
