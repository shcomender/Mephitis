package net.VFO.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.VFO.bean.Drivers;
import net.VFO.dao.IDriversDao;
import net.VFO.dao.impl.DriversDaoImpl;
import net.VFO.exceptions.DriversException;
import net.VFO.service.IDriversService;

public class DriversServiceImpl implements IDriversService{
	private IDriversDao driversdao = new DriversDaoImpl();
	
	public boolean register(Drivers driver) throws DriversException{
		try {
			return driversdao.add(driver);
		} catch (SQLException e) {
			throw new DriversException("注册失败！");
		}
	}
	
	public Drivers dologin(String email,String password) throws DriversException{
		try {
			return driversdao.login(email,password);
		}
		catch(SQLException e){
			throw new DriversException("登陆失败");
		}
	}

	@Override
	public boolean modify(Drivers driver) throws DriversException {
		// TODO Auto-generated method stub
		try {
			return driversdao.modify(driver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DriversException("更新失败！");
		}
	}

	public List<Drivers> serarchalldriver(String tname) throws DriversException {
		// TODO Auto-generated method stub
		try {
			return driversdao.searchalldriver(tname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DriversException("查询失败！");
		}
	}

	@Override
	public boolean delet(String carno, String shortname, String firstname) throws DriversException {
		// TODO Auto-generated method stub
		try {
			return driversdao.delet(carno,shortname,firstname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DriversException("删除失败！");
		}
	}

}
