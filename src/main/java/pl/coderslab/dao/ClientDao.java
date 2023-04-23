package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ClientDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert (Client client) {
        entityManager.persist(client);
    }
    //update
    public void update (Client client) {
        entityManager.merge(client);
    }
    //delete
    public void delete(Client client) {
        entityManager.remove(entityManager.contains(client)?client: entityManager.merge(client));
    }
    // select one
    public Client findObject(int id) {
        return entityManager.find(Client.class, id);
    }
    //select all
    public List<Client> clientList() {
        return entityManager.createQuery("SELECT cl FROM Client cl " +
                                        "JOIN FETCH AccountManager am ON cl.accountManager.id = am.id" +
                                        " JOIN FETCH ClientType ct ON cl.clientType.id = ct.id").getResultList();
    }
}
