package org.fusu.wechat.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.fusu.wechat.bean.Article;
import org.fusu.wechat.mapper.ArticleMapper;
import org.fusu.wechat.utils.SqlSessionFactoryUtil;

/**
 * 
 * @author fusuli
 *
 */
public class ArticleMapperImpl {
	static SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
	static ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);

	/**
	 * 根据hot查找最热5篇文章
	 *
	 * @return
	 */
	public static List<Article> queryArticleByHot() {
		return articleMapper.queryArticleByHot();
	}

	/**
	 * 查找最新5篇文章
	 * 
	 * @return
	 */
	public static List<Article> queryArticleByNew() {
		return articleMapper.queryArticleByNew();
	}

	/**
	 * 根据用户输入模糊查询相关文章
	 * 
	 * @param title
	 * @return
	 */
	public static List<Article> queryArticleByTitle(String title) {
		return articleMapper.queryArticleByTitle(title);
	}

	/**
	 * 根据articleid查询文章
	 * 
	 * @param articleid
	 * @return
	 */
	public static Article queryArticleByArticleid(int articleid) {
		return articleMapper.queryArticleByArticleid(articleid);
	}
}
