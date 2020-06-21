package net.VFO.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import net.VFO.bean.Drivers;
import net.VFO.dao.IDriversDao;
import net.VFO.utils.C3P0Utils;

public class DriversDaoImpl implements IDriversDao{
	private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
	
	public boolean add(Drivers driver) throws SQLException{
		String sql = "insert DRIVERS VALUES(0,?,?,?,'','',?,?,?,?)";
		Object[] params = {driver.getFirstname(),driver.getSecondname(),driver.getEmail(),driver.getTeamcode(),driver.getCarno(),driver.getShortname(),driver.getPassword()};
//		System.out.println("insert DRIVERS VALUES(0,"+driver.getFirstname()+","+driver.getSecondname()+","
//				+ driver.getEmail()+",'we','we',"+ driver.getTeamcode()+","+ driver.getCarno()+","+ driver.getShortname()+")");
		int count = runner.update(sql,params);
		return count == 1;
	}

	@Override
	public Drivers login(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from DRIVERS where EMAIL = ? and password =?; ";
		System.out.println("select * from DRIVERS where EMAIL ="+email+"  and assword ="+password+"; ");
		Object[] params = {email,password};
		Drivers driver = runner.query(sql,new BeanHandler<Drivers>(Drivers.class),params);
		return driver;
	}

	@Override
	public boolean modify(Drivers driver) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "update drivers set firstname=?,secondname=?,shortname=?,carno=?,password=? where id=?";
		Object[] params = {driver.getFirstname(),driver.getSecondname(),driver.getShortname(),driver.getCarno(),driver.getPassword(),driver.getId()};
		int count;
	
			count = runner.update(sql, params);
	
		return count==1;
	}

	@Override
	public List<Drivers> searchalldriver(String tname) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from drivers where Teamname = ?";
		Object[] params = {tname};
		System.out.println("selse * from drivers where Teamname = "+tname);
		List<Drivers> res = runner.query( sql,new BeanListHandler<Drivers>(Drivers.class), params);
		
		return res;
	}

	@Override
	public boolean delet(String carno, String shortname, String firstname) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from drivers where Carno = ? and Shortname = ? and Firstname=?";
		System.out.println("delete from drivers where Carno = "+carno+" and Shortname = "+shortname+" and Firstname="+firstname);
		Object[] params = {carno,shortname,firstname};
		int count = runner.update(sql,params);
		System.out.println(count);
		return count==1;
	}
}
