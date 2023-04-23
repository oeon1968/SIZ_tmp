package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.ProductGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductGroupDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert(ProductGroup productGroup) {
        entityManager.persist(productGroup);
    }
    //update
    public void update(ProductGroup productGroup) {
        entityManager.merge(productGroup);
    }
    //delete
    public void delete(ProductGroup productGroup) {
        entityManager.remove(entityManager.contains(productGroup)?productGroup:entityManager.merge(productGroup));
    }
    //select one
    public ProductGroup findObject(Integer id) {
        return entityManager.find(ProductGroup.class, id);
    }
    //select list
    public List<ProductGroup> productGroupList() {
        return entityManager.createQuery("SELECT pg FROM ProductGroup pg ORDER BY pg.name").getResultList();
    }

}
