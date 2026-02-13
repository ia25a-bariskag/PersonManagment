package Controller;

import java.io.IOException;
import java.util.ArrayList;
import service.*;

import Model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init() throws ServletException{
		PersonService.insert(new Person("peter", "Müller"));
		PersonService.insert(new Person("reto", "Imhasly"));
		PersonService.insert(new Person("marko", "markovic"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Person> persons = PersonService2.readAll();
		
		
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("ListPersons.jsp").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException   {
		String action = request.getParameter("action");

	    if ("insert".equals(action)) {

	        String firstname = request.getParameter("firstname");
	        String lastname = request.getParameter("lastname");

	        PersonService2.insert(new Person(firstname, lastname));

	        response.sendRedirect("CreatePerson.jsp");

	    }else if ("update".equals(action)) {
	        String uuid = request.getParameter("uuid");
	        String firstname = request.getParameter("firstname");
	        String lastname = request.getParameter("lastname");
	        String error = "";
	        String erfolgreich = "";
	        
        	PersonService2.update(firstname, lastname, uuid);
        	erfolgreich = "Person updated";
        	
        	request.setAttribute("erfolgreich", erfolgreich);
         	request.getRequestDispatcher("update.jsp").forward(request, response);	        
	    }
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uuid = request.getParameter("uuid");

	    PersonService2.delete(uuid);

	    response.setStatus(200);
	}
}