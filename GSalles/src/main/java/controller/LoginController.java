package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ClientService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ClientService cs=new ClientService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
      
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
    	  
    	  System.out.println("d5ul l post");
  		
  		String username=request.getParameter("username");
  		String password=request.getParameter("password");
  		if (cs.check(username, password)) {
  			HttpSession session=request.getSession();
  			session.setAttribute("username", username);
  			response.sendRedirect("index.jsp");
  		}else {
  			System.out.println("no user here");
  		}
      }
      
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("d5ul l post");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if (cs.check(username, password)) {
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("no user here");
		}
		
		doGet(request, response);
	}

}
