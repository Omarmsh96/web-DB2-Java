package de.unidue.inf.is.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Project;

/**
 * Servlet implementation class Donate
 */
@WebServlet("/new_project_fund")
public class DonateGUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateGUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
		
		try {
			String id = request.getParameter("id");
			String sessionEmail = request.getParameter("sessionEmail");
			
			System.out.println(">DonateGUI(get)> id: " + id);
			System.out.println(">DonateGUI(get)> sessionEmail: " + sessionEmail);
			Project project = new Project(Integer.parseInt(id), "title", "des", "status", 3.1, "email@gmail.com", null, 3, 2.1,"name");
			
			request.setAttribute("id", id);
			request.setAttribute("project", project);
			request.setAttribute("sessionEmail", sessionEmail);
			request.setAttribute("pagetitle", "Donation");
			request.getRequestDispatcher("/new_project_fund.ftl").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
		
		if(action.equals("newDonation")) 
		{
			String amount = request.getParameter("amount");
			String anonymous = request.getParameter("anonymous");
			String id = request.getParameter("id");
			String sessionEmail = request.getParameter("sessionEmail");
			
			System.out.println(">DonateGUI(post)> amount: " + amount);
			System.out.println(">DonateGUI(post)> anonymous: " + anonymous);
			System.out.println(">DonateGUI(post)> id: " + id);
			System.out.println(">DonateGUI(post)> sessionEmail: " + sessionEmail);
			
			
			request.setAttribute("id", id);
			request.setAttribute("sessionEmail", sessionEmail);
			
			request.getRequestDispatcher("/view_project").forward(request, response);
	
		}else {
			doGet(request,response);
		}
	}
}

