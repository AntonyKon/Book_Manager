package ru.application.mvc.services;


import ru.application.mvc.models.Book;
import ru.application.mvc.models.Genre;

import java.util.List;

public interface ManagementService {

    Book findBookById(int id);
    List<Book> findAllBooks();
    Book findBookByName(String name);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);

    Genre findGenreById(int id);
    List<Genre> findAllGenres();
    Genre findGenreByName(String name);
    void saveGenre(Genre genre);
    void updateGenre(Genre genre);
    void deleteGenre(Genre genre);

}
