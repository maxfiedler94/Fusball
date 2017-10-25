package classes;
/**
 * The main class, "driver". Holds all the choices for which table to access
 * and what function to use within the table.
 * @author Max, Kevin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.InputMismatchException;

public class Main extends Functions {

	public static void main(String[] args) {

		Functions team = new TeamCRUD();
		Functions fixtures = new FixturesCRUD();
		Functions league = new LeagueCRUD();
		tableInt = tableChoice();

		try {
			for (int i = 0; i < 100; i++) {
				if (tableInt == 1) {
					System.out.println(
							"Select\n1: Create a new team.\n2: Read teams.\n3: Update a team.\n4: Delete a team.\n5: Search for a team\n6: Return to main menu");
					switch (scan.nextInt()) {
					case 1:
						team.create();
						break;
					case 2:
						team.read();
						break;
					case 3:
						team.update();
						break;
					case 4:
						team.delete();
						break;
					case 5:
						team.search();
						break;
					case 6:
						tableChoice();
						break;
					}
				} else if (tableInt == 2) {
					System.out.println(
							"Select\n1: Create a new league.\n2: Read leagues.\n3: Update a league.\n4: Delete a league.\n5: Search for a league\n6: Return to main menu");
					switch (scan.nextInt()) {
					case 1:
						league.create();
						break;
					case 2:
						league.read();
						break;
					case 3:
						league.update();
						break;
					case 4:
						league.delete();
						break;
					case 5:
						league.search();
						break;
					case 6:
						tableChoice();
						break;
					}
				} else if (tableInt == 3) {
					System.out.println(
							"Select\n1: Create a new fixture.\n2: Read fixtures.\n3: Update a fixture.\n4: Delete a fixture.\n5: Search for a fixture\n6: Return to main menu");
					switch (scan.nextInt()) {
					case 1:
						fixtures.create();
						break;
					case 2:
						fixtures.read();
						break;
					case 3:
						fixtures.update();
						break;
					case 4:
						fixtures.delete();
						break;
					case 5:
						fixtures.search();
						break;
					case 6:
						tableChoice();
						break;
					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Wrong input, you are only allowed to use numbers");
		}
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void read() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

}
