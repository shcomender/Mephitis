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

@WebServlet("/driver/driverRegister")
public class DriversRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2730836754555308017L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = req.getParameter("firstname");
		String secondname = req.getParameter("secondname");
		String shortname = req.getParameter("shortname");
		Integer carno = Integer.valueOf( req.getParameter("carno"));
		String email = req.getParameter("email");
		String teamcode = req.getParameter("teamcode");
		String password = req.getParameter("pw");
		
		IDriversService driverService = new DriversServiceImpl();
		
		
		Drivers driver = new Drivers(0, firstname, secondname, email, teamcode, "", "" ,carno, shortname,password);
		boolean isSuccess = false;
		try {
			isSuccess = driverService.register(driver);
		} catch (DriversException e) {
			e.printStackTrace();
		}
		
		if(isSuccess) {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}else {
//			String message = "注册失败！您的邮箱已被使用，请联系赛会进行申诉！";
//			req.getSession().setAttribute("message", message);
				resp.setContentType("text/html;charset=utf-8");
				resp.getWriter().print("<script type='text/javascript'>alert('注册失败，您的邮箱已被占用，请及时联系赛会解绑！')</script>");
				resp.getWriter().print("<script>window.location ='/VirtualFoumulaOne/register.jsp'</script>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
