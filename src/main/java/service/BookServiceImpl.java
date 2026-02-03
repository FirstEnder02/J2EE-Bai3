package service;

import model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final List<Book> books = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @Override
    public void addBook(Book book) {
        if (book.getId() == 0) {
            book.setId(nextId++);
        }
        books.add(book);
    }

    @Override
    public void updateBook(int id, Book updatedBook) {
        Book existing = getBookById(id);
        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());
    }

    @Override
    public void deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (!removed) {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}