package productManagement.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import productManagement.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> getList() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where show = true ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    public void add(Product product) {
        Session session = null;
        Transaction transaction;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void edit(Product product) {
        Session session = null;
        Transaction transaction;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void remove(Product product) {
        Session session = null;
        Transaction transaction;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Product findById(int id) {
        Session session = null;
        Product product;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("from Product where id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    public List<Product> search(String search) {
        Session session = null;
        List<Product> productList;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where name like : search and show = true").setParameter("search", "%" + search + "%").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

}
