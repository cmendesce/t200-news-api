package br.unifor.news.controller.admin;

import br.unifor.news.entity.Category;
import br.unifor.news.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("admin-categoryController")
@RequestMapping("/admin/categories")
public class CategoryController {

    private final NewsService newsService;

    public CategoryController(NewsService newsService) {
        this.newsService = newsService;
    }

    // GET /categories
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(newsService.listCategories());
    }
}
