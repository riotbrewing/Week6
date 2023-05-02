package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Party;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */
public class PartyHelper {
	
	//create the global entityManagerFactory for this project
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6Assignment");
	
	/*
	 * @ void create an entity manager for handling entity between the program and the database
	 * begin the transaction persist the input to the database, commit and then close the factory
	 */
	public void addNewParty(Party input)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(input);
		em.getTransaction().commit();
		em.close();
	}
	/*
	 *@list create an entity manager for handling entity between the program and the database
	 *query the database for all objects of Cast and store them to a List and return the List 
	 */
	@SuppressWarnings("unchecked")
	public List<Party> outputParty()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Party> output = em.createQuery("SELECT i FROM Party i").getResultList();
		return output;
	}
	
	/*
	 * @Party create an entity manager for handling entity between the program and the database
	 * use a typed query to look through the table for the passed in name limit the results to one
	 * assign the Party if found and if not create a new Party with that name close the factory and return the 
	 * result
	 */
	public Party findParty(String input)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Party> typedQuery = em.createQuery("select p from Party p where p.partyName = :selectedName", Party.class);
		typedQuery.setParameter("selectedName", input);
		typedQuery.setMaxResults(1);
		
		Party foundParty;
		try
		{
			foundParty = typedQuery.getSingleResult();
		}
		catch(NoResultException ex)
		{
			foundParty = new Party();
			foundParty.setPartyName(input);
			foundParty.setNumberInParty(1);
		}
		
		return foundParty;
	}
}
