package cn.mldn.goods.dao.abs;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAO {
	@Resource		//注入成功
	protected JdbcTemplate jdbcTemplate;
}
