package net.VFO.servlet.drivers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.VFO.bean.Drivers;
import net.VFO.bean.MatchRecords;
import net.VFO.bean.Teams;
import net.VFO.exceptions.DriversException;
import net.VFO.exceptions.MacthRecordsException;
import net.VFO.exceptions.TeamsException;
import net.VFO.service.IDriversService;
import net.VFO.service.IMatchRecordsService;
import net.VFO.service.ITeamsService;
import net.VFO.service.impl.DriversServiceImpl;
import net.VFO.service.impl.MatchRecordsServiceImpl;
import net.VFO.service.impl.TeamPointsServiceImpl;
import net.VFO.service.impl.TeamsServiceImpl;

@WebServlet("/getall")
public class DriversPageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6672226217467084335L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		Drivers driver = (Drivers)session.getAttribute("driver");
		String tname = driver.getTeamname();
		System.out.println(tname);
		
		//获取队伍成员
		IDriversService driverservice = new DriversServiceImpl();
		try {
			List<Drivers> driver_res = driverservice.serarchalldriver(tname);
			req.getSession().setAttribute("team_drivers", driver_res);
			System.out.println(driver_res);
			req.getSession().setAttribute("flag", "11");	
		} catch (DriversException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取比赛记录
		IMatchRecordsService mtservice = new MatchRecordsServiceImpl();
		try {
			List<MatchRecords> match_records = mtservice.queryByTname(tname,"1");
			req.getSession().setAttribute("match_records", match_records);
			System.out.println(match_records);
		} catch (MacthRecordsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取未进行比赛信息
		try {
			List<MatchRecords> pr_match_records = mtservice.queryByTname(tname,"0");
			req.getSession().setAttribute("pr_match_records", pr_match_records);
			System.out.println(pr_match_records);
		} catch (MacthRecordsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ITeamsService teamservice = new TeamsServiceImpl();
		try {
			//获取队伍信息
		Teams team= teamservice.query(driver.getTeamname());
			req.getSession().setAttribute("team", team);
			req.getSession().setAttribute("teamleder", team.getTleader());
		}catch (TeamsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("./driverinfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
