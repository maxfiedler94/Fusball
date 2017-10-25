package entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Entity class for the table "fixtures".
 * Columns: fixtures_id, home_points, home_team(inner join with Teams),
 * away_points, away_team(inner join with Teams), date,
 * league(inner join with League). 
 * @author Max, Kevin
 *
 */
@Entity
@Table(name = "fixtures")
public class Fixtures implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fixtures_id")
	private int fixturesId;

	@Column(name = "home_points")
	private int homePoints;

	@Column(name = "away_points")
	private int awayPoints;

	@Column(name = "home_team")
	private int homeTeam;

	@Column(name = "away_team")
	private int awayTeam;

	@Column(name = "league")
	private int league;

	@ManyToOne
	@JoinColumn(name = "home_team", referencedColumnName = "team_id", insertable = false, updatable = false)
	Teams homeTeamJoin;

	@ManyToOne
	@JoinColumn(name = "away_team", referencedColumnName = "team_id", insertable = false, updatable = false)
	Teams awayTeamJoin;

	@ManyToOne
	@JoinColumn(name = "league", referencedColumnName = "league_id", insertable = false, updatable = false)
	League leagueJoin;

	@Column(name = "date", columnDefinition = "String")
	private String date;

	public Fixtures() {

	}

	public Fixtures(int homePoints, int awayPoints, Teams homeTeamJoin, Teams awayTeamJoin, League leagueJoin,
			String date) {
		super();
		this.homePoints = homePoints;
		this.awayPoints = awayPoints;
		this.homeTeamJoin = homeTeamJoin;
		this.awayTeamJoin = awayTeamJoin;
		this.date = date;
		this.leagueJoin = leagueJoin;
	}

	public int getFixturesId() {
		return fixturesId;
	}

	public void setFixturesId(int fixturesId) {
		this.fixturesId = fixturesId;
	}

	public int getHomePoints() {
		return homePoints;
	}

	public void setHomePoints(int homePoints) {
		this.homePoints = homePoints;
	}

	public int getAwayPoints() {
		return awayPoints;
	}

	public void setAwayPoints(int awayPoints) {
		this.awayPoints = awayPoints;
	}

	public Teams getHomeTeamJoin() {
		return homeTeamJoin;
	}

	public void setHomeTeamJoin(Teams homeTeamJoin) {
		this.homeTeamJoin = homeTeamJoin;
	}

	public Teams getAwayTeamJoin() {
		return awayTeamJoin;
	}

	public void setAwayTeamJoin(Teams awayTeamJoin) {
		this.awayTeamJoin = awayTeamJoin;
	}

	public League getLeagueJoin() {
		return leagueJoin;
	}

	public void setLeagueJoin(League leagueJoin) {
		this.leagueJoin = leagueJoin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(int homeTeam) {
		this.homeTeam = homeTeam;
	}

	public int getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(int awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getLeague() {
		return league;
	}

	public void setLeague(int league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "Fixture \n  fixturesId=" + fixturesId + "\n  Home" + homeTeamJoin + "\n  Away" + awayTeamJoin
				+ "\n  homePoints= " + homePoints + "\n  awayPoints= " + awayPoints + "\n  date= " + date;
	}

}
