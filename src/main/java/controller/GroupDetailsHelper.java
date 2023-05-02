package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GroupDetails;


/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */
public class GroupDetailsHelper {
	
	//create the global entityManagerFactory for this project
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6Assignment");

	/*
	* @ void create an entity manager for handling entity between the program and the database
    * begin the transaction persist the input to the database, commit and then close the factory
	*/	
	public void addNewGroupDetails(GroupDetails input)
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
	public List<GroupDetails> outputGroupDetails()
	{
		EntityManager em = emfactory.createEntityManager();
		List<GroupDetails> output = em.createQuery("SELECT i FROM GroupDetails i").getResultList();
		return output;
	}
		
	public void deleteList(GroupDetails delete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GroupDetails> typedQuery = em.createQuery("select detail from GroupDetails where detail.id = :selectedId", GroupDetails.class);
		
		typedQuery.setParameter("selectedId", delete.getId());
		
		typedQuery.setMaxResults(1);
		
		GroupDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public GroupDetails searchForDetailsByID(Integer holdID)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GroupDetails found = em.find(GroupDetails.class, holdID);
		em.close();
		return found;
	}
	
	public void updateList(GroupDetails edit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(edit);
		em.getTransaction().commit();
		em.close();
	}
}
