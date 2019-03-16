package cn.mldn.goods.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.goods.vo.Goods;

public interface IGoodsService {
	/**
	 * 实现商品数据添加前的信息查询操作<br>
	 * @return 包括如下内容：<br>
	 * 1、key = allItems、value=所有的一级分类
	 * @throws Exception JDBC异常
	 */
	public Map<String,Object> addPre() throws Exception;
	/**
	 * 商品的添加操作<br>
	 * @param vo 商品的vo对象<br>
	 * @return 添加成功返回true<br>
	 * @throws Exception 异常
	 */
	public boolean add(Goods vo) throws Exception;
	/**
	 * 进行商品的分页模糊查询操作
	 * @param currentPage 当前显示页
	 * @param lineSize 每页显示的行数
	 * @param keyWord 查询关键字
	 * @param column 查询关键列
	 * @return 包含如下内容
	 * 1、key=allItems、value=所有的商品分类信息<br>
	 * 2、key=allGoods、value=所有的商品信息<br>
	 * 3、key=allRecorders、value=所有的商品数量<br>
	 */
	public Map<String,Object> list(Integer currentPage,Integer lineSize,String column,String keyWord)
		throws Exception;
	/**
	 * 商品编辑前的查询操作<br>
	 * @param gid 商品id<br>
	 * @return 要编辑的商品vo对象<br>
	 * @throws Exception 异常
	 */
	public Goods editPre(Long gid) throws Exception;
	/**
	 * 进行商品编辑<br>
	 * @param vo 要修改商品内容<br>
	 * @return 修改成功返回true,失败返回false<br>
	 * @throws Exception 异常
	 */
	public boolean edit(Goods vo) throws Exception;
	/**
	 * 进行商品批量逻辑删除<br>
	 * @param ids 要删除的商品编号<br>
	 * @return 删除成功返回true<br>
	 * @throws Exception 异常<br>
	 */
	public boolean deleteBatch(Set<Long> ids) throws Exception;
}
