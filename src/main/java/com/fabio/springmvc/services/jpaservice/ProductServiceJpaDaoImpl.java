package com.fabio.springmvc.services.jpaservice;

import com.fabio.springmvc.commands.ProductForm;
import com.fabio.springmvc.converters.ProductFormToProduct;
import com.fabio.springmvc.converters.ProductToProductForm;
import com.fabio.springmvc.domain.Product;
import com.fabio.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl extends AbstractJpaDaoService implements ProductService {

    private ProductToProductForm productToProductForm;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public ProductServiceJpaDaoImpl(ProductToProductForm productToProductForm, ProductFormToProduct productFormToProduct) {
        this.productToProductForm = productToProductForm;
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        return  em.createQuery("from Product", Product.class)
                .getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject); // merge = save or update, persists but also updates
        em.getTransaction().commit();
        return savedProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return null;
    }

    public ProductForm saveOrUpdate(ProductForm productForm){
        if(productForm.getId()!=null){
            Product productToUpdate = this.getById(productForm.getId());
            productToUpdate.setVersion(productForm.getVersion());
            productToUpdate.setDescription(productForm.getDescription());
            productToUpdate.setPrice(productForm.getPrice());
            productToUpdate.setImageUrl(productForm.getImageUrl());
            return productToProductForm.convert(this.saveOrUpdate(productToUpdate));
        }else{
            return productToProductForm.convert(this.saveOrUpdate(productFormToProduct.convert(productForm)));
        }
    }

}
