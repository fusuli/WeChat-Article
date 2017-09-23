package org.fusu.wechat.mapper;

import java.util.List;

import org.fusu.wechat.bean.Article;

/**
 * 
 * @author fusuli
 *
 */
public interface ArticleMapper {
	public List<Article> queryArticleByHot();

	public List<Article> queryArticleByNew();
}
