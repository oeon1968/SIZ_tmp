package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Contract;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ContractDao {
    @PersistenceContext
    EntityManager entityManager;
    //insert
    public void insert(Contract contract) {
        entityManager.persist(contract);
    }
    //update
    public void update(Contract contract) {
        entityManager.merge(contract);
    }
    //delete
    public void delete(Contract contract) {
        entityManager.remove(entityManager.contains(contract)?contract:entityManager.merge(contract));
    }
    //select one
    public Contract findObject(Long id) {
        return entityManager.find(Contract.class, id);
    }
    //select all
    public List<Contract> contractList() {
        return entityManager.createQuery("SELECT c FROM Contract c ORDER BY c.contractStart ").getResultList();
    }
}
