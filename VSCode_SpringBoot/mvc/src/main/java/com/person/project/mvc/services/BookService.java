package com.person.project.mvc.services;

import java.util.List;
import java.util.Optional;
import com.person.project.mvc.models.Book;
import com.person.project.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBookOptional(Long id, String title, String desc, String lang, Integer numOfPages){
        Book BookFromDB = findBook(id);
        Book updatedBook = new Book();
        if (BookFromDB == null){
            return null;
        }
        updatedBook.setID(id);
        if (title == null){
            updatedBook.setTitle(BookFromDB.getTitle());
            
        } else{
            updatedBook.setTitle(title);
        }
        if (desc == null){
            updatedBook.setDescription(BookFromDB.getDescription());
        } else{
            updatedBook.setDescription(desc);
        }
        
        if (lang == null){
            updatedBook.setLanguage(BookFromDB.getLanguage());
            
        } else{
            updatedBook.setLanguage(lang);
        }
        if (numOfPages == null){
            updatedBook.setNumberOfPages(BookFromDB.getNumberOfPages());
            
        } else{
            updatedBook.setNumberOfPages(numOfPages);
        }
        return updatedBook;
    }


    // if (title == ""){
    //     updatedBook.setTitle(BookFromDB.getTitle());
        
    // } else{
    //     updatedBook.setTitle(title);
    // }
    // if (desc.length() == 0){
    //     updatedBook.setDescription(BookFromDB.getDescription());
    // } else{
    //     updatedBook.setDescription(desc);
    // } 
    
    // if (lang.length() == 0){
    //     updatedBook.setLanguage(BookFromDB.getLanguage());
        
    // } else{
    //     updatedBook.setLanguage(lang);
    // }

    // if (numOfPages == 0){
    //     updatedBook.setNumberOfPages(BookFromDB.getNumberOfPages());
        
    // } else{
    //     updatedBook.setNumberOfPages(numOfPages);
    // }




    public Book updateBook(Book updatedBook){
        Book BookFromDB = findBook(updatedBook.getID());
        if (BookFromDB == null){
            return null;
        }

        BookFromDB.setTitle(updatedBook.getTitle());
        BookFromDB.setDescription(updatedBook.getDescription());
        BookFromDB.setLanguage(updatedBook.getLanguage());
        BookFromDB.setNumberOfPages(updatedBook.getNumberOfPages());
        
        return bookRepository.save(BookFromDB);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}