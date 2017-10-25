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
 * Entity class for the table "team", holds all the teams.
 * Columns: team_id, team_name, league(joins with League table).
 * @author Max, Kevin
 *
 */
@Entity
@Table(name = "team")
public class Teams implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int teamId;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "league")
	private int league;

	@ManyToOne
	@JoinColumn(name = "league", referencedColumnName = "league_id", insertable = false, updatable = false)
	League leagueJoin;

	public Teams() {

	}

	public Teams(String teamName, League leagueJoin) {
		super();
		this.teamName = teamName;
		this.leagueJoin = leagueJoin;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public League getLeagueJoin() {
		return leagueJoin;
	}

	public void setLeagueJoin(League leagueJoin) {
		this.leagueJoin = leagueJoin;
	}

	public int getLeague() {
		return league;
	}

	public void setLeague(int league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "Teams \n  teamId=" + teamId + "  teamName=" + teamName + "\n  " + leagueJoin;
	}

}
