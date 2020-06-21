package net.VFO.dao;

import java.sql.SQLException;
import java.util.List;

import net.VFO.bean.TeamPoints;

public interface ITeamPointsDao {
	List<TeamPoints> queryall(Integer page,Integer size)  throws SQLException;
	Integer count() throws SQLException;
}
