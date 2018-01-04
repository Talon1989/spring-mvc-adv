package com.fabio.springmvc.services.reposervices;

import com.fabio.springmvc.commands.ProductForm;
import com.fabio.springmvc.converters.ProductFormToProduct;
import com.fabio.springmvc.converters.ProductToProductForm;
import com.fabio.springmvc.domain.Product;
import com.fabio.springmvc.repositories.ProductRepository;
import com.fabio.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class ProductServiceRepoImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;
    private ProductToProductForm productToProductForm;

    public ProductServiceRepoImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct, ProductToProductForm productToProductForm) {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
        this.productToProductForm = productToProductForm;
    }

    @Override
    public List<?> listAll() {
//        return (List<Product>)productRepository.findAll();
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return productRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        Product newProdut = productFormToProduct.convert(productForm);
        return saveOrUpdate(newProdut);
    }
}
