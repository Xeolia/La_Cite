package com.la_cite.surfrider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.la_cite.surfrider.Products;
import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer>{
    public List<Products> findAllByCreatorEquals(String Username);
}
