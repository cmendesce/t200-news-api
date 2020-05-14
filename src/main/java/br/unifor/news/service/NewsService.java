package br.unifor.news.service;

import br.unifor.news.entity.Category;
import br.unifor.news.entity.News;
import br.unifor.news.repository.CategoryRepository;
import br.unifor.news.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    public NewsService(NewsRepository newsRepository, CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<News> listNews() {
        return newsRepository.findAll();
    }

    public Optional<News> findNews(Integer id) {
        return newsRepository.findById(id);
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> listAvailableCategories() {
        return categoryRepository.findAvailable();
    }
}
