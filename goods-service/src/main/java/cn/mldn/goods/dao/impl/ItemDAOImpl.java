package cn.mldn.goods.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mldn.goods.dao.IItemDAO;
import cn.mldn.goods.dao.abs.AbstractDAO;
import cn.mldn.goods.vo.Item;
@Repository	
public class ItemDAOImpl extends AbstractDAO implements IItemDAO, RowMapper<Item> {
	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item vo = new Item();
		vo.setIid(rs.getLong(1));
		vo.setTitle(rs.getString(2));
		return vo;
	}
	@Override
	public List<Item> findAll() throws Exception {
		String sql ="SELECT iid,title FROM item";
		return super.jdbcTemplate.query(sql, this);
	}
	
	@Override
	public boolean doCreate(Item vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Item vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Item findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Item> findAllSplit(Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	} 

	

}
