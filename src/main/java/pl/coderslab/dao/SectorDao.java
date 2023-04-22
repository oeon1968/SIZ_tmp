package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Sector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SectorDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert(Sector sector) {
        entityManager.persist(sector);
    }
    //update
    public void update(Sector sector) {
        entityManager.merge(sector);
    }
    //delete
    public void delete(Sector sector) {
        entityManager.remove(entityManager.contains(sector)?sector:entityManager.merge(sector));
    }
    //select one
    public Sector findObject(int id) {
        return entityManager.find(Sector.class, id);
    }
    //select list
    public List<Sector> sectorList() {
        return entityManager.createQuery("SELECT s FROM Sector s ORDER BY s.sectorName").getResultList();
    }
}
