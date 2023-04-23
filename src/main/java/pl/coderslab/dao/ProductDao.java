package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert(Product product) {
        entityManager.persist(product);
    }
    //update
    public void update(Product product) {
        entityManager.merge(product);
    }
    //delete
    public void delete(Product product){
        entityManager.remove(entityManager.contains(product)? product:entityManager.merge(product));
    }
    //select one
    public Product findObject(Integer id) {
        return entityManager.find(Product.class, id);
    }
    //select all
    public List<Product> productList() {
        return entityManager.createQuery("SELECT p FROM Product p ORDER BY p.productGroup.name, p.name ").getResultList();
    }
}
