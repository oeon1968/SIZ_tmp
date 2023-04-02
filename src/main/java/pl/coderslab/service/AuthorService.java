package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorDao ad;

    //zapis
    public void authorSave(Author author) {
        ad.authorSave(author);

    }
    //update
    public void authorUpdate(Author author) {
        ad.authorUpdate(author);
    }

    //wybór
    public Author authorFindById(long id) {
        return ad.authorFindById(id);
    }
    //usuwanie
    public void authorDelete(Author author) {
        authorDelete(author);
    }
}
