package org.fusu.wechat.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.fusu.wechat.bean.Article;
import org.fusu.wechat.biz.ArticleBiz;
import org.springframework.stereotype.Component;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;

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
			// 处理关键字
			if (StringUtils.equals(wxMessage.getEventKey(), "HOT")) {
				List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();
				List<Article> alist = ArticleBiz.queryArticleByHot();
				System.out.println(alist.size());
				for (int i = 0; i < alist.size(); i++) {
					WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
					System.out.println(alist.get(i).getTitle());
					item.setTitle(alist.get(i).getTitle());
					item.setPicUrl(alist.get(i).getPic_url());
					item.setUrl(alist.get(i).getUrl());
					articles.add(item);
				}
				return WxMpXmlOutMessage.NEWS().fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
						.articles(articles).build();
			} else if (StringUtils.equals(wxMessage.getEventKey(), "NEW")) {
				List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();
				List<Article> alist = ArticleBiz.queryArticleByHot();
				for (int i = 1; i <= alist.size(); i++) {
					WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
					
					item.setTitle(alist.get(i).getTitle());
					item.setPicUrl(alist.get(i).getPic_url());
					item.setUrl(alist.get(i).getUrl());
					articles.add(item);
				}
				return WxMpXmlOutMessage.NEWS().fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
						.articles(articles).build();
			}
		}
		return null;
	}

}
