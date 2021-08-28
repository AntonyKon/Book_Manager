package ru.application.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.application.mvc.dao.GenericDao;
import ru.application.mvc.models.Author;
import ru.application.mvc.models.Book;
import ru.application.mvc.models.Genre;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ManagementServiceImpl implements ManagementService{

    @Autowired
    private GenericDao<Book> bookDao;
    @Autowired
    private GenericDao<Genre> genreDao;
    @Autowired
    private GenericDao<Author> authorDao;

    @Resource(mappedName = "fileStorage/basePath")
    private String path;

    @Override
    public Book findBookById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findBooksByName(String name) {
        return bookDao.findByName(name);
    }

    @Override
    public void saveBook(Book book, MultipartFile file) {
        book.setPhoto(file.getOriginalFilename());
        bookDao.save(book);
        savePhotos(new MultipartFile[] {file});
    }

    @Override
    public void updateBook(Book book, MultipartFile file) {
        deletePhotos(new String[] {book.getPhoto()});
        book.setPhoto(file.getOriginalFilename());
        bookDao.update(book);
        savePhotos(new MultipartFile[] {file});
    }

    @Override
    public void deleteBook(Book book) {
        deletePhotos(new String[] {book.getPhoto()});
        bookDao.delete(book);
    }

    @Override
    public Genre findGenreById(int id) {
        return genreDao.findById(id);
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreDao.findAll();
    }

    @Override
    public List<Genre> findGenresByName(String name) {
        return genreDao.findByName(name);
    }

    @Override
    public void saveGenre(Genre genre) {
        genreDao.save(genre);
    }

    @Override
    public void updateGenre(Genre genre) {
        genreDao.update(genre);
    }

    @Override
    public void deleteGenre(Genre genre) {
        genreDao.delete(genre);
    }

    @Override
    public Author findAuthorById(int id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> findAuthorsByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public void saveAuthor(Author author, MultipartFile[] files) {
        List<String> fileNames = Arrays.stream(files).map(MultipartFile::getOriginalFilename).collect(Collectors.toList());
        savePhotos(files);
        author.setPhotos(fileNames);
        authorDao.save(author);
    }

    @Override
    public void updateAuthor(Author author, MultipartFile[] files) {
        List<String> fileNames = Arrays.stream(files).map(MultipartFile::getOriginalFilename).collect(Collectors.toList());
        deletePhotos(author.getPhotos().toArray(new String[0]));
        author.setPhotos(fileNames);
        authorDao.update(author);
        savePhotos(files);
    }

    @Override
    public void deleteAuthor(Author author) {
        deletePhotos(author.getPhotos().toArray(new String[0]));
        authorDao.delete(author);
    }

    public void savePhotos(MultipartFile[] files) {
        for (MultipartFile file: files) {
            File defaultFile = new File(path, Objects.requireNonNull(file.getOriginalFilename()));
            try {
                defaultFile.createNewFile();
                file.transferTo(defaultFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletePhotos(String[] fileNames) {
        for (String fileName: fileNames) {
            File file = new File(path, fileName);
            file.delete();
        }
    }

    public String getPath() {
        return path;
    }
}
