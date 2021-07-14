package ru.application.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.application.mvc.dao.BookDao;
import ru.application.mvc.dao.GenreDao;
import ru.application.mvc.models.Book;
import ru.application.mvc.models.Genre;

import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService{

    @Autowired
    private BookDao bookDao;
    @Autowired
    private GenreDao genreDao;


    @Override
    public Book findBookById(int id) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book findBookByName(String name) {
        return null;
    }

    @Override
    public void saveBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {

    }

    @Override
    public Genre findGenreById(int id) {
        return null;
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreDao.findAll();
    }

    @Override
    public Genre findGenreByName(String name) {
        return null;
    }

    @Override
    public void saveGenre(Genre genre) {

    }

    @Override
    public void updateGenre(Genre genre) {

    }

    @Override
    public void deleteGenre(Genre genre) {

    }
}
