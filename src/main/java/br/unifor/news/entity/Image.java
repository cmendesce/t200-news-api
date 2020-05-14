package br.unifor.news.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image extends AbstractEntity {
    private String source;

    @ManyToOne
    private News news;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
