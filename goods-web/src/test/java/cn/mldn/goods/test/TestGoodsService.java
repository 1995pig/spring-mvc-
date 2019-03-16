package cn.mldn.goods.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.goods.service.IGoodsService;
@ContextConfiguration(locations={"classpath:spring/spring-common.xml"})	//启动spring容器
@RunWith(SpringJUnit4ClassRunner.class)	//基于Spring管理的JUnit测试工具
public class TestGoodsService {
	@Resource
	private IGoodsService goodsService ;
 	@Test
	public void test()   {
		try {
			System.out.println("\n\n\n\n\n\n\n\n6666666666");
			System.out.println(goodsService.addPre());
			System.out.println("\n\n\n\n\n\n\n\n6666666666");

		} catch (Exception e) {
 			e.printStackTrace();
		}
 	}

}
