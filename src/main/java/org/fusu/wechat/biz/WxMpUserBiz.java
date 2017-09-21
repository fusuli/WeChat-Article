package org.fusu.wechat.biz;

import org.apache.ibatis.session.SqlSession;
import org.fusu.wechat.mapper.WxMpUserMapper;
import org.fusu.wechat.utils.SqlSessionFactoryUtil;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class WxMpUserBiz {
	static SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	static WxMpUserMapper wxMpUserMapper = session.getMapper(WxMpUserMapper.class);

	public static int insertItem(WxMpUser wxMpUser) {
		int i = wxMpUserMapper.insertWxMpUser(wxMpUser);
		if (i > 0) {
			session.commit();
		}
		return i;
	}
}
