package cn.mldn.goods.service;

import java.util.List;

import cn.mldn.goods.vo.Subitem;

public interface ISubitemService {
	/**
	 * 根据一级分类找出所有的二级分类项目<br>
	 * @param iid 一级分类id编号<br>
	 * @return 返回要查找的一级分类下所有二级分类<br>
	 * @throws Exception 异常
	 */
	public List<Subitem> listByItem(Long iid) throws Exception;
}
