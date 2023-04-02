package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Author;


public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private pl.coderslab.service.AuthorService authorService;

    @Override
    public Author convert(String s) {
        return authorService.authorFindById(Long.parseLong(s));
    }
}