package org.fusu.wechat.web;

import org.fusu.wechat.bean.Article;
import org.fusu.wechat.biz.ArticleBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author fusuli
 *
 */
@Controller
@RequestMapping("/ui/article")
public class ArticleController {
	@RequestMapping("/detail/{articleid}")
	public String detail(@PathVariable("articleid") int articleid, Model model) {
		System.out.println("获取：" + articleid);
		// HttpServletRequest request = null;
		// String openid =(String) request.getAttribute("openid");
		Article article = new Article();
		article = ArticleBiz.queryArticleByArticleid(articleid);
		model.addAttribute("article", article);
		return "article";
	}
}
