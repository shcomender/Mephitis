package net.VFO.servlet.teampoints;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.VFO.bean.TeamPoints;
import net.VFO.bean.TeamPointsPageBean;
import net.VFO.exceptions.TeamPointsException;
import net.VFO.service.ITeamPointsService;
import net.VFO.service.impl.TeamPointsServiceImpl;

@WebServlet("/queryteampoints")
public class TeamPointsQueryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1658078813323974992L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 需要得到页码和数量的参数
		String pageStr = req.getParameter("page");
		String sizeStr = req.getParameter("size");
		Integer page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		Integer size = sizeStr == null ? 5 : Integer.parseInt(sizeStr);
		System.out.println(size);
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<size.intValue();i++) {
			arr.add(i);
		}
		System.out.println(arr);
				
				
		ITeamPointsService teamservice = new TeamPointsServiceImpl();
		try {
			TeamPointsPageBean res = teamservice.queryall(page,size);
			System.out.println(res);
			req.getSession().setAttribute("pointslist", res);
			req.getSession().setAttribute("arr", arr);
			req.getRequestDispatcher("/points.jsp").forward(req, resp);
		} catch (TeamPointsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
