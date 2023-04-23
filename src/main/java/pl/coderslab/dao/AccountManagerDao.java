package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.AccountManager;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AccountManagerDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert (AccountManager accountManager) {
        entityManager.persist(accountManager);
    }
    //update
    public void update (AccountManager accountManager) {
        entityManager.merge(accountManager);
    }

    //delete
    public void delete (AccountManager accountManager) {
        entityManager.remove(entityManager.contains(accountManager)? accountManager : entityManager.merge(accountManager));
    }

    //select one
    public AccountManager findObject (Integer id) {
        return entityManager.find(AccountManager.class, id);
    }

    //select list
    public List<AccountManager> accountManagerList() {
        List<AccountManager> acc = entityManager.createQuery("SELECT am FROM AccountManager am ORDER BY am.lastName").getResultList();
        return acc;
    }
  /*  public List<AccountManager> accountManagersToHtmlList() {
        return entityManager.createQuery("SELECT am.id as id, concat(am.firstName, ' ', am.lastName) as name, am.lastName   " +
                "FROM AccountManager am ORDER BY am.lastName").getResultList();
    }*/
}
