package cn.mldn.myspring.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mldn.goods.web.ation.abs.AbstractBaseAction;
@Controller // 明确的告诉容器我是一个控制器,跳转到全局的错误页
public class ErrorAction extends AbstractBaseAction {
	@RequestMapping("/error")//映射路径
	public String errors() {
		return "errors";  
	}

}
