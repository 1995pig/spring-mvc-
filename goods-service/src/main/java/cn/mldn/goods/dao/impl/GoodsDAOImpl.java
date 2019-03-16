package cn.mldn.goods.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mldn.goods.dao.IGoodsDAO;
import cn.mldn.goods.dao.abs.AbstractDAO;
import cn.mldn.goods.vo.Goods;
@Repository
public class GoodsDAOImpl extends AbstractDAO implements IGoodsDAO,RowMapper<Goods> {

	@Override
	public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("\n\n\n\n\n\n\n\n     xxxxxxxxxxxxxxx  \n\n\n\n\n\n\n\n");

		Goods vo = new Goods();
		vo.setGid(rs.getLong(1));
		vo.setIid(rs.getLong(2));
		vo.setSid(rs.getLong(3));
		vo.setTitle(rs.getString(4));
		vo.setPrice(rs.getDouble(5));
		vo.setPhoto(rs.getString(6));
		vo.setDelflag(rs.getInt(7));
		return vo;
	}
	@Override
	public boolean doCreate(Goods vo) throws Exception {
		String sql = "INSERT INTO goods(iid,sid,title,price,photo,delflag) VALUES(?,?,?,?,?,?)"; 
		return super.jdbcTemplate.update(sql,vo.getIid(),vo.getSid(),vo.getTitle(),
				vo.getPrice(),vo.getPhoto(),vo.getDelflag())>0;
	}
	@Override
	public List<Goods> findAllByDelflag(Integer currentPage, Integer lineSize, Integer delflag) throws Exception {
		String sql = "SELECT gid,iid,sid,title,price,photo,delflag FROM goods WHERE delflag = ? limit ?,? ";
		return 	super.jdbcTemplate.query(sql, new Object[]{delflag,(currentPage-1) * lineSize,lineSize},this);

	}
	@Override
	public List<Goods> findAllByDelflag(Integer currentPage, Integer lineSize, String column, String keyWord,
			Integer delflag) throws Exception {
		String sql = "SELECT gid,iid,sid,title,price,photo,delflag From goods WHERE delflag = ? AND "+column+""
				+ " like ?  limit ?,?";
		return super.jdbcTemplate.query(sql, new Object[]{delflag,"%"+keyWord+"%",(currentPage -1 )*lineSize, lineSize},this);
		
	}
	@Override
	public Integer getAllCountByDelflag(Integer delflag) throws Exception {
		String sql = "SELECT COUNT(*) FROM goods WHERE delflag = ?";
		return  super.jdbcTemplate.queryForObject(sql, new Object[]{delflag},Integer.class);		
	}
	@Override
	public Integer getAllCountByDelflag(String column, String keyWord, Integer delflag) throws Exception {
		String sql = "SELECT COUNT(*) FROM goods WHERE delflag = ? AND "+column+" like ?";
		return super.jdbcTemplate.queryForObject(sql, new Object[]{delflag,"%"+keyWord+"%"},Integer.class);
	}  
	@Override
	public Goods findById(Long gid) throws Exception {
		String sql = "SELECT gid,iid,sid,title,price,photo,delflag FROM goods WHERE gid = ? ";
		return super.jdbcTemplate.queryForObject(sql, new Object[]{gid}, this);
	}
	@Override
	public boolean doUpdate(Goods vo) throws Exception {
		String sql = "UPDATE goods SET iid=?,sid=?,title=?,price=?,photo=? WHERE gid = ?";
		return super.jdbcTemplate.update(sql,vo.getIid(),vo.getSid(),vo.getTitle(),vo.getPrice(),
				vo.getPhoto(),vo.getGid()) > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Long> ids) throws Exception { 
		 StringBuffer buf = new StringBuffer("update goods SET delflag = ? WHERE gid IN (");
		 Iterator<Long> iter = ids.iterator();
		 while(iter.hasNext()){
			 buf.append(iter.next()).append(",");
		 }
		 buf.delete(buf.length()-1, buf.length()).append(")");
		 return super.jdbcTemplate.update(buf.toString(),new Object[]{1}) > 0;
	}

	
	@Override
	public boolean doRemove(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
	

	@Override
	public List<Goods> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findAllSplit(Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
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
