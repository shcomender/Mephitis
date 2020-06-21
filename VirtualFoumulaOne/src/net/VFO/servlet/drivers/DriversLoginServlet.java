package net.VFO.servlet.drivers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import net.VFO.service.impl.TeamsServiceImpl;

@WebServlet("/driver/doLogin")
public class DriversLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2730836754555308017L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String checkcode =  (String) req.getSession().getAttribute("checkcode");
		String code = req.getParameter("inputcode"); 
		System.out.println(checkcode);
		
		IDriversService driverservice = new DriversServiceImpl();
		ITeamsService teamservice = new TeamsServiceImpl();
		
		try {
			Drivers driver = driverservice.dologin(email,password);
			
			if(driver == null ) {
				req.getSession().setAttribute("erro", "用户名或密码错误");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			else if(!checkcode.equals(code)) {
				req.getSession().setAttribute("erro", "验证码错误！请重试！");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			else {
						try {
							//获取队伍信息
						Teams team= teamservice.query(driver.getTeamname());
						if(team!=null) {
							req.getSession().setAttribute("team", team);
							req.getSession().setAttribute("teamleder", team.getTleader());
						}
					} catch (TeamsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						String tname = driver.getTeamname();
						//获取队伍成员
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
						
						//获取未开始比赛记录
						try {
							List<MatchRecords> pr_match_records = mtservice.queryByTname(tname,"0");
							req.getSession().setAttribute("pr_match_records", pr_match_records);
							System.out.println(pr_match_records);
						} catch (MacthRecordsException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				req.getSession().setAttribute("driver", driver);
				resp.sendRedirect(req.getContextPath()+"/driverinfo.jsp");
			}
		} catch (DriversException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("error", "内部错误，请稍后再试或联系赛会！");
			req.getRequestDispatcher("/login.jsp").forward(req,resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
