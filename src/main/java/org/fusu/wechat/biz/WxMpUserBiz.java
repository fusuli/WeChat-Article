package org.fusu.wechat.biz;

import org.fusu.wechat.mapper.impl.WxMpUserMapperImpl;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * @author fusuli
 *
 */
public class WxMpUserBiz {

	/**
	 * 判断用户是否关注 。如果已关注，根据openId修改原有数据； 从未关注，直接添加用户信息
	 * 
	 * @param wxMpUser
	 */
	public static void wxMpUserInfor(WxMpUser wxMpUser) {
		int rs1 = WxMpUserMapperImpl.queryCountByOpenId(wxMpUser);
		if (rs1 > 0) {
			int rs = WxMpUserMapperImpl.updateWxMpUser(wxMpUser);
			System.out.println("二次关注成功：" + rs);
		} else {
			int rs = WxMpUserMapperImpl.insertWxMpUser(wxMpUser);
			System.out.println("添加成功：" + rs);
		}
	}

	/**
	 * 用户取消关注
	 * 
	 * @param openId
	 */
	public static void wxMpUserCancel(String openId) {
		WxMpUser wxMpUser = new WxMpUser();
		wxMpUser.setSubscribe(false);
		wxMpUser.setOpenId(openId);
		int rs = WxMpUserMapperImpl.cancelAttention(wxMpUser);
		System.out.println("取消关注成功：" + rs);
	}

}
