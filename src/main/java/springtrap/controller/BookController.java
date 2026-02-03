package springtrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springtrap.model.Book;
import springtrap.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET /books -> list view
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books"; // Thymeleaf template name: src/main/resources/templates/books.html
    }

    // Show add form
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // Handle add
    @PostMapping
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable long id, Model model) {
        bookService.getBookById(id).ifPresent(b -> model.addAttribute("book", b));
        return "edit-book";
    }

    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
