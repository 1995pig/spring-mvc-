package cn.mldn.goods.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mldn.goods.dao.ISubitemDAO;
import cn.mldn.goods.dao.abs.AbstractDAO;
import cn.mldn.goods.vo.Subitem;
@Repository
public class SubitemDAOImpl extends AbstractDAO implements ISubitemDAO,RowMapper<Subitem> {
	
	@Override
	public Subitem mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subitem vo = new Subitem();
		vo.setIid(rs.getLong(1));
		vo.setSid(rs.getLong(2));
		vo.setTitle(rs.getString(3));
		return vo;
	}
	@Override
	public List<Subitem> findAllByItem(Long iid) throws Exception {
		String sql = "SELECT iid,sid,title FROM subitem WHERE iid= ?";
		return super.jdbcTemplate.query(sql, new Object[]{iid}, this);
	}

	@Override
	public boolean doCreate(Subitem vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Subitem vo) throws Exception {
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
	public Subitem findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subitem> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subitem> findAllSplit(Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subitem> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
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
