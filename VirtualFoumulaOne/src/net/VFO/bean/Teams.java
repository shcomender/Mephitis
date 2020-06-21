package net.VFO.bean;

public class Teams {
	private String Tname;
	private String Tleader;
	private Integer Tpoints;
	private String Tcode;
	private String Tlogo;
	
	
	public Teams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teams( String tname, String tleader, Integer tpoints, String tcode, String tlogo) {
		super();
		Tname = tname;
		Tleader = tleader;
		Tpoints = tpoints;
		Tcode = tcode;
		Tlogo = tlogo;
	}
	/**
	 * @return the tname
	 */
	public String getTname() {
		return Tname;
	}
	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		Tname = tname;
	}
	/**
	 * @return the tleader
	 */
	public String getTleader() {
		return Tleader;
	}
	/**
	 * @param tleader the tleader to set
	 */
	public void setTleader(String tleader) {
		Tleader = tleader;
	}
	/**
	 * @return the tpoints
	 */
	public Integer getTpoints() {
		return Tpoints;
	}
	/**
	 * @param tpoints the tpoints to set
	 */
	public void setTpoints(Integer tpoints) {
		Tpoints = tpoints;
	}
	/**
	 * @return the tcode
	 */
	public String getTcode() {
		return Tcode;
	}
	/**
	 * @param tcode the tcode to set
	 */
	public void setTcode(String tcode) {
		Tcode = tcode;
	}
	/**
	 * @return the tlogo
	 */
	public String getTlogo() {
		return Tlogo;
	}
	/**
	 * @param tlogo the tlogo to set
	 */
	public void setTlogo(String tlogo) {
		Tlogo = tlogo;
	}
	@Override
	public String toString() {
		return "Teams [  Tname=" + Tname + ", Tleader=" + Tleader + ", Tpoints=" + Tpoints + ", Tcode="
				+ Tcode + ", Tlogo=" + Tlogo + ",  getTname()=" + getTname()
				+ ", getTleader()=" + getTleader() + ", getTpoints()=" + getTpoints() + ", getTcode()=" + getTcode()
				+ ", getTlogo()=" + getTlogo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
