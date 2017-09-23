package org.fusu.wechat.mapper;

import java.util.List;

import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;

/**
 * 
 * @author fusuli
 *
 */
public interface ItemMapper {

	public List<WxMpXmlOutNewsMessage.Item> queryItemByHot();

	public List<WxMpXmlOutNewsMessage.Item> queryItemByNew();
}
