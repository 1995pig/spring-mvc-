package cn.mldn.goods.web.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.goods.service.IGoodsService;
import cn.mldn.goods.util.action.ActionSplitPageUtil;
import cn.mldn.goods.vo.Goods;
import cn.mldn.goods.vo.Item;
import cn.mldn.goods.web.ation.abs.AbstractBaseAction;
import cn.mldn.util.web.FileUtils;
@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsAction extends AbstractBaseAction{
	public static final String DB ="商品";
	@Resource
	private IGoodsService goodsService;
 	@RequestMapping("add_pre")
	public ModelAndView addpre() throws Exception{
 		System.out.println("\n\n\n\n\n\nxxxxxxxxxxxxxxxxxxxxxx\n\n\n\n\n\n\n\n");
 		
 		
 		ModelAndView mav = new ModelAndView(super.getMsg("goods.add.page"));
 		mav.addAllObjects(this.goodsService.addPre()); 	
		return mav;
	}	
	@RequestMapping("add")
	public String add(Goods vo, MultipartFile pic, HttpServletRequest request)	throws Exception {
 		FileUtils fileUtil = null;
		if (!(pic == null  || pic.isEmpty())){	//上传图片内容不为空
			fileUtil = new FileUtils(pic);
			vo.setPhoto(fileUtil.createFileName());	
		}
		if(goodsService.add(vo)){
			if (!(pic == null || pic.isEmpty())) { // 上传图片内容不为空
				fileUtil.saveFile(request,"upload/goods/",vo.getPhoto()); 
			}
		 	super.setUrlAndMsg(request,"goods.add.action","vo.add.success",DB);
  		}else{
			super.setUrlAndMsg(request,"goods.add.action","vo.add.failure",DB);
		}
		return super.getMsg("forward.page");
	}
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView(super.getMsg("goods.list.page"));
		ActionSplitPageUtil aspu = new ActionSplitPageUtil(request,
				"商品名称:title|价格:price", super.getMsg("goods.list.action"));
			Map<String,Object> map = this.goodsService.list(aspu.getCurrentPage(),
					aspu.getLineSize(), aspu.getColumn(), aspu.getKeyWord()) ;
			mav.addAllObjects(map);
			List<Item> allItems = (List<Item>) map.get("allItems") ;
			Iterator<Item> iter = allItems.iterator() ;
			Map<Long,String> itemMap = new HashMap<Long,String>() ;
			while (iter.hasNext()) {
				Item item = iter.next() ;
				itemMap.put(item.getIid(), item.getTitle()) ;
			}
			mav.addObject("allItems", itemMap) ;
		return mav;
	}
	@RequestMapping("editpre")
	public ModelAndView editPre(Long gid) throws Exception{
		ModelAndView mav = new ModelAndView(super.getMsg("goods.editpre.page"));
 		mav.addObject("goods", goodsService.editPre(gid));	//要修改的商品信息，进行回填
 		mav.addAllObjects(goodsService.addPre());	//所有的一级分类
		return mav;
	}
	@RequestMapping("edit")
	public ModelAndView edit(Goods vo,MultipartFile pic,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView(super.getMsg("forward.page"));
		FileUtils fileUtils = null;
		if(!(pic==null||pic.isEmpty())){
			fileUtils = new FileUtils(pic);
			vo.setPhoto(fileUtils.createFileName());
		}
		if(goodsService.edit(vo)){
			fileUtils.saveFile(request,"upload/goods/", vo.getPhoto());
			super.setUrlAndMsg(request, "goods.add.action", "vo.edit.success",DB);
		}else{
			super.setUrlAndMsg(request, "goods.add.action", "vo.edit.failure",DB);
		}
		return mav;
 	}
	@RequestMapping("delete")
	public String delete(String ids,HttpServletRequest request) throws Exception{
		System.out.println("\n\n\n\n\n\n\n\n\n\n0000000000000000000000\n\n\n\n\n\n\n\n");
		Set<Long> gids = new HashSet<Long>();
		String temp[] = ids.split(",");
		for(int x=0;x<temp.length;x++){
			gids.add(Long.parseLong(temp[x]));
		}
		ModelAndView mav = new ModelAndView("forward.page");
		if(goodsService.deleteBatch(gids)){
			super.setUrlAndMsg(request, "goods.list.action", "vo.delete.success",DB);
		}else{
			super.setUrlAndMsg(request, "goods.list.action", "vo.delete.failure",DB);
		} 
		return super.getMsg("forward.page");
	}
}
