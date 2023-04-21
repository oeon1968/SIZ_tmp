package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.ContractType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class ContractTypeDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert(ContractType contractType) {
        entityManager.persist(contractType);
    }
    //update
    public void update(ContractType contractType) {
        entityManager.merge(contractType);
    }
    //delete
    public void delete(ContractType contractType) {
        entityManager.remove(entityManager.contains(contractType) ? contractType : entityManager.merge(contractType));
    }
    //select one
    public ContractType findObject (int id) {
        return entityManager.find(ContractType.class, id);
    }
    //select list
    public List<ContractType> contractTypeList() {
        return entityManager.createQuery("SELECT ct FROM ContractType ct ORDER BY ct.contractName").getResultList();
    }
}
