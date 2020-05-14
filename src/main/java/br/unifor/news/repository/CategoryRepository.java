package br.unifor.news.repository;

import br.unifor.news.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("FROM Category WHERE available = TRUE")
    List<Category> findAvailable();
}
