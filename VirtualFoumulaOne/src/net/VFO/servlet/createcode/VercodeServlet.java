package net.VFO.servlet.createcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

@WebServlet("/Vercode")
public class VercodeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2105449371453575600L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//参数为,高度，宽度，个数，干扰线个数
		ValidateCode code = new ValidateCode(98,40,5,20);
		req.getSession().setAttribute("checkcode",code.getCode());
		code.write(resp.getOutputStream());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
