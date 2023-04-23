package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.ClientType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ClientTypeDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert (ClientType clientType) {
        entityManager.persist(clientType);
    }
    //update
    public void update (ClientType clientType) {
        entityManager.merge(clientType);
    }

    //delete
    public void delete (ClientType clientType) {
        entityManager.remove(entityManager.contains(clientType)? clientType : entityManager.merge(clientType));
    }

    //select one
    public ClientType findObject (Integer id) {
         return entityManager.find(ClientType.class, id);
    }

    //select list
    public List<ClientType> clientTypeList() {
        return entityManager.createQuery("SELECT ct FROM ClientType ct ORDER BY ct.typeName").getResultList();
    }

}
