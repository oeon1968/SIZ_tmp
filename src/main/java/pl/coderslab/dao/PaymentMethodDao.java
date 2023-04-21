package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.PaymentMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PaymentMethodDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert(PaymentMethod paymentMethod) {
        entityManager.persist(paymentMethod);
    }
    //update
    public void update(PaymentMethod paymentMethod) {
        entityManager.merge(paymentMethod);
    }
    //delete
    public void delete(PaymentMethod paymentMethod) {
        entityManager.remove(entityManager.contains(paymentMethod) ? paymentMethod:entityManager.merge(paymentMethod));
    }
    //select one
    public PaymentMethod findObject(int id) {
        return entityManager.find(PaymentMethod.class, id);
    }
    //select list
    public List<PaymentMethod> paymentMethodList() {
        return entityManager.createQuery("SELECT pm FROM PaymentMethod pm ORDER BY pm.paymentMethod")
                .getResultList();
    }
}
