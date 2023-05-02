package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */

@Entity
@Table(name = "character_creation")
public class CharacterCreation {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "character_name")
	private String characterName;
	@Column(name = "character_class")
	private String characterClass;
	@Column(name = "character_level")
	private int level;
	@Column(name = "character_alignment")
	private String alignment;
	
	public CharacterCreation() {
		super();
	}

	public CharacterCreation(String characterName, String characterClass, int level, String alignment) {
		super();
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.level = level;
		this.alignment = alignment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	@Override
	public String toString() {
		return "ChararcterCreation [id=" + id + ", characterName=" + characterName + ", characterClass="
				+ characterClass + ", level=" + level + ", alignment=" + alignment + "]";
	}
	
	
	

}
