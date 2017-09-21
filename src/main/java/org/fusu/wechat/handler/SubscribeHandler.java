package org.fusu.wechat.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.fusu.wechat.biz.WxMpUserBiz;
import org.fusu.wechat.builder.TextBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author fusuli
 */
@Component
public class SubscribeHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService,
			WxSessionManager sessionManager) throws WxErrorException {

		this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

		// 获取微信用户基本信息
		WxMpUser userWxInfo = weixinService.getUserService().userInfo(wxMessage.getFromUser(), null);

		if (userWxInfo != null) {
			// TODO 可以添加关注用户到本地
			//System.out.println(userWxInfo.getCity());
			//System.out.println(userWxInfo.getProvince());
			//System.out.println(userWxInfo.getCountry());
			System.out.println(userWxInfo.getHeadImgUrl());
			//System.out.println(userWxInfo.getSubscribeTime());
			//System.out.println(userWxInfo.getLanguage());
			//System.out.println(userWxInfo.getNickname());
			
			//System.out.println(userWxInfo.getOpenId());
			
			System.out.println(userWxInfo.getRemark());
			System.out.println(userWxInfo.getSexId());
			//System.out.println(userWxInfo.getSex());
			System.out.println(userWxInfo.getUnionId());
			System.out.println(userWxInfo.getTagIds());

			int rs = WxMpUserBiz.insertItem(userWxInfo);
			System.out.println(rs);
		}

		WxMpXmlOutMessage responseResult = null;
		try {
			responseResult = handleSpecial(wxMessage);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}

		if (responseResult != null) {
			return responseResult;
		}

		try {
			return new TextBuilder().build("感谢关注", wxMessage, weixinService);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
	 */
	private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {
		// TODO
		return null;
	}

}
