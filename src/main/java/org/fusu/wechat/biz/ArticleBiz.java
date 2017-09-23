package org.fusu.wechat.biz;

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
public class ArticleBiz {
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
}
