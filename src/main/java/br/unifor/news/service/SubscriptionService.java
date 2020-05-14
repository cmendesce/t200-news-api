package br.unifor.news.service;

import br.unifor.news.entity.Category;
import br.unifor.news.entity.Subscription;
import br.unifor.news.repository.CategoryRepository;
import br.unifor.news.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final CategoryRepository categoryRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
                               CategoryRepository categoryRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.categoryRepository = categoryRepository;
    }

    public void subscribe(String email, List<Integer> categoriesIds) {
        List<Category> categories = categoryRepository.findAllById(categoriesIds);
        List<Subscription> subs = new ArrayList<>();

        for (Category category : categories) {
            subs.add(new Subscription(email, category));
        }

        if (!subs.isEmpty()) {
            subscriptionRepository.saveAll(subs);
        }
    }

    public void unsubscribe(String email, Integer categoryId) {

    }
}
