package cn.mldn.util.web.interceptor;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.util.web.validator.ActionMIMEValidationUtil;
import cn.mldn.util.web.validator.ActionValidationUtil;

public class ValidationInterceptor implements HandlerInterceptor {
	private Logger log = LoggerFactory.getLogger(ValidationInterceptor.class);
	@Resource(name="messageSource")
	private MessageSource messageSource;	//进行资源读取对象的注入
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod){	//判断当前的类对象是否为HandlerMethod
			HandlerMethod handlerMethod = (HandlerMethod)handler;	//向上转型
			Object actionObject = handlerMethod.getBean();//取得要操作的Action对象
			Method method = handlerMethod.getMethod();	//取得要操作的Action中的方法
			//进行验证规则key的信息的拼凑
			String key = actionObject.getClass().getSimpleName() + "."+method.getName();
			//根据拼凑出来的key读取出一个规则的具体内容
			 
			String rule = null;
			try{
				rule = messageSource.getMessage(key,null,null);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(rule !=null){	//现在需要进行请求处理
				//现在验证规则存在则需要创建验证处理类
				ActionValidationUtil avu = new ActionValidationUtil(request,rule,messageSource);
				String errorURL = null;	
				if(avu.getErrors().size() >0){	//现在有错误信息，表示验证不通过，跳转到错误提示页面
  					request.setAttribute("errors",avu.getErrors()); //错误提示页面进行显示错误信息
 					try{
   	 					errorURL = this.messageSource.getMessage(key + ".error.page", null,null);
 					}catch(Exception e){
 						errorURL = this.messageSource.getMessage("error.page", null, null);
  					} 
 					request.getRequestDispatcher(errorURL).forward(request, response);
 					return false ;	//不应该向下处理了，应该进行错误页跳转
 				}else{	//验证基本类型没有错误，那么就要验证是否有文件上传
 					ActionMIMEValidationUtil amvu = new ActionMIMEValidationUtil(request,key,this.messageSource);
  					if(amvu.getMimeErrors().size()>0){	//上传文件有错误
   						request.setAttribute("errors", amvu.getMimeErrors());
 						try{
 							errorURL = this.messageSource.getMessage(key+".error.page",null,null);
 						}catch(Exception e){
 							errorURL = this.messageSource.getMessage("error.page", null,null);
 						}
  						request.getRequestDispatcher(errorURL).forward(request, response);
  						return false;
  					}
  				}
			}
			this.log.debug("****【ValidationInterceptor - preHandle】****  "+ rule);
		}
		//如果现在拦截返回了true,则表示请求继续发送到目的地
		//如果现在拦截返回了false,则表示请求直接断绝了
		return true;
	}
	
	
	 

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		this.log.debug("*********【ValidationIntercept-postHandle】***********" + handler.getClass());

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		this.log.debug("*********【ValidationIntercept-afterCompletion】**********" + handler.getClass());
	}

	

}
