package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entitys.Fixtures;
import entitys.League;
import entitys.Teams;
/**
 * Abstract class that holds all the standard abstract methods,
 * the session factory, the general scanner and methods that
 * are used in more than one class.
 * 
 * @author Max, Kevin
 *
 */
public abstract class Functions {
	private SessionFactory factory;
	private Session session;
	static Scanner scan = new Scanner(System.in);

	/**
	 * Creates a new object, dependant on choice of table.
	 */
	public abstract void create();
	/**
	 * Prints out data from the table.
	 */
	public abstract void read();
	/**
	 * Update a specific row in the table
	 */
	public abstract void update();
	/**
	 * Delete a specific row in the table
	 */
	public abstract void delete();
	/**
	 * Search for row in the table
	 */
	public abstract void search();

	static int tableInt;

	/**
	 * The session factory, along with choice of table.
	 */
	public void sessionFactory() {
		
		// IF-statement choice of different table in SQL.
		if (tableInt == 1) {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teams.class)
					.buildSessionFactory();
		} else if (tableInt == 2) {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(League.class)
					.buildSessionFactory();
		} else if (tableInt == 3) {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Fixtures.class)
					.buildSessionFactory();
		} else {
			System.out.println("Not a valid table");
		}

		setFactory(factory);

		// Session
		session = factory.getCurrentSession();
		setSession(session);
	}

	/**
	 * Method to get a new session
	 */
	public void currentSession() {
		session = factory.getCurrentSession();
		setSession(session);
	}

	/**
	 * Method for choice of table to be used in main
	 * @return
	 */
	public static int tableChoice() {
		try {
			System.out.println("Select\n1:Teams.\n2:Leagues.\n3:Fixtures.");
			int tableChoice = (scan.nextInt());
			return tableChoice;
		} catch (InputMismatchException e) {
			System.out.println("Wrong input, try again");
		}
		return tableInt;

	}

	/**
	 * Transactions for create
	 * @param obj
	 */
	public void run(Object obj) {
		try {
			// Start transaction
			getSession().beginTransaction();

			// Save object
			System.out.println("Saving");
			getSession().save(obj);

			// Commit transaction
			getSession().getTransaction().commit();
			System.out.println("DONE!");
		} finally {
			getFactory().close();
		}
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
