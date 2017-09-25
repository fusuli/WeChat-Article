package org.fusu.wechat.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *  注意：此contorller 实现WxMpMenuService接口，仅是为了演示如何调用所有菜单相关操作接口，
 *      实际项目中无需这样，根据自己需要添加对应接口即可
 * </pre>
 *
 * @author fusuli
 */
@RestController
@RequestMapping("/wechat/oauth")
public class WxOauthController {

	@Autowired
	private WxMpService wxMpService;

	/**
	 * 默认GET 请求返回基础授权 url地址，并且通过跳转到对应 url 地址上进行授权获取openid
	 * 
	 * @return url
	 * 
	 */
	@GetMapping("/getBaseUrl")
	public void getBaseUrl(HttpServletRequest req, HttpServletResponse res) {

		// 记录当前需要回调的页面
		String redirectURI = "http://natapp.iceinto.com/wechat/oauth/code";
		String url = wxMpService.oauth2buildAuthorizationUrl(redirectURI, WxConsts.OAUTH2_SCOPE_BASE, null);
		try {
			res.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过微信公众平台授权返回 code 进行处理
	 * 
	 * @param code
	 *            微信公众平台返回code
	 * @param req
	 *            request 请求信息
	 * @return 处理结果
	 */
	@RequestMapping(value = "/code", method = RequestMethod.GET)
	public boolean getInfoByCode(String code, String state, HttpServletRequest req, HttpServletResponse res) {
		try {
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
			String openid = wxMpOAuth2AccessToken.getOpenId();
			System.out.println(wxMpOAuth2AccessToken);
			if (!StringUtils.isEmpty(openid)) {
				req.getSession().setAttribute("openid", openid);
				// 页面跳转
				return true;
			}
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@RequestMapping(value = "tsession", method = RequestMethod.GET)
	public String TestSession(HttpServletRequest req) {
		String a = (String) req.getSession().getAttribute("openid");
		System.out.println("tsession openid:" + a);
		return a;
	}
}
