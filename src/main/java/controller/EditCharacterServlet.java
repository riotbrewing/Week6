package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharacterCreation;

/**
 * Servlet implementation class EditCharacterServlet
 */
@WebServlet("/editCharacterServlet")
public class EditCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCharacterServlet() {
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
		
		String characterName = request.getParameter("characterName");
		String characterClass = request.getParameter("characterClass");
		int level = Integer.parseInt(request.getParameter("level"));
		String alignment = request.getParameter("alignment");
		System.out.println(level);
		Integer holdID = Integer.parseInt(request.getParameter("id"));
		
		CharacterCreation cc = dao.searchById(holdID);
		
		cc.setCharacterName(characterName);
		cc.setCharacterClass(characterClass);
		cc.setLevel(level);
		cc.setAlignment(alignment);
		
		dao.update(cc);
		getServletContext().getRequestDispatcher("/viewCharacterServlet").forward(request, response);
	}

}
