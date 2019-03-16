package cn.mldn.goods.web.action;

 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mldn.goods.web.ation.abs.AbstractBaseAction;

@Controller 
public class ForwardAction extends AbstractBaseAction{
	@RequestMapping("/forward")
	public String forward(){
		return super.getMsg("forward");
	} 
}
