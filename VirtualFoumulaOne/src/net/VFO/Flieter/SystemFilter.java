package net.VFO.Flieter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 定义一个拦截器：用于检查用户是否登录，如果没有登录，自动跳转到登录页面！
 * 
 * @author Gordon
 * @date 2020年6月16日上午9:32:17
 * @version V1.6.8
 */
@WebFilter({"/driverinfo.jsp"})
public class SystemFilter implements Filter {

	@Override
	public void destroy() {
		// TODO 不需要实现
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 拦截的方法
		// 检查是否登录
		// 向下转型
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 得到session对象
		HttpSession session = request.getSession();
		// 判断是否有user_info
		Object object = session.getAttribute("driver");
		if (object == null) {
			// System.out.println("您还未登录，请登录...");
			// 重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			// System.out.println("您已登录，请继续访问...");
			// 放行
			chain.doFilter(request, resp);
			
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO 不需要实现
	}

}
