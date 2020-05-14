package br.unifor.news.controller;

import br.unifor.news.entity.News;
import br.unifor.news.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // GET /news
    @GetMapping
    public ResponseEntity<List<News>> getAll() {
        return ResponseEntity.ok(newsService.listNews());
    }

    // GET /news/{id}
    @GetMapping("/{id}")
    public ResponseEntity<News> getOne(@PathVariable("id") Integer id) {
        var news = newsService.findNews(id);

        //return news.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        if (news.isPresent()) {
            return ResponseEntity.ok(news.get());
        }
        return ResponseEntity.notFound().build();
    }
}
