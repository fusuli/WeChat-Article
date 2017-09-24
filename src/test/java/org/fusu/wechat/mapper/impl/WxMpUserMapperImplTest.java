package org.fusu.wechat.mapper.impl;

import org.junit.Assert;
import org.junit.Test;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class WxMpUserMapperImplTest {

	@Test
	public void testInsertWxMpUser() {

		WxMpUser userWxInfo = new WxMpUser();
		userWxInfo.setOpenId("1");
		int i = WxMpUserMapperImpl.insertWxMpUser(userWxInfo);
		System.out.println("结果：" + i);
		Assert.assertEquals(i, 1);
	}
	
	@Test
	public void testCancelAttention() {

		WxMpUser userWxInfo = new WxMpUser();
		userWxInfo.setOpenId("11");
		userWxInfo.setSubscribe(false);
		int i = WxMpUserMapperImpl.cancelAttention(userWxInfo);
		System.out.println("结果：" + i);
		Assert.assertEquals(i, 1);
	}
	
	@Test
	public void testQueryCountByOpenId() {

		WxMpUser userWxInfo = new WxMpUser();
		userWxInfo.setOpenId("oVJ-vv-TAqzqyk0OPUdeG-Vvj-Gk");
		int i = WxMpUserMapperImpl.queryCountByOpenId(userWxInfo);
		System.out.println("查询结果：" + i);
		Assert.assertEquals(i, 1);
	}
	
	@Test
	public void testUpdateWxMpUser() {

		WxMpUser userWxInfo = new WxMpUser();
		userWxInfo.setOpenId("11");
		userWxInfo.setNickname("333");
		int i = WxMpUserMapperImpl.updateWxMpUser(userWxInfo);
		System.out.println("更新：" + i);
		Assert.assertEquals(i, 1);
	}
}
