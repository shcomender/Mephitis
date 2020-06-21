package net.VFO.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.VFO.bean.TeamPoints;
import net.VFO.bean.TeamPointsPageBean;
import net.VFO.dao.ITeamPointsDao;
import net.VFO.dao.impl.TeamPointsDaoImpl;
import net.VFO.exceptions.TeamPointsException;
import net.VFO.service.ITeamPointsService;

public class TeamPointsServiceImpl implements ITeamPointsService{
	ITeamPointsDao teampointdao = new TeamPointsDaoImpl();
	
	@Override
	public TeamPointsPageBean queryall(Integer page,Integer size) throws TeamPointsException{
		// TODO Auto-generated method stub
		try {
			/*
			 * 对于page：
			 * 		前端页面是：1、2、3、4、5...
			 * 		后端数据库：(page - 1) * size
			 */
			
			TeamPointsPageBean pageBean = new TeamPointsPageBean();
			page = page < 1 ? 1 : page;
			pageBean.setPage(page);
			List<TeamPoints> teampoints =teampointdao.queryall((page - 1) * size, size);
			
			Integer total = teampointdao.count();
			pageBean.setSize(size);
			pageBean.setTotal(total);
			pageBean.setUserInfos(teampoints);
			
			// 计算总页数
			int pageCount = total / size;
			pageCount = ((total % size == 0) ? pageCount : pageCount + 1);
			pageBean.setTotalPages(pageCount);
			return pageBean;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TeamPointsException("查询失败");
		}
	}

}
