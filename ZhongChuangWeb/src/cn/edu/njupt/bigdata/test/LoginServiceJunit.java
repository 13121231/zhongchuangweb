/**
 * 
 */
package cn.edu.njupt.bigdata.test;

import org.junit.Test;

import cn.edu.njupt.bigdata.bean.UserBean;
import cn.edu.njupt.bigdata.service.LoginService;

/**
 * @author Administrator
 *
 */
public class LoginServiceJunit {

	@Test
	public void testLogin() {
		LoginService login = new LoginService();
		UserBean userBean = new UserBean();
		userBean.setUserNo("1215012236");
		userBean.setPassword("123456");
		try{
			if(login.login(userBean)) {
				System.out.println("登陆成功");
			} else {
				System.out.println("密码不正确");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		userBean.setUserNo("1215012220");
		userBean.setPassword("123456");
		try{
			if(login.login(userBean)) {
				System.out.println("登陆成功");
			} else {
				System.out.println("密码不正确");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		userBean.setUserNo("1215012232");
		userBean.setPassword("654321");
		try{
			if(login.login(userBean)) {
				System.out.println("登陆成功");
			} else {
				System.out.println("密码不正确");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
