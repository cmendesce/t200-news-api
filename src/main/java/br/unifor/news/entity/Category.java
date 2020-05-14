package br.unifor.news.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@JsonIgnoreProperties(value = {"available"})
public class Category extends AbstractEntity {

    private String name;
    private Boolean available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
