package org.fusu.wechat.biz;

import java.util.ArrayList;
import java.util.List;

import org.fusu.wechat.bean.Article;
import org.fusu.wechat.mapper.impl.ArticleMapperImpl;

import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;

/**
 * 
 * @author fusuli
 *
 */
public class ArticleBiz {

	/**
	 * 查询最热5篇文章
	 * 
	 * @return
	 */
	public static List<WxMpXmlOutNewsMessage.Item> hotArticle() {
		List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();
		List<Article> alist = ArticleMapperImpl.queryArticleByHot();
		for (int i = 0; i < alist.size(); i++) {
			WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
			item.setTitle(alist.get(i).getTitle());
			item.setPicUrl(alist.get(i).getPic_url());
			item.setUrl("http://natapp.iceinto.com/ui/article/detail/"+alist.get(i).getArticleid());
			articles.add(item);
		}
		return articles;
	}

	/**
	 * 查询最新5篇文章
	 * 
	 * @return
	 */
	public static List<WxMpXmlOutNewsMessage.Item> newArticle() {
		List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();
		List<Article> alist = ArticleMapperImpl.queryArticleByNew();
		for (int i = 0; i < alist.size(); i++) {
			WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
			item.setTitle(alist.get(i).getTitle());
			item.setPicUrl(alist.get(i).getPic_url());
			item.setUrl("http://natapp.iceinto.com/ui/article/detail/"+alist.get(i).getArticleid());
			articles.add(item);
		}
		return articles;
	}
	
	/**
	 * 根据用户输入的字段模糊查询
	 * @param title
	 * @return
	 */
	public static List<WxMpXmlOutNewsMessage.Item> likeArticle(String title){
		List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();
		List<Article> alist = ArticleMapperImpl.queryArticleByTitle(title);
		for (int i = 0; i < alist.size(); i++) {
			WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
			item.setTitle(alist.get(i).getTitle());
			item.setPicUrl(alist.get(i).getPic_url());
			item.setUrl("http://natapp.iceinto.com/ui/article/detail/"+alist.get(i).getArticleid());
			articles.add(item);
		}
		return articles;
	}
	/**
	 * 根据articleid查询文章
	 * @param articleid
	 * @return
	 */
	public static Article queryArticleByArticleid(int articleid){
		return ArticleMapperImpl.queryArticleByArticleid(articleid);
	}
}
