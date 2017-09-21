package org.fusu.wechat.mapper;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * @param wxMpUser
 * @return
 */
public interface WxMpUserMapper {
	//存储用户信息
	public int insertWxMpUser(WxMpUser wxMpUser);
}
