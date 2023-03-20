package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Eric", "evans");
        Book book = new Book("Domain Driven Design","123456");
        author.getBooks().add(book);
        book.getAuthorSet().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book book1 = new Book("J2EE Development without EJB","123457");
        rod.getBooks().add(book1);
        book1.getAuthorSet().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books"+bookRepository.count());

    }
}
