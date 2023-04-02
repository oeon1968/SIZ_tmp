package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

import java.util.List;


@Service


@RequiredArgsConstructor
public class PublisherService {

    private final PublisherDao publisherDao;
    //    zapis encji

    public void save(Publisher book) {
        publisherDao.save(book);
    }

    //    edycja encji
    public void update(Publisher book) {
        publisherDao.update(book);
    }

//    pobieranie po id

    public Publisher findById(long id) {
        return publisherDao.findById(id);

    }

    //    usuwanie po id
    public void delete(Publisher book) {
        publisherDao.delete(book);
    }

    public List<Publisher> all() {
        return publisherDao.publishers();
    }
}
