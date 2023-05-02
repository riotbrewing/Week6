

import java.util.List;

import controller.CharacterCreationHelper;
import model.CharacterCreation;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */
public class CharacterCreationTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CharacterCreation test = new CharacterCreation();
		test.setCharacterName("Grim-Gore");
		test.setCharacterClass("Warrior");
		test.setLevel(4);
		test.setAlignment("Chaotic-Neutral");
		
		CharacterCreationHelper ch = new CharacterCreationHelper();
		ch.addNewCharacter(test);
		
		List<CharacterCreation> allCharacters = ch.outputAllCharacters();
		
		for(CharacterCreation a : allCharacters)
		{
			System.out.println(a.toString());
		}
		
	}

}
