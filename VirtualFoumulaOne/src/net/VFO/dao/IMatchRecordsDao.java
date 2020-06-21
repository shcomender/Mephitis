package net.VFO.dao;

import java.sql.SQLException;
import java.util.List;

import net.VFO.bean.MatchRecords;

public interface IMatchRecordsDao {
	List<MatchRecords> querybyTeam(String team,String status) throws SQLException;

	boolean delet(String mid, String shortname) throws SQLException;

	
}
