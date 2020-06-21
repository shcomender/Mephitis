package net.VFO.servlet.teams;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.VFO.bean.Teams;
import net.VFO.exceptions.MacthRecordsException;
import net.VFO.exceptions.TeamsException;
import net.VFO.service.IMatchRecordsService;
import net.VFO.service.ITeamsService;
import net.VFO.service.impl.MatchRecordsServiceImpl;
import net.VFO.service.impl.TeamsServiceImpl;

@WebServlet("/modteam")
public class TeamasModifyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6376971855082676975L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tname = req.getParameter("mod_tname");
		String tleader = req.getParameter("mod_tleader");
		Integer tpoints = Integer.valueOf(req.getParameter("mod_tpoints").toString());
		String tcode = req.getParameter("mod_tcode");
		String tlogo = req.getParameter("mod_tlogo");
		
		Teams  team = new Teams(tname,tleader,tpoints,tcode,tlogo);
		
		ITeamsService teamservice = new TeamsServiceImpl();
		

			
			try {
				boolean issuccess = teamservice.modify(team);
				System.out.println(issuccess);
				if(issuccess) {
					req.getSession().setAttribute("modifyerror", "修改成功！");

				}else {

					req.getSession().setAttribute("modifyerror", "修改错误！");	
				}
				req.getSession().setAttribute("team",team);
				resp.sendRedirect(req.getContextPath()+"/driverinfo.jsp");
				
			} catch (TeamsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.getRequestDispatcher(req.getContextPath()+"/driverinfo.jsp").forward(req,resp);
			}
			
		
			
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
