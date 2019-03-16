package cn.mldn.goods.dao;

import java.util.List;

import cn.mldn.goods.vo.Subitem;
import cn.mldn.util.IBaseDAO;

public interface ISubitemDAO extends IBaseDAO<Long, Subitem> {
	/**
	 * 根据栏目的编号列出所有子栏目的信息
	 * @param iid 栏目编号
	 * @return 子栏目数据
	 * @throws Exception 数据操作错误
	 */
	public List<Subitem> findAllByItem(Long iid) throws Exception;
}
