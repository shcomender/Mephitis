package net.VFO.dao;

import java.sql.SQLException;

import net.VFO.bean.Teams;

public interface ITeamsDao {
	boolean add(Teams team) throws SQLException;
	boolean modify(Teams team)throws SQLException;
	Teams query(String teamname)throws SQLException;
}
