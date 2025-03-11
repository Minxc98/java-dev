package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.JsonResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchHitsImpl;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleService {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 分页查询
     *
     * @param size
     * @return
     */
    public JsonResult scroll(String scrollId, Integer size) {
        // 滚动查询 scroll api
        if (size == null || size <= 0) {
            return new JsonResult(false, "请输入每页查询数");
        }
        NativeSearchQuery query = new NativeSearchQuery(new BoolQueryBuilder());
        query.setPageable(PageRequest.of(0, size));
        SearchHits<Article> searchHits = null;
        if (StringUtils.isEmpty(scrollId)) {
            // 开启一个滚动查询，设置该 scroll 上下文存在 60s
            // 同一个 scroll 上下文，只需要设置一次 query（查询条件）
            searchHits = elasticsearchRestTemplate.searchScrollStart(60000, query, Article.class, IndexCoordinates.of("article"));
            if (searchHits instanceof SearchHitsImpl) {
                scrollId = ((SearchHitsImpl) searchHits).getScrollId();
            }
        } else {
            // 继续滚动
            searchHits = elasticsearchRestTemplate.searchScrollContinue(scrollId, 60000, Article.class, IndexCoordinates.of("article"));
        }

        List<Article> articles = searchHits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
        if (articles.size() == 0) {
            // 结束滚动
            elasticsearchRestTemplate.searchScrollClear(Collections.singletonList(scrollId));
            scrollId = null;
        }

        if (scrollId == null) {
            return new JsonResult(false, "已到末尾");
        } else {
            JsonResult jsonResult = new JsonResult(true);
            jsonResult.setMsg(articles);
            jsonResult.setScrollId(scrollId);
            return jsonResult;
        }

    }
}
