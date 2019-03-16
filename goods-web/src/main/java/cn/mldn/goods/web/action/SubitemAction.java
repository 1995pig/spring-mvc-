package cn.mldn.goods.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mldn.goods.service.ISubitemService;
import cn.mldn.goods.web.ation.abs.AbstractBaseAction;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/pages/back/admin/subitem/*")
public class SubitemAction extends AbstractBaseAction {
	@Resource
	private ISubitemService subitemService;
	@RequestMapping("list_subitem")
	public void listSubitemByIid(Long iid,HttpServletResponse response) throws Exception{
		JSONObject obj = new JSONObject();
		obj.put("allSubitems", subitemService.listByItem(iid));
		super.print(response, obj);
	}
	
}
