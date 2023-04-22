package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.SectorDao;
import pl.coderslab.model.Sector;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService {
    private final SectorDao sectorDao;

    public void insert(Sector sector) {
        sectorDao.insert(sector);
    }

    public void update(Sector sector) {
        sectorDao.update(sector);
    }

    public void delete(Sector sector) {
        sectorDao.delete(sector);
    }

    public Sector getSector(int id) {
        return sectorDao.findObject(id);
    }

    public List<Sector> getSectorList() {
        return sectorDao.sectorList();
    }
}
