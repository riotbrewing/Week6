package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */
@Entity
public class GroupDetails {
	@Id
	@GeneratedValue
	private int id;
	private String groupName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Party party;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<CharacterCreation> listOfCharacters;
	
	public GroupDetails() {
		super();
	}

	public GroupDetails(int id, String groupName, Party party, List<CharacterCreation> listOfCharacters) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.party = party;
		this.listOfCharacters = listOfCharacters;
	}

	public GroupDetails(String groupName, Party party, List<CharacterCreation> listOfCharacters) {
		super();
		this.groupName = groupName;
		this.party = party;
		this.listOfCharacters = listOfCharacters;
	}

	public GroupDetails(String groupName, Party party) {
		super();
		this.groupName = groupName;
		this.party = party;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public List<CharacterCreation> getListOfCharacters() {
		return listOfCharacters;
	}

	public void setListOfCharacters(List<CharacterCreation> listOfCharacters) {
		this.listOfCharacters = listOfCharacters;
	}

	@Override
	public String toString() {
		return "GroupDetails [id=" + id + ", groupName=" + groupName + ", party=" + party + ", listOfCharacters="
				+ listOfCharacters + "]";
	}
	
	
	
	
}
