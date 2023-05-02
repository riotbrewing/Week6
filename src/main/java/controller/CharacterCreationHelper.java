package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CharacterCreation;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 21, 2023
 */
public class CharacterCreationHelper {
	
	//create the global entityManagerFactory for this project
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6Assignment");
	
	/*
	 * @ void create an entity manager for handling entity between the program and the database
	 * begin the transaction persist the input to the database, commit and then close the factory
	 */
	
	public void addNewCharacter(CharacterCreation input)
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
	public List<CharacterCreation> outputAllCharacters()
	{
		EntityManager em = emfactory.createEntityManager();
		List<CharacterCreation> output = em.createQuery("SELECT i FROM CharacterCreation i").getResultList();
		return output;
	}
	/*
	 * @CharacterCreation create an entity manager for handling entity between the program and the database
	 * create an object of Cast and store it with the results of the find method from the entity manager
	 * close the manager and return the object
	 */
	public CharacterCreation searchById(int input)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CharacterCreation found = em.find(CharacterCreation.class, input);
		em.close();
		return found;
	}
	/*
	 * @List create an entity manager for handling entity between the program and the database
	 * create a query to search the database for entities whose character name match the parameters
	 * set the value of the query with any values found that match the parameters
	 * assign the results of the query to a list, close the manager and return the list
	 */
 	public List<CharacterCreation> searchByName(String name)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharacterCreation> typedQuery = em.createQuery("select li from CharacterCreation li where li.characterName = :selectedCharacter", CharacterCreation.class);
		typedQuery.setParameter("selectedCharacter", name);
		List<CharacterCreation> found = typedQuery.getResultList();
		em.close();
		return found;
	}
 	/*
	 *@ void create an entity manager for handling entity between the program and the database 
	 *merge the the new values of the entity into the database, commit then close
	 *As far I could read we use the merge method on entities that already exist as 
	 */
 	public void update(CharacterCreation found) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(found);
		em.getTransaction().commit();
		em.close();
	}
 	/*
	 * @void create an entity manager for handling entity between the program and the database
	 * create an object of Cast and assign it the value of the find method searching for the primary key from the input parameter
	 * if the value of the object is not null remove the entity from the database, commit and close the factory;
	 */
 	public void delete(int input) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CharacterCreation found = em.find(CharacterCreation.class, input);
		if(found != null)
		{
			em.remove(found);
		}
		em.getTransaction().commit();
		em.close();
		
	}
	 
	 
	
}
