package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */

@Entity
public class Party {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "Party_Name")
	private String partyName;
	@Column(name = "Number_In_Party")
	private int numberInParty;
	
	public Party() {
		super();
	}
	
	public Party(String partyName, int numberInParty) {
		super();
		this.partyName = partyName;
		this.numberInParty = numberInParty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public int getNumberInParty() {
		return numberInParty;
	}

	public void setNumberInParty(int numberInParty) {
		this.numberInParty = numberInParty;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", partyName=" + partyName + ", numberInParty=" + numberInParty + "]";
	}
	
	
	
}
