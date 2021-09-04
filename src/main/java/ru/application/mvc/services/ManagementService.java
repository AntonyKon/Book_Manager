package ru.application.mvc.services;


import org.springframework.web.multipart.MultipartFile;
import ru.application.mvc.models.Author;
import ru.application.mvc.models.Book;
import ru.application.mvc.models.Country;
import ru.application.mvc.models.Genre;

import java.util.List;

public interface ManagementService {

    Book findBookById(int id);
    List<Book> findAllBooks();
    List<Book> findBooksByName(String name);
    int saveBook(Book book, MultipartFile file);
    void updateBook(Book book, MultipartFile file);
    void deleteBook(Book book);

    Genre findGenreById(int id);
    List<Genre> findAllGenres();
    List<Genre> findGenresByName(String name);
    int saveGenre(Genre genre);
    void updateGenre(Genre genre);
    void deleteGenre(Genre genre);

    Author findAuthorById(int id);
    List<Author> findAuthorsByName(String name);
    List<Author> findAllAuthors();
    int saveAuthor(Author author, MultipartFile[] files);
    void updateAuthor(Author author, MultipartFile[] files);
    void deleteAuthor(Author author);

    List<Country> findAllCountries();
}
