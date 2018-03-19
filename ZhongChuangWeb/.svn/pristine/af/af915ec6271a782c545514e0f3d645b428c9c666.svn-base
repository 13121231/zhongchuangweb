package cn.edu.njupt.bigdata.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.bigdata.utils.ConstCodeUtils;

public class AdminAuthorityFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String userId = (String) req.getSession().getAttribute("userNo");
		if(userId != null && userId.trim().equals(ConstCodeUtils.ADMIN_NAME)) {
			chain.doFilter(req, res);
		} else {
			String redirectPath = req.getContextPath() + "/adminlogin.jsp";
			res.sendRedirect(redirectPath);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
