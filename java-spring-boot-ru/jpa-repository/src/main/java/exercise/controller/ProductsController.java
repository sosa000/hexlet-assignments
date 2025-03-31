package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> index(@RequestParam(defaultValue = "0") int min, @RequestParam(defaultValue = "1000000") int max) {
        Sort sort = Sort.by(Sort.Order.asc("price"));
        var products = productRepository.findAllByPriceBetweenOrderByPrice(min, max, sort);
        return products;
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
