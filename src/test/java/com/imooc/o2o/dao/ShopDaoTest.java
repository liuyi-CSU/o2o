package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	@Ignore
	public void testInsertShop() throws Exception {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory sc = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1L);
		sc.setShopCategoryId(1L);
		shop.setOwnerId(1L);
		shop.setArea(area);
		shop.setShopCategory(sc);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testUpdateShop() throws Exception {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setCreateTime(new Date());
		shop.setAdvice("审核中");
		shop.setLastEditTime(new Date());
		
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}
