package net.VFO.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import net.VFO.bean.TeamPoints;
import net.VFO.dao.ITeamPointsDao;
import net.VFO.utils.C3P0Utils;

public class TeamPointsDaoImpl implements ITeamPointsDao{
	private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public List<TeamPoints> queryall(Integer page,Integer size) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "SELECT  ROW_NUMBER() OVER (ORDER BY tpoints desc) AS indexs,teampoints.* FROM teampoints LIMIT  ?,?;";
		Object[] params = {page,size};
		List<TeamPoints> res = runner.query(sql,new BeanListHandler<TeamPoints>(TeamPoints.class),params);
		System.out.println(res);
		return res;
	}
	
	public Integer count() throws SQLException{
		String sql ="select * from teampoints";
		List<TeamPoints> res = runner.query(sql,new BeanListHandler<TeamPoints>(TeamPoints.class));
		
		return res.size();
	}
}
