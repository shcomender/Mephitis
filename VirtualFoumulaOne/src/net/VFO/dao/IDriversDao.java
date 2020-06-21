package net.VFO.dao;

import java.sql.SQLException;
import java.util.List;

import net.VFO.bean.Drivers;

public interface IDriversDao{
	boolean add(Drivers driver) throws SQLException; 
	Drivers login(String email,String password) throws SQLException;
	boolean modify(Drivers driver) throws SQLException;
	List<Drivers>  searchalldriver(String tname) throws SQLException;
	boolean delet(String carno, String shortname, String firstname)throws SQLException;
}
