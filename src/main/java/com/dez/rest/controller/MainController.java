package com.dez.rest.controller;

import com.dez.rest.domain.Product;
import com.dez.rest.repo.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    RepoProduct repoProduct;

    @GetMapping
    public Iterable<Product> main( ){
        return repoProduct.findAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return repoProduct.findById(id).get();
    }

    @PostMapping(value = "/add", produces={"application/json", "text/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        Product addedProduct = repoProduct.save(product);

        return addedProduct;
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Product product, @PathVariable long id) {

            Optional<Product> productOptional = repoProduct.findById(id);

            if (!productOptional.isPresent())
                return ResponseEntity.notFound().build();

        product.setId(id);

        repoProduct.save(product);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable long id){
        repoProduct.deleteById(id);
    }


}
