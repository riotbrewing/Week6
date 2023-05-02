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
 * Servlet implementation class CreateNewGroupServlet
 */
@WebServlet("/createNewGroupServlet")
public class CreateNewGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CharacterCreation cc = new CharacterCreation();
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
		
		GroupDetails group = new GroupDetails(groupName, party);
		group.setListOfCharacters(characterList);
		GroupDetailsHelper gdh = new GroupDetailsHelper();
		gdh.updateList(group);
		
		getServletContext().getRequestDispatcher("/viewGroupListServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
