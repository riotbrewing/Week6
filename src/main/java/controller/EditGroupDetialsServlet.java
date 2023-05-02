package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharacterCreation;
import model.GroupDetails;
import model.Party;

/**
 * Servlet implementation class EditGroupDetialsServlet
 */
@WebServlet("/editGroupDetialsServlet")
public class EditGroupDetialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGroupDetialsServlet() {
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
		
		
		try {
			Integer holdID = Integer.parseInt(request.getParameter("id"));
			GroupDetails update = dao.searchForDetailsByID(holdID);
			String groupName = request.getParameter("groupName");
			String partyName = request.getParameter("partyName");
			
			int numberInParty = Integer.parseInt(request.getParameter("numberInParty"));
			String characterName = request.getParameter("characterName");
			String characterClass = request.getParameter("characterClass");
			int level = 1;
			try
			{
				level = Integer.parseInt(request.getParameter("level"));
			}
			catch(Exception e)
			{
				level = 1;
			}
			String alignment = request.getParameter("alignment"); 
			
			CharacterCreation character = new CharacterCreation(characterName, characterClass, level, alignment);
			List<CharacterCreation> characterList = new ArrayList<CharacterCreation>();
			characterList.add(character);
			
			Party party = new Party(partyName, numberInParty);
			
			update.setGroupName(groupName);
			update.setParty(party);
			update.setListOfCharacters(characterList);
			
			dao.updateList(update);
			
			getServletContext().getRequestDispatcher("/viewGroupListsServlet").forward(request, response);
		}
		catch(NumberFormatException w)
		{
			getServletContext().getRequestDispatcher("/viewGroupListsServlet").forward(request, response);
		}
		
	}

}
