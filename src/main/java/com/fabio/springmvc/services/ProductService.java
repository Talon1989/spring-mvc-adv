package com.fabio.springmvc.services;

import com.fabio.springmvc.commands.ProductForm;
import com.fabio.springmvc.domain.Product;

import java.util.List;

public interface ProductService extends CrudService<Product>{
    Product saveOrUpdateProductForm(ProductForm productForm);

//    List<Product> listAllProducts();
//    Product getProductById(Integer id);
//    Product saveOrUpdateProduct(Product product);
//    void deleteProduct(Integer id);

}
