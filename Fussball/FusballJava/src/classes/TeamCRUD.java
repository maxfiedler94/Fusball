package classes;

import java.util.LinkedList;
import java.util.List;
import entitys.Teams;
/**
 * Create,read,update,delete and search for table: Teams.
 * 
 * @author Max,Kevin
 *
 */
public class TeamCRUD extends Functions {

	@Override
	public void create() {
		sessionFactory();

		// Create new object
		Teams tempTeam = new Teams();
		System.out.println("Choose the name of the team");
		tempTeam.setTeamName(scan.nextLine());
		System.out.println("Select the league of the team");
		tempTeam.setLeague(scan.nextInt());

		run(tempTeam);

	}

	@Override
	public void read() {
		sessionFactory();
		try {
			// Start transaction
			getSession().beginTransaction();

			// Query rows
			List<Teams> theTeams = new LinkedList<Teams>();
			theTeams = getSession().createQuery("from entitys.Teams").getResultList();

			// Loop through all rows + print them out
			for (Teams tempTeam : theTeams) {
				System.out.println(tempTeam);
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
			Teams tempTeam = getSession().get(Teams.class, scan.nextInt());

			// Set the new team name and league
			System.out.println("New team name: ");
			tempTeam.setTeamName(scan.nextLine());
			System.out.println("New league ID : ");
			tempTeam.setLeague(scan.nextInt());

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
			Teams tempTeam = getSession().get(Teams.class, scan.nextInt());

			// Delete row based on ID
			System.out.println("Deleting row: " + tempTeam);
			getSession().delete(tempTeam);

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
			System.out.println("Search for team based on name");
			String searchString = scan.nextLine();

			// Query rows
			List<Teams> theTeams = new LinkedList<Teams>();
			theTeams = getSession().createQuery("from entitys.Teams t where t.teamName like '%" + searchString + "%'")
					.getResultList();
			
			// Loop through all rows + print them out
			for (Teams tempTeam : theTeams) {
				System.out.println(tempTeam);
			}
			// Commit transaction
			getSession().getTransaction().commit();
			System.out.println("DONE!");
		} finally {
			getFactory().close();
		}

	}

}
