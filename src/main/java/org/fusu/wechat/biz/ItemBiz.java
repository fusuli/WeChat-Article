package org.fusu.wechat.biz;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.fusu.wechat.mapper.ItemMapper;
import org.fusu.wechat.utils.SqlSessionFactoryUtil;

import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;

/**
 * 
 * @author fusuli
 *
 */
public class ItemBiz {
	static SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	static ItemMapper itemMapper = session.getMapper(ItemMapper.class);

	/**
	 * 根据hot查找最热5篇文章
	 *
	 * @return
	 */
	public static List<WxMpXmlOutNewsMessage.Item> queryItemByHot() {
		return itemMapper.queryItemByHot();
	}

	/**
	 * 
	 * @return
	 */
	public static List<WxMpXmlOutNewsMessage.Item> queryItemByNew() {
		return itemMapper.queryItemByNew();
	}
}
