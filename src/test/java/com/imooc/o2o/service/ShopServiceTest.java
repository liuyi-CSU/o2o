package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testAddShop() throws FileNotFoundException {
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
		shop.setShopName("测试店铺3");
		shop.setShopDesc("mytest3");
		shop.setShopAddr("test3");
		shop.setPhone("13310524526");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("/Users/liuyi/Pictures/IMG_9898.jpg");
		InputStream is = new FileInputStream(shopImg);
//		ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
//		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
}
