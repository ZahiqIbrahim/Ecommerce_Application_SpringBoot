package com.example.SpringEcom.controller;

import com.example.SpringEcom.model.Product;
import com.example.SpringEcom.repo.ProductRepo;
import com.example.SpringEcom.service.ProductService;
import org.apache.coyote.Response;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.html.HTMLParagraphElement;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")// Get Products List
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}") //Get single Product using id
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        Product product = productService.getProductById(id);
        if(product.getId() > 0){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("product/{productId}/image")// Get Image of a product
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product = productService.getProductById(productId);
        if(product.getId() > 0){
            return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product") // add a new Product to your database
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product savedProduct = null;
        try {
            savedProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/product/{id}") // update an existing product
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,@RequestPart MultipartFile imageFile){
        Product updatedProduct = null;
        try{
            updatedProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        catch (IOException e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}") // Delete a product
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
       Product product = productService.getProductById(id);
       if(product != null){
           productService.deleteProduct(id);
           return new ResponseEntity<>("Deleted",HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }


    }

    @GetMapping("/products/search") // searching a product for each character
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product> products = productService.searchProducts(keyword);
        System.out.println("searching with "+keyword );
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



}
