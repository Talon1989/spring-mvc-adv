package com.fabio.springmvc.controllers;

import com.fabio.springmvc.commands.ProductForm;
import com.fabio.springmvc.converters.ProductToProductForm;
import com.fabio.springmvc.domain.Product;
import com.fabio.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class ProductController {

    private ProductService productService;
    private ProductToProductForm productToProductForm;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @GetMapping("/product/list")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    @GetMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }
    @PostMapping("/product")
    public String saveOrUpdateProduct(@Valid ProductForm productForm
            , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "product/productform";
        }
        Product savedProduct = productService.saveOrUpdateProductForm(productForm);
        return "redirect:/product/"+savedProduct.getId();
    }
    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product product = productService.getById(id);
        model.addAttribute("productForm", productToProductForm.convert(product));
        return "product/productform";
    }
    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/list";
    }

}
