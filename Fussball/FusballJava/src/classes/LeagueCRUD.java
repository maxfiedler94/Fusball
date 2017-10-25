package classes;

import java.util.LinkedList;
import java.util.List;
import entitys.League;
/**
 * Create,read,update,delete and search for table: League.
 * 
 * @author Max,Kevin
 *
 */

public class LeagueCRUD extends Functions {

	@Override
	public void create() {
		sessionFactory();

		// Create new object
		League tempLeague = new League();
		System.out.println("Choose the name of the League");
		tempLeague.setLeagueName(scan.nextLine());

		run(tempLeague);
	}

	@Override
	public void read() {
		sessionFactory();
		try {
			// Start transaction
			getSession().beginTransaction();

			// Query league
			List<League> theLeague = new LinkedList<League>();
			theLeague = getSession().createQuery("from entitys.League").list();

			// Loop through all rows + print
			for (League tempLeague : theLeague) {
				System.out.println(tempLeague);
			}

			// Commit transaction
			getSession().getTransaction().commit();
			System.out.println("DONE!");
		} finally {
			getFactory().close();
		}
	}

	@Override
	public void update() {
		sessionFactory();
		try {
			// New session and start transaction
			currentSession();
			getSession().beginTransaction();

			// Get row based on ID
			System.out.println("Enter the ID of the row you want to update: ");
			League tempLeague = getSession().get(League.class, scan.nextInt());

			// Select new league name
			System.out.println("New league name: ");
			tempLeague.setLeagueName(scan.nextLine());

			// Commit transaction
			getSession().getTransaction().commit();
			System.out.println("DONE!");

		} finally {
			getFactory().close();
		}
	}

	@Override
	public void delete() {
		sessionFactory();
		try {
			// New session and start transaction
			currentSession();
			getSession().beginTransaction();

			// Get row based on ID
			System.out.println("Delete row based on ID: ");
			League tempLeague = getSession().get(League.class, scan.nextInt());

			// Delete row
			System.out.println("Deleting row: " + tempLeague);
			getSession().delete(tempLeague);

			// Commit transaction
			getSession().getTransaction().commit();
			System.out.println("DONE!");

		} finally {
			getFactory().close();
		}
	}

	@Override
	public void search() {
		sessionFactory();
		try {
			// Start transaction
			getSession().beginTransaction();
			System.out.println("Search for league based on name: ");
			String searchString = scan.nextLine();
			// Query league
			List<League> theLeague = new LinkedList<League>();
			theLeague = getSession()
					.createQuery("from entitys.League l where l.leagueName like '%" + searchString + "%'").list();

			// Loop through all rows + print
			for (League tempLeague : theLeague) {
				System.out.println(tempLeague);
			}

			// Commit transaction
			getSession().getTransaction().commit();
			System.out.println("DONE!");
		} finally {
			getFactory().close();
		}

	}
}
