package org.fusu.wechat.mapper;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * @param wxMpUser
 * @return
 */
public interface WxMpUserMapper {
	// 首次关注，存储用户信息
	public int insertWxMpUser(WxMpUser wxMpUser);

	// 取消关注，软删除用户信息
	// public int deleteWxMpUser(String openId);
	public int cancelAttention(WxMpUser wxMpUser);

	// 查询用户是否存在
	public WxMpUser queryWxMpUserByOpenId(WxMpUser wxMpUser);

	// 二次关注，更新用户信息
	public int updateWxMpUser(WxMpUser wxMpUser);
}
