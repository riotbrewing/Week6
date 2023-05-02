import java.util.ArrayList;
import java.util.List;

import controller.GroupDetailsHelper;
import controller.PartyHelper;
import model.CharacterCreation;
import model.GroupDetails;
import model.Party;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */
public class GroupDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Party tester = new Party("Tester Party", 9);
		//PartyHelper ph = new PartyHelper();
		//ph.addNewParty(tester);
		
		GroupDetailsHelper gdh = new GroupDetailsHelper();
		
		CharacterCreation test1 = new CharacterCreation("Xanadu", "Monk", 3, "Good");
		CharacterCreation test2 = new CharacterCreation("Ghrim-Gore", "Paladin", 2, "Chaotic-Neutral");
		
		List<CharacterCreation> groupOne = new ArrayList<CharacterCreation>();
		groupOne.add(test1);
		groupOne.add(test2);
		
		GroupDetails testGroup = new GroupDetails("Group Alpha", tester);
		testGroup.setListOfCharacters(groupOne);
		gdh.addNewGroupDetails(testGroup);
		
		List<GroupDetails> allGroups = gdh.outputGroupDetails();
		
		for(GroupDetails a : allGroups)
		{
			System.out.println(a.toString());
		}
		
	}

}
