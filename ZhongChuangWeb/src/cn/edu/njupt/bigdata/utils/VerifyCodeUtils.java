package cn.edu.njupt.bigdata.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerifyCodeUtils {

	private static BufferedImage image = null;
	
	private static Random random = new Random();
	
	public static Map getVerifyCode(int width, int heigth) {
		VerifyCodeUtils.image = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) VerifyCodeUtils.image.getGraphics();
		String verifyCode = StringUtils.getVerifyCode();
		Map map = new HashMap();
		map.put("verifyCode", verifyCode);
		//将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, heigth);
		//设置字体
		g.setFont(new Font("宋体", Font.BOLD + Font.ITALIC, heigth-10));
		//画边框。 
		g.setColor(VerifyCodeUtils.getColor());   
	    g.drawRect(0, 0, width, heigth); 
	    //随机产生干扰线，使图象中的认证码不易被其它程序探测到
	    g.setColor(Color.BLACK);   
        for (int i = 0; i < 50; i++) {   
            int x = VerifyCodeUtils.random.nextInt(width);   
            int y = VerifyCodeUtils.random.nextInt(heigth);   
            int xl = VerifyCodeUtils.random.nextInt(5);   
            int yl = VerifyCodeUtils.random.nextInt(5);  
            g.setColor(getColor());
            g.drawLine(x, y, x + xl, y + yl);   
        }   

        char c;
        for(int i = 0; i < 4; i++) {
        	c = verifyCode.charAt(i);
        	g.drawString(c+"", i*20+40, heigth-10);
        }
		map.put("image", VerifyCodeUtils.image);
		return map;
	}
	
	public static Color getColor() {
		int red = 0, green = 0, blue = 0;   
		// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。   
	    red = VerifyCodeUtils.random.nextInt(255);   
	    green = VerifyCodeUtils.random.nextInt(255);   
	    blue = VerifyCodeUtils.random.nextInt(255);  
	    return new Color(red,green,blue);
	}
}
