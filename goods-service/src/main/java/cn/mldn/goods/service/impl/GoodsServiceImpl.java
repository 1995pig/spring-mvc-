package cn.mldn.goods.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.goods.dao.IGoodsDAO;
import cn.mldn.goods.dao.IItemDAO;
import cn.mldn.goods.service.IGoodsService;
import cn.mldn.goods.service.abs.AbstractService;
import cn.mldn.goods.vo.Goods;
@Service
public class GoodsServiceImpl extends AbstractService implements IGoodsService {
	@Resource
	private IItemDAO itemDAO ;
	@Resource
	private IGoodsDAO goodsDAO;
	@Override
	public Map<String, Object> addPre() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("allItems", itemDAO.findAll());
		return map;
 	}
	@Override
	public boolean add(Goods vo) throws Exception { 
		vo.setDelflag(0);
		return goodsDAO.doCreate(vo);
	}
	@Override
	public Map<String, Object> list(Integer currentPage, Integer lineSize, String column,String keyWord )
			throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("allItems", this.itemDAO.findAll());
		if(keyWord ==null ||"".equals(keyWord) || column==null||"".equals(column)){
			map.put("allGoods", goodsDAO.findAllByDelflag(currentPage, lineSize,0));
			map.put("allRecorders", goodsDAO.getAllCountByDelflag(0)); 
		}else{
			map.put("allGoods", goodsDAO.findAllByDelflag(currentPage, lineSize, column, keyWord,0));
			map.put("allRecorders", goodsDAO.getAllCountByDelflag(column, keyWord, 0));
		}
		return map;
	}
	@Override
	public Goods editPre(Long gid) throws Exception {
		return goodsDAO.findById(gid);
	}
	@Override
	public boolean edit(Goods vo) throws Exception {
		return goodsDAO.doUpdate(vo);
	}
	@Override
	public boolean deleteBatch(Set<Long> ids) throws Exception {
		return goodsDAO.doRemoveBatch(ids);
	} 

}
