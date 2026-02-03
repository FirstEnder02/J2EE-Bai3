package springtrap.service;

import java.util.List;

import springtrap.model.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void addBook(Book book);
    void updateBook(int id, Book updatedBook);
    void deleteBook(int id);
}