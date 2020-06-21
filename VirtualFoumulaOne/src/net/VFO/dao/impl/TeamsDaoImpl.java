	package net.VFO.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import net.VFO.bean.Drivers;
import net.VFO.bean.Teams;
import net.VFO.dao.ITeamsDao;
import net.VFO.utils.C3P0Utils;

public class TeamsDaoImpl implements ITeamsDao{
	private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
	public boolean add(Teams team) throws SQLException{
		String sql = "insert into team values(0,?,?,?)";
		Object[] params = {team.getTname(),team.getTleader(),team.getTcode()};
		int count = runner.update(sql,params);
		return count == 1;
	}
	
	public Teams query(String teamname) throws SQLException{
		String sql ="select * from teams where Tname = ?;";
		Object[] params = {teamname};
		Teams team = runner.query(sql, new BeanHandler<Teams>(Teams.class),params);
		return team;
	}
	@Override
	public boolean modify(Teams team)
			throws SQLException {
		// TODO Auto-generated method stub
		String sql =" UPDATE teams SET Tname = ? ,Tleader =?,Tlogo=? WHERE Tcode = ? ";
		Object[] params = {team.getTname(),team.getTleader(),team.getTlogo(),team.getTcode()};
		int count =runner.update(sql,params);
		return count ==1;
	}
}
