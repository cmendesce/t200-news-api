package br.unifor.news.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscription")
public class Subscription extends AbstractEntity {

    @Column(name = "user_email")
    private String email;

    @ManyToOne
    private Category category;

    Subscription() {
    }

    public Subscription(String email, Category category) {
        this.email = email;
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public Category getCategory() {
        return category;
    }
}
