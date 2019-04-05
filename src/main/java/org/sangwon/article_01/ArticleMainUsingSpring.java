package org.sangwon.article_01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ArticleMainUsingSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"article_01.xml");
		ArticleService articleService = context.getBean("articleService",
				ArticleService.class);
		context.close();

		articleService.addArticle();
		articleService.listArticles();
	}

}