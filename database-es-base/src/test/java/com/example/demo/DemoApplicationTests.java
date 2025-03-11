package com.example.demo;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.entity.Article;
import com.example.demo.entity.JsonResult;
import com.example.demo.service.ArticleService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() throws IOException {
        Article article = new Article();
        article.setId("112233");
        article.setTitle("java");
        article.setContent("hello world");
        article.setUserId(22221111);
        article.setCreateTime(new Date());
        articleRepository.save(article);

        Article ar = articleRepository.findById("112233").orElse(null);
        Assert.isTrue(Objects.equals(ar,article), "查询结果错误");

        extracted(ar);
        Article arr = articleRepository.findById("112233").orElse(null);
        Assert.isTrue(arr == null, "删除失败");
    }

    private void extracted(Article ar) {
        articleRepository.delete(ar);
    }

    private void simpleSave(){
        Article article = new Article();
        article.setTitle("java");
        article.setContent("hello world");
        article.setUserId(22221111);
        article.setCreateTime(new Date());
        articleRepository.save(article);

    }

    @Test
    void simplePageTest(){

        NativeSearchQuery query = new NativeSearchQuery(new BoolQueryBuilder());
        query.setPageable(PageRequest.of(0, 10));

        // 方法1：
        SearchHits<Article> searchHits = elasticsearchRestTemplate.search(query, Article.class);

        // 方法2：
        // SearchHits<Article> searchHits = elasticsearchOperations.search(query, Article.class);
        List<Article> articles = searchHits.getSearchHits().stream().map(SearchHit::getContent).toList();
        articles.forEach(System.out::println);
    }



    @Test
    void rollPageTest(){
        for (int i = 0; i < 15; i++) {
            simpleSave();
        }
        JsonResult scroll = articleService.scroll(null, 10);
        JsonResult scroll1 = articleService.scroll(scroll.getScrollId(), 10);
        System.out.println(1);

    }

}
