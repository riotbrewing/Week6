package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharacterCreation;
import model.GroupDetails;

/**
 * Servlet implementation class ListNavServlet
 */
@WebServlet("/listNavServlet")
public class ListNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavServlet() {
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
		GroupDetailsHelper dao = new GroupDetailsHelper();
		String action = request.getParameter("doThisToList");
		
		if(action == null)
		{
			getServletContext().getRequestDispatcher("/viewGroupListsServlet").forward(request, response);
		}
		else if(action.equals("delete"))
		{
			try
			{
				Integer holdID = Integer.parseInt(request.getParameter("id"));
				GroupDetails delete = dao.searchForDetailsByID(holdID);
				dao.deleteList(delete);
			}
			catch(NumberFormatException e)
			{
				System.out.println("No input");
			}
			finally
			{
				getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			}
		}
		else if (action.equals("edit"))
		{
			try
			{
				Integer holdID = Integer.parseInt(request.getParameter("id"));
				
				GroupDetails editList = dao.searchForDetailsByID(holdID);
				
				request.setAttribute("listToEdit", editList);
				
				GroupDetailsHelper daoItems = new GroupDetailsHelper();
				
				request.setAttribute("allItem", daoItems.outputGroupDetails());
				
				if(daoItems.outputGroupDetails().isEmpty())
				{
					request.setAttribute("allItems", " ");
				}
				
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			}
			catch(NumberFormatException e)
			{
				getServletContext().getRequestDispatcher("/viewGroupListsServlet").forward(request, response);
			}
		}
		else if (action.equals("add"))
		{
			try
			{
				getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
			}
			catch(NumberFormatException e)
			{
				getServletContext().getRequestDispatcher("/viewGroupListsServlet").forward(request, response);
			}
		}
		
	}

}
