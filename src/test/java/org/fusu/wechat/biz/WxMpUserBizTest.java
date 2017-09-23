package org.fusu.wechat.biz;

import org.junit.Assert;
import org.junit.Test;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class WxMpUserBizTest {

	@Test
	public void test() {
		WxMpUser userWxInfo  = new WxMpUser();
		userWxInfo.setOpenId("123123");
		int i = WxMpUserBiz.queryWxMpUserByOpenId(userWxInfo);
		Assert.assertEquals(i, 0);
	}

}
