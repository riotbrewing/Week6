package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharacterCreation;

/**
 * Servlet implementation class AddCharacterCreationServlet
 */
@WebServlet("/addCharacterCreationServlet")
public class AddCharacterCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCharacterCreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String characterName = request.getParameter("characterName");
		String characterClass = request.getParameter("characterClass");
		int level = Integer.parseInt(request.getParameter("level"));
		String alignment = request.getParameter("alignment");
		
		CharacterCreation cc = new CharacterCreation(characterName, characterClass, level, alignment);
		CharacterCreationHelper dao = new CharacterCreationHelper();
		dao.addNewCharacter(cc);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
