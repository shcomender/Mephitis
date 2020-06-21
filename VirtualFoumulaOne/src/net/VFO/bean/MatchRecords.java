package net.VFO.bean;

public class MatchRecords {
	private String matchid;
	private String matchdate;
	private String shortname;
	private String carno;
	private String matchtime;
	private String points;
	private String tname;
	
	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}
	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
	public MatchRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MatchRecords(String matchid, String matchdate, String shortname, String carno, String matchtime,
			String points, String tname) {
		super();
		this.matchid = matchid;
		this.matchdate = matchdate;
		this.shortname = shortname;
		this.carno = carno;
		this.matchtime = matchtime;
		this.points = points;
		this.tname = tname;
	}
	/**
	 * @return the matchid
	 */
	public String getMatchid() {
		return matchid;
	}
	/**
	 * @param matchid the matchid to set
	 */
	public void setMatchid(String matchid) {
		this.matchid = matchid;
	}
	/**
	 * @return the matchdate
	 */
	public String getMatchdate() {
		return matchdate;
	}
	/**
	 * @param matchdate the matchdate to set
	 */
	public void setMatchdate(String matchdate) {
		this.matchdate = matchdate;
	}
	/**
	 * @return the shortname
	 */
	public String getShortname() {
		return shortname;
	}
	/**
	 * @param shortname the shortname to set
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	/**
	 * @return the carno
	 */
	public String getCarno() {
		return carno;
	}
	/**
	 * @param carno the carno to set
	 */
	public void setCarno(String carno) {
		this.carno = carno;
	}
	/**
	 * @return the matchtime
	 */
	public String getMatchtime() {
		return matchtime;
	}
	/**
	 * @param matchtime the matchtime to set
	 */
	public void setMatchtime(String matchtime) {
		this.matchtime = matchtime;
	}
	/**
	 * @return the points
	 */
	public String getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(String points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "MatchRecords [matchid=" + matchid + ", matchdate=" + matchdate + ", shortname=" + shortname + ", carno="
				+ carno + ", matchtime=" + matchtime + ", points=" + points + ", getMatchid()=" + getMatchid()
				+ ", getMatchdate()=" + getMatchdate() + ", getShortname()=" + getShortname() + ", getCarno()="
				+ getCarno() + ", getMatchtime()=" + getMatchtime() + ", getPoints()=" + getPoints() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
