package net.VFO.bean;

public class TeamPoints {
 private String indexs;
 /**
 * @return the indexs
 */
public String getIndexs() {
	return indexs;
}
/**
 * @param indexs the indexs to set
 */
public void setIndexs(String indexs) {
	this.indexs = indexs;
}
private String tname;
 private String tpoints;
 private String tmatches;
public TeamPoints(String tname, String tpoints, String tmatches) {
	super();
	this.tname = tname;
	this.tpoints = tpoints;
	this.tmatches = tmatches;
}
public TeamPoints() {
	super();
	// TODO Auto-generated constructor stub
}
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
/**
 * @return the tpoints
 */
public String getTpoints() {
	return tpoints;
}
/**
 * @param tpoints the tpoints to set
 */
public void setTpoints(String tpoints) {
	this.tpoints = tpoints;
}
/**
 * @return the tmatches
 */
public String getTmatches() {
	return tmatches;
}
/**
 * @param tmatches the tmatches to set
 */
public void setTmatches(String tmatches) {
	this.tmatches = tmatches;
}
@Override
public String toString() {
	return "TeamPoints [indexs=" + indexs + ", tname=" + tname + ", tpoints=" + tpoints + ", tmatches=" + tmatches
			+ ", getIndexs()=" + getIndexs() + ", getTname()=" + getTname() + ", getTpoints()=" + getTpoints()
			+ ", getTmatches()=" + getTmatches() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
public TeamPoints(String indexs, String tname, String tpoints, String tmatches) {
	super();
	this.indexs = indexs;
	this.tname = tname;
	this.tpoints = tpoints;
	this.tmatches = tmatches;
}
 
 
}
