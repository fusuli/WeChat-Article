package org.fusu.wechat.handler;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.fusu.wechat.biz.ArticleBiz;
import org.fusu.wechat.builder.TextBuilder;
import org.fusu.wechat.utils.JsonUtils;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
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
public class MsgHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService,
			WxSessionManager sessionManager) {

		if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
			// TODO 可以选择将消息保存到本地
			if (ArticleBiz.likeArticle(wxMessage.getContent()).size() <= 0) {
				String msString = "对不起！没有您需要的关于" + "“" + wxMessage.getContent() + "”" + "的文章";
				return WxMpXmlOutMessage.TEXT().content(msString).fromUser(wxMessage.getToUser())
						.toUser(wxMessage.getFromUser()).build();
			}
			return WxMpXmlOutMessage.NEWS().fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
					.articles(ArticleBiz.likeArticle(wxMessage.getContent())).build();
		}

		// 当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
		try {
			if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
					&& weixinService.getKefuService().kfOnlineList().getKfOnlineList().size() > 0) {
				return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUser())
						.toUser(wxMessage.getFromUser()).build();
			}
		} catch (WxErrorException e) {
			e.printStackTrace();
		}

		// TODO 组装回复消息
		String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
		return new TextBuilder().build(content, wxMessage, weixinService);

	}

}
