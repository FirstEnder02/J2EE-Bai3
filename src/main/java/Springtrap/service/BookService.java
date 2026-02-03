package springtrap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springtrap.model.Book;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public Optional<Book> getBookById(long id) {
        return books.stream()
                    .filter(b -> b.getId() != null && b.getId().equals(id))
                    .findFirst();
    }

    public void updateBook(Book updatedBook) {
        books.stream()
             .filter(b -> b.getId() != null && b.getId().equals(updatedBook.getId()))
             .findFirst()
             .ifPresent(b -> {
                 b.setTitle(updatedBook.getTitle());
                 b.setAuthor(updatedBook.getAuthor());
             });
    }

    public void deleteBook(long id) {
        books.removeIf(b -> b.getId() != null && b.getId().equals(id));
    }
}
