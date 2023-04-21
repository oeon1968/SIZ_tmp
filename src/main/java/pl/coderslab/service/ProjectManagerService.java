package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.ProjectManagerDao;
import pl.coderslab.model.ProjectManager;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectManagerService {
    private final ProjectManagerDao pm;
    public void insert (ProjectManager projectManager) {
        pm.insert(projectManager);
    }

    public void update (ProjectManager projectManager) {
        pm.update(projectManager);
    }

    public void delete(ProjectManager projectManager) {
        pm.delete(projectManager);
    }

    public List<ProjectManager> getProjectManagerList() {
        return pm.projectManagerList();
    }

    public ProjectManager getProjectManager(int id) {
        return pm.findObject(id);
    }
}
