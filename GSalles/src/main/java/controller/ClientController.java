package controller;

import java.io.Console;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Client;
import beans.Salle;
import service.ClientService;
import service.SalleService;

@WebServlet(urlPatterns = {"/ClientController"})
public class ClientController extends HttpServlet {
	private ClientService cs=new ClientService();
	
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Client> clients = cs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(clients));
            }else if(request.getParameter("op").equals("delete")){
            	System.out.println("d5uul l delete");
                int id = Integer.parseInt(request.getParameter("id"));
                cs.delete(cs.findById(id));
                response.setContentType("application/json");
                List<Client> clients = cs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(clients));
                
            }else if(request.getParameter("op").equals("update")){
            	System.out.println("d5uul l update");
            	System.out.println(request.getParameter("id"));
            	System.out.println(request.getParameter("nom"));
            	System.out.println(request.getParameter("prenom"));
            	System.out.println(request.getParameter("login"));
            	System.out.println(request.getParameter("password"));
                int id = Integer.parseInt(request.getParameter("id"));
                String nom =request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String login =request.getParameter("login");
                String password =request.getParameter("password");
             //   System.out.println(id);
             //   System.out.println(code);
             //   System.out.println(capacite);
              //  System.out.println(type);
                cs.update(new Client(id,nom, prenom, login,password));
              //  Salle salle=ss.findById(id);
               // ss.update(salle);
                response.setContentType("application/json");
                List<Client> clients = cs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(clients));
                
            }
        } else {
        	System.out.println("d5ul l create");
            String nom = request.getParameter("nom");
            System.out.println(nom);
            String prenom=request.getParameter("prenom");
            String login= request.getParameter("login");
            String password= request.getParameter("password");
          //  Date dateAchat = new Date(request.getParameter("dateAchat").replace("-", "/"));
            cs.create(new Client(nom, prenom, login,password));
            System.out.println("avant json");
            response.setContentType("application/json");
            System.out.println("apres json");
            List<Client> clients = cs.findAll();
            System.out.println("avant Gson");
            Gson json = new Gson();
            response.getWriter().write(json.toJson(clients));
            System.out.println("apres Gson");
            System.out.println("5ruuuuj");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

	
	
}
