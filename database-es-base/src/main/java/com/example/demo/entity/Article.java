package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.Objects;

@Data
@Document(indexName = "article")
public class Article  {

    // 注意id字段是必须的，可以不写注解@Id。
    @Id
    private String id;

    private String title;
    private String content;
    private Integer userId;
    private Date createTime;

    public Article() {
    }
    public Article(String title, String content, Integer userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createTime = new Date();
    }

    public Article(String id, String title, String content, Integer userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createTime = new Date();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(content, article.content) && Objects.equals(userId, article.userId) && Objects.equals(createTime, article.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, userId, createTime);
    }


}
