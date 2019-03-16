package cn.mldn.goods.web.ation.abs;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
//此类的功能就是处理日期，Action中接收数据过程中，自动将从jsp中接收到的字符串转换为java.util.Date类
public abstract class AbstractBaseAction {	
	@Resource
	private MessageSource messageSource;
	
	
	public void setUrlAndMsg(HttpServletRequest request,String url,String msg,Object...args) {
		request.setAttribute("msg", this.getMsg(msg, args));
		request.setAttribute("url", this.getMsg(url)); 
	}
	public void print(HttpServletResponse response, Object val){
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().println(val);
		} catch (IOException e) {
 			e.printStackTrace();
		}
	}
	public String getMsg(String key,Object...args){
		try{
			return this.messageSource.getMessage(key, args,null);
		}catch(Exception e){
			return null;
		}
	}
	
	@InitBinder	//初始化绑定设计，固化模式
	public void initBinder(WebDataBinder binder){	//在本程序里面需要针对于日期格式进行处理
		//首先建立一个可以将字符串转换为日期的工具程序类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//明确的描述此时需要注册一个日期格式的转化处理程序类
		binder.registerCustomEditor(java.util.Date.class,new CustomDateEditor(sdf,true) );
 	}
	
}
