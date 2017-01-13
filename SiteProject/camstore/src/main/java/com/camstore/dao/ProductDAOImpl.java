package com.camstore.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.camstore.dao.ProductDAO;
import com.camstore.model.Product;


@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {


    @Autowired
    SessionFactory sessionFactory;

    public void addProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }
    
    public void updateProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        
    }
    
    public Product getProductById (int id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.createQuery("from person where id="+id).getSingleResult();
        return product;
    }

    public List<Product> listProducts(){
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").getResultList();
        return products;
    }
    
    public void removeProduct (int id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.createQuery("from person where id="+id).getSingleResult();
        session.delete(product);
    }
} // The End of Class;

