import java.util.List;

import controller.PartyHelper;
import model.Party;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */
public class PartyTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Party test = new Party();	
		test.setPartyName("Testy McTesterson");
		test.setNumberInParty(5);
		
		PartyHelper dao = new PartyHelper();
		dao.addNewParty(test);
		
		List<Party> allParties = dao.outputParty();
		
		for(Party p : allParties)
		{
			System.out.println(p.toString());
		}

	}

}
