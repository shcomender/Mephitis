package net.VFO.servlet.drivers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.VFO.bean.Drivers;
import net.VFO.exceptions.DriversException;
import net.VFO.service.IDriversService;
import net.VFO.service.impl.DriversServiceImpl;

@WebServlet("/driver/driverModify")
public class DriversModifyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5635774793193229341L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(req.getParameter("id"));
		String firstname = req.getParameter("firstname");
		String secondname = req.getParameter("secondname");
		String shortname = req.getParameter("shortname");
		Integer carno = Integer.valueOf(req.getParameter("carno"));
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		String tname= req.getParameter("tname");
		
		IDriversService driverservice = new DriversServiceImpl();
		Drivers driver = new Drivers(id,firstname,secondname,email,"","",tname,carno,shortname,pw);
		
		boolean isSuccess = false;
		try {
			isSuccess = driverservice.modify(driver);
			if(isSuccess) {
				req.getSession().setAttribute("modifyerror", "修改成功！");
			}else {
				req.getSession().setAttribute("modifyerror", "修改错误！");	
			}
			req.getSession().setAttribute("driver", driver);
			req.getRequestDispatcher("/driverinfo.jsp").forward(req, resp);
			
			
		} catch (DriversException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("error", "内部错误，请稍后再试或联系赛会！");
			req.getRequestDispatcher(req.getContextPath()+"/driverinfo.jsp").forward(req,resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
