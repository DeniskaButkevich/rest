package com.dez.rest.repo;

import com.dez.rest.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProduct extends CrudRepository<Product, Long> {
}
