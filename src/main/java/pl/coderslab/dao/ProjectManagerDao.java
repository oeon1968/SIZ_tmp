package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.ProjectManager;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProjectManagerDao {
    @PersistenceContext
    EntityManager entityManager;

    //insert
    public void insert (ProjectManager projectManager) {
        entityManager.persist(projectManager);
    }
    //update
    public void update (ProjectManager projectManager) {
        entityManager.merge(projectManager);
    }

    //delete
    public void delete (ProjectManager projectManager) {
        entityManager.remove(entityManager.contains(projectManager)? projectManager : entityManager.merge(projectManager));
    }

    //select one
    public ProjectManager findObject (int id) {
        return entityManager.find(ProjectManager.class, id);
    }

    //select list
    public List<ProjectManager> projectManagerList() {
        return entityManager.createQuery("SELECT pm FROM ProjectManager pm ORDER BY pm.lastName").getResultList();
    }
}
