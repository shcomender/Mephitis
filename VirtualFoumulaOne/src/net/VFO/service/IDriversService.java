package net.VFO.service;

import java.util.List;

import net.VFO.bean.Drivers;
import net.VFO.exceptions.DriversException;

public interface IDriversService {
	boolean register(Drivers driver) throws DriversException;
	Drivers dologin(String email,String password) throws DriversException;
	boolean modify(Drivers driver) throws DriversException;
	List<Drivers> serarchalldriver(String tname) throws DriversException;
	boolean delet(String carno, String shortname, String firstname)throws DriversException;
}
