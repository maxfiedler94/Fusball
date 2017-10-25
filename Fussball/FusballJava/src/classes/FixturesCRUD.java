package classes;

import java.util.LinkedList;
import java.util.List;
import entitys.Fixtures;
/**
 * Create,read,update,delete and search for table: Fixtures.
 * 
 * @author Max,Kevin
 *
 */
public class FixturesCRUD extends Functions {

	@Override
	public void create() {
		sessionFactory();
		// Create new object
		Fixtures tempFixture = new Fixtures();
		System.out.println("Choose the points of the home team: ");
		tempFixture.setHomePoints(scan.nextInt());
		System.out.println("Choose the points of the away team: ");
		tempFixture.setAwayPoints(scan.nextInt());
		System.out.println("Choose the ID of the home team: ");
		tempFixture.setHomeTeam(scan.nextInt());
		System.out.println("Choose the ID of the away team: ");
		tempFixture.setAwayTeam(scan.nextInt());
		System.out.println("Choose the league ID of the fixture: ");
		tempFixture.setLeague(scan.nextInt());
		System.out.println("Choose the date of the fixture: ");
		tempFixture.setDate(scan.next());

		run(tempFixture);

	}

	@Override
	public void read() {
		sessionFactory();
		try {
			// Start transaction
			getSession().beginTransaction();

			// Query fixtures
			List<Fixtures> theFixture = new LinkedList<Fixtures>();
			theFixture = getSession().createQuery("from entitys.Fixtures").list();

			// Loop through all rows
			for (Fixtures tempFixture : theFixture) {
				System.out.println(tempFixture);
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
			Fixtures myFixtures = getSession().get(Fixtures.class, scan.nextInt());

			// Update row with new values
			System.out.println("New home team: ");
			myFixtures.setHomeTeam(scan.nextInt());
			System.out.println("New away team: ");
			myFixtures.setAwayTeam(scan.nextInt());
			System.out.println("New date: ");
			myFixtures.setDate(scan.next());
			System.out.println("New home points: ");
			myFixtures.setHomePoints(scan.nextInt());
			System.out.println("New away points: ");
			myFixtures.setAwayPoints(scan.nextInt());
			System.out.println("New league: ");
			myFixtures.setLeague(scan.nextInt());

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
			Fixtures myFixture = getSession().get(Fixtures.class, scan.nextInt());

			// Delete row
			System.out.println("Deleting row: " + myFixture);
			getSession().delete(myFixture);

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
			System.out.println("Search for fixture based on ID: ");
			int searchInt = scan.nextInt();

			// Query fixtures
			List<Fixtures> theFixture = new LinkedList<Fixtures>();
			theFixture = getSession()
					.createQuery("from entitys.Fixtures f where f.fixturesId like '%" + searchInt + "%'").list();

			// Loop through all rows
			for (Fixtures tempFixture : theFixture) {
				System.out.println(tempFixture);
			}

			// Commit transaction
			getSession().getTransaction().commit();
			System.out.println("DONE!");

		} finally {
			getFactory().close();
		}

	}
}