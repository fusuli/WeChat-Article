package org.fusu.wechat.handler;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.fusu.wechat.biz.ArticleBiz;
import org.springframework.stereotype.Component;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 
 * @author fusuli
 *
 */
@Component
public class MenuHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService,
			WxSessionManager sessionManager) {
		if (WxConsts.BUTTON_CLICK.equals(wxMessage.getEvent().toLowerCase())) {
			// 处理关键字,判断按钮的值
			if (StringUtils.equals(wxMessage.getEventKey(), "HOT")) {
				return WxMpXmlOutMessage.NEWS().fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
						.articles(ArticleBiz.hotArticle()).build();
			} else if (StringUtils.equals(wxMessage.getEventKey(), "NEW")) {
				return WxMpXmlOutMessage.NEWS().fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
						.articles(ArticleBiz.newArticle()).build();
			}
		}
		return null;
	}
}
