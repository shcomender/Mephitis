package net.VFO.servlet.matcheRecords;

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

@WebServlet("/deletPrrecords")
public class MatchRecordsDeletServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9165147794420445753L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mid = req.getParameter("mid");
		String shortname = req.getParameter("shortname");
		System.out.println(mid+" "+shortname);
		
		IMatchRecordsService matchservice = new MatchRecordsServiceImpl();
		
		try {
			boolean issuccess = matchservice.delet(mid,shortname);
			System.out.println(issuccess);
			if(issuccess) {
				req.getSession().setAttribute("modifyerror", "修改成功！");

			}else {

				req.getSession().setAttribute("modifyerror", "修改错误！");	
			}
			resp.sendRedirect(req.getContextPath()+"/driverinfo.jsp");
			
		} catch (MacthRecordsException e) {
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
