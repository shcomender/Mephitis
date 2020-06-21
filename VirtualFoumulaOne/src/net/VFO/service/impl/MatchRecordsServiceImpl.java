package net.VFO.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.VFO.bean.MatchRecords;
import net.VFO.bean.Teams;
import net.VFO.dao.IMatchRecordsDao;
import net.VFO.dao.impl.MatchRecordsDao;
import net.VFO.exceptions.MacthRecordsException;
import net.VFO.service.IMatchRecordsService;

public class MatchRecordsServiceImpl implements IMatchRecordsService{

	private IMatchRecordsDao mtdao = new MatchRecordsDao();
	@Override
	public List<MatchRecords> queryByTname(String tname,String status) throws MacthRecordsException {
		// TODO Auto-generated method stub
		try {
			return mtdao.querybyTeam(tname,status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new MacthRecordsException();
		}
	}
	@Override
	public boolean delet(String mid, String shortname) throws MacthRecordsException {
		// TODO Auto-generated method stub
		try {
			return mtdao.delet(mid,shortname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new MacthRecordsException();
		}
	}

}
