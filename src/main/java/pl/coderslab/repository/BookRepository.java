package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> readBooksByTitle(String title);
    List<Book> readBooksByCategory(Category category);
    List<Book> readBooksByCategoryId(Long id);

    @Query("Select b from Book b where b.title = :title")
    List<Book> findBooksByTitle(String title);

    @Query("Select b from Book b where b.category = :category")
    List<Book> findBookByCategory(Category category);
}
