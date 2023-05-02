package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharacterCreation;

/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavServlet() {
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
		// TODO Auto-generated method stub
		CharacterCreationHelper dao = new CharacterCreationHelper();
		String action = request.getParameter("changeCharacter");
		
		String path = "/viewCharacterServlet";
		
		if(action.equals("delete"))
		{
			try
			{
				Integer holdID = Integer.parseInt(request.getParameter("id"));
				dao.delete(holdID);
			}
			catch (NumberFormatException e)
			{
				System.out.println("No input");
			}
		}
		else if(action.equals("edit"))
		{
			try
			{
				Integer holdID = Integer.parseInt(request.getParameter("id"));
				CharacterCreation edit = dao.searchById(holdID);
				request.setAttribute("changeCharacter", edit);
				path = "/edit-character.jsp";
			}
			catch(NumberFormatException e)
			{
				System.out.println("No input");
			}
		}
		else if (action.equals("add"))
		{
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
