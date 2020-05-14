package br.unifor.news.controller;

import java.util.List;

public class SubscriptionRequest {

    private String email;
    private List<Integer> categories;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }
}
