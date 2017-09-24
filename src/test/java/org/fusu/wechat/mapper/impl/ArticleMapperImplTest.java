package org.fusu.wechat.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.fusu.wechat.bean.Article;
import org.junit.Assert;
import org.junit.Test;

public class ArticleMapperImplTest {

	@Test
	public void testQueryArticleByHot() {
		List<Article> articles = new ArrayList<>();
		articles = ArticleMapperImpl.queryArticleByHot();
		System.out.println(articles.size());
		int i = articles.size();
		Assert.assertEquals(i, 5);
	}
	
	@Test
	public void testQueryArticleByNew() {
		List<Article> articles = new ArrayList<>();
		articles = ArticleMapperImpl.queryArticleByNew();
		System.out.println(articles.size());
		int i = articles.size();
		Assert.assertEquals(i, 5);
	}
	
	@Test
	public void testQueryArticleByTitle() {
		List<Article> articles = new ArrayList<>();
		articles = ArticleMapperImpl.queryArticleByTitle("32");
		System.out.println(articles.size());
		int i = articles.size();
		Assert.assertEquals(i, 1);
	}

	@Test
	public void testQueryArticleByArticleid() {

		Article article = new Article();
		int articleid = 3;
		article = ArticleMapperImpl.queryArticleByArticleid(articleid);
		System.out.println("查询结果：" + article.getContent() + article.getPic_url());
		int i = 0;
		if (article != null) {
			i = 1;
		}
		Assert.assertEquals(i, 1);
	}
}
