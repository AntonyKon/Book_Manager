package ru.application.mvc.services;


import org.springframework.web.multipart.MultipartFile;
import ru.application.mvc.models.Author;
import ru.application.mvc.models.Book;
import ru.application.mvc.models.Genre;

import java.util.List;

public interface ManagementService {

    Book findBookById(int id);
    List<Book> findAllBooks();
    List<Book> findBooksByName(String name);
    void saveBook(Book book, MultipartFile file);
    void updateBook(Book book, MultipartFile file);
    void deleteBook(Book book);

    Genre findGenreById(int id);
    List<Genre> findAllGenres();
    List<Genre> findGenresByName(String name);
    void saveGenre(Genre genre);
    void updateGenre(Genre genre);
    void deleteGenre(Genre genre);

    abstract Author findAuthorById(int id);
    abstract List<Author> findAuthorsByName(String name);
    abstract List<Author> findAllAuthors();
    abstract void saveAuthor(Author author, MultipartFile[] files);
    abstract void updateAuthor(Author author, MultipartFile[] files);
    abstract void deleteAuthor(Author author);

}
