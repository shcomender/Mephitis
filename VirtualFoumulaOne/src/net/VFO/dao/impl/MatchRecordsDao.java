package net.VFO.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import net.VFO.bean.Drivers;
import net.VFO.bean.MatchRecords;
import net.VFO.dao.IMatchRecordsDao;
import net.VFO.utils.C3P0Utils;

public class MatchRecordsDao implements IMatchRecordsDao{
	private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public List<MatchRecords> querybyTeam(String team,String status) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from matchrecords where tname = ? and status =?";
		System.out.println("select * from matchrecords where team =" +team+" and status ="+status);
		Object[] params = {team,status};
		List<MatchRecords> res = runner.query( sql,new BeanListHandler<MatchRecords>(MatchRecords.class), params);
		return res;
	}
	@Override
	public boolean delet(String mid, String shortname) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM matchrecords WHERE matchid = ? AND shortname=?";
		System.out.println("DELETE FROM matchrecords WHERE matchid = "+mid+" AND shortname="+shortname);
		Object[] params = {mid,shortname};
		int count = runner.update(sql,params);
		System.out.println(count);
		return count == 1;
	}

}
