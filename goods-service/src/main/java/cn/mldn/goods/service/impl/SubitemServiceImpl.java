package cn.mldn.goods.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.goods.dao.ISubitemDAO;
import cn.mldn.goods.service.ISubitemService;
import cn.mldn.goods.service.abs.AbstractService;
import cn.mldn.goods.vo.Subitem;
@Service
public class SubitemServiceImpl extends AbstractService implements ISubitemService {
	@Resource
	private ISubitemDAO subitemDAO;
	@Override
	public List<Subitem> listByItem(Long iid) throws Exception {
		return subitemDAO.findAllByItem(iid);	
	}

}
