package net.VFO.bean;

public class Drivers {
	private Integer id;
	private String Firstname;
	private String Secondname;
	private String Email;
	private String Teamcode;
	private String Headpic;
	private String Teamname;
	private Integer Carno;
	private String Shortname;
	private String Password;
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	

	public Drivers(Integer id, String firstname, String secondname, String email, String teamcode, String headpic,
			String teamname, Integer carno, String shortname, String password) {
		super();
		this.id = id;
		Firstname = firstname;
		Secondname = secondname;
		Email = email;
		Teamcode = teamcode;
		Headpic = headpic;
		Teamname = teamname;
		Carno = carno;
		Shortname = shortname;
		Password = password;
	}

	public Drivers() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @return the carno
	 */
	public Integer getCarno() {
		return Carno;
	}

	/**
	 * @param carno the carno to set
	 */
	public void setCarno(Integer carno) {
		Carno = carno;
	}

	/**
	 * @return the shortname
	 */
	public String getShortname() {
		return Shortname;
	}

	/**
	 * @param shortname the shortname to set
	 */
	public void setShortname(String shortname) {
		Shortname = shortname;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	

	@Override
	public String toString() {
		return "Drivers [id=" + id + ", Firstname=" + Firstname + ", Secondname=" + Secondname + ", Email=" + Email
				+ ", Teamcode=" + Teamcode + ", Headpic=" + Headpic + ", Teamname=" + Teamname + ", Carno=" + Carno
				+ ", Shortname=" + Shortname + ", Password=" + Password + ", getPassword()=" + getPassword()
				+ ", getCarno()=" + getCarno() + ", getShortname()=" + getShortname() + ", getHeadpic()=" + getHeadpic()
				+ ", getTeamname()=" + getTeamname() + ", getId()=" + getId() + ", getFirstname()=" + getFirstname()
				+ ", getSecondname()=" + getSecondname() + ", getEmail()=" + getEmail() + ", getTeamcode()="
				+ getTeamcode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	/**
	 * @return the headpic
	 */
	public String getHeadpic() {
		return Headpic;
	}

	/**
	 * @param headpic the headpic to set
	 */
	public void setHeadpic(String headpic) {
		Headpic = headpic;
	}

	/**
	 * @return the teamname
	 */
	public String getTeamname() {
		return Teamname;
	}

	/**
	 * @param teamname the teamname to set
	 */
	public void setTeamname(String teamname) {
		Teamname = teamname;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return Firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	/**
	 * @return the secondname
	 */
	public String getSecondname() {
		return Secondname;
	}
	/**
	 * @param secondname the secondname to set
	 */
	public void setSecondname(String secondname) {
		Secondname = secondname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the teamcode
	 */
	public String getTeamcode() {
		return Teamcode;
	}
	/**
	 * @param teamcode the teamcode to set
	 */
	public void setTeamcode(String teamcode) {
		Teamcode = teamcode;
	}
	
	
}
