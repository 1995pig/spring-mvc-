package cn.mldn.goods.dao;

import java.util.List;

import cn.mldn.goods.vo.Goods;
import cn.mldn.util.IBaseDAO;

public interface IGoodsDAO extends IBaseDAO<Long, Goods> {

	public List<Goods> findAllByDelflag(Integer currentPage,Integer lineSize,Integer delflag) throws Exception;
	
	public List<Goods> findAllByDelflag(Integer currentPage,Integer lineSize,
			String column,String keyWord,Integer delflag) throws Exception;
	public Integer getAllCountByDelflag(Integer delflag) throws Exception;
	public Integer getAllCountByDelflag(String column,String keyWord,Integer delflag) throws Exception;
}
