package org.fusu.wechat.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.fusu.wechat.biz.WxMpUserBiz;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author fusuli
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {
	
	WxMpService wxMpService;
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		String openId = wxMessage.getFromUser();
		this.logger.info("取消关注用户 OPENID: " + openId);
		// TODO 可以更新本地数据库为取消关注状态
		WxMpUser wxMpUser = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), null);
		//更改关注状态
		wxMpUser.setSubscribe(false);
		int rs = WxMpUserBiz.cancelAttention(wxMpUser);
		System.out.println("取消关注成功："+rs);
		return null;
	}

}
