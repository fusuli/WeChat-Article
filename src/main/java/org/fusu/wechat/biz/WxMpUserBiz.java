package org.fusu.wechat.biz;

import org.apache.ibatis.session.SqlSession;
import org.fusu.wechat.mapper.WxMpUserMapper;
import org.fusu.wechat.utils.SqlSessionFactoryUtil;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class WxMpUserBiz {
	static SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	static WxMpUserMapper wxMpUserMapper = session.getMapper(WxMpUserMapper.class);

	/**
	 * 添加用户信息
	 * 
	 * @param wxMpUser
	 * @return
	 */
	public static int insertWxMpUser(WxMpUser wxMpUser) {
		int i = wxMpUserMapper.insertWxMpUser(wxMpUser);
		if (i > 0) {
			session.commit();
		}
		return i;
	}

	/**
	 * 取消关注
	 * 
	 * @param openId
	 * @return
	 */

	public static int cancelAttention(WxMpUser wxMpUser) {
		int i = wxMpUserMapper.cancelAttention(wxMpUser);
		if (i > 0) {
			session.commit();
		}
		return i;
	}

	/**
	 * 查询是否关注
	 * 
	 * @param wxMpUser
	 * @return
	 */
	public static int queryWxMpUserByOpenId(WxMpUser wxMpUser) {
		WxMpUser user = wxMpUserMapper.queryWxMpUserByOpenId(wxMpUser);
		if (user != null) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * 更新用户信息
	 * @param wxMpUser
	 * @return
	 */
	public static int updateWxMpUser(WxMpUser wxMpUser) {
		int i = wxMpUserMapper.updateWxMpUser(wxMpUser);
		if (i > 0) {
			session.commit();
		}
		return i;
	}
}
