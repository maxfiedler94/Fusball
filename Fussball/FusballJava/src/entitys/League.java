package entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity class for the table "league", holds all the league.
 * Columns: league_id, league_name.
 * @author Max, Kevin
 *
 */
@Entity
@Table(name = "league")
public class League implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "league_id")
	private int leagueId;

	@Column(name = "league_name")
	private String leagueName;

	public League() {

	}

	public League(String leagueName) {
		super();
		this.leagueName = leagueName;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	@Override
	public String toString() {
		return "League \n  leagueId=" + leagueId + " leagueName=" + leagueName;
	}

}
