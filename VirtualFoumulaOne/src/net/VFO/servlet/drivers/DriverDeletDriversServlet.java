package net.VFO.servlet.drivers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.VFO.exceptions.DriversException;
import net.VFO.exceptions.MacthRecordsException;
import net.VFO.service.IDriversService;
import net.VFO.service.IMatchRecordsService;
import net.VFO.service.impl.DriversServiceImpl;
import net.VFO.service.impl.MatchRecordsServiceImpl;


@WebServlet("/deletdriver")
public class DriverDeletDriversServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7156829725799729461L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String carno = req.getParameter("decarno");
		String shortname = req.getParameter("deshortname");
		String firstname = req.getParameter("defirstname");
		System.out.println(carno+" "+shortname+" "+firstname);
		
		IDriversService driversservice = new DriversServiceImpl();
		
		 try {
			boolean issuccess = driversservice.delet(carno,shortname,firstname);
			if(issuccess) {
				req.getSession().setAttribute("modifyerror", "修改成功！");
			}
			else {
				req.getSession().setAttribute("modifyerror", "修改失败！");
				
			}
			resp.sendRedirect(req.getContextPath()+"/driverinfo.jsp");
		} catch (DriversException e) {
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
