package net.VFO.service.impl;

import java.sql.SQLException;

import net.VFO.bean.Teams;
import net.VFO.dao.ITeamsDao;
import net.VFO.dao.impl.TeamsDaoImpl;
import net.VFO.exceptions.MacthRecordsException;
import net.VFO.exceptions.TeamsException;
import net.VFO.service.ITeamsService;

public class TeamsServiceImpl implements ITeamsService{
	private ITeamsDao teamsdao = new TeamsDaoImpl();

	@Override
	public Teams query(String teamname) throws TeamsException {
		// TODO Auto-generated method stub
		try {
			return teamsdao.query(teamname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TeamsException("查询失败");
		}
	}

	
	@Override
	public boolean modify(Teams team)
			throws  TeamsException {
		// TODO Auto-generated method stub
		try {
			return teamsdao.modify(team);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new  TeamsException("更新失败");
		}
	}
}
