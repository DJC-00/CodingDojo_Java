package com.person.project.mvc.controllers;

import java.util.ArrayList;

import com.person.project.mvc.models.Book;
import com.person.project.mvc.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book/{bookID}")
    public String OneBook(Model pagaData, @PathVariable("bookID") Long bookID) {
        Book myBook = bookService.findBook(bookID);
        pagaData.addAttribute("check", "okay");
        pagaData.addAttribute("bookID", bookID);
        pagaData.addAttribute("bookTitle", myBook.getTitle());
        pagaData.addAttribute("bookDesc", myBook.getDescription());
        pagaData.addAttribute("bookLang", myBook.getLanguage());
        pagaData.addAttribute("bookPageCnt", myBook.getNumberOfPages());
        System.out.println(bookID);
        


        
        System.out.println(myBook.getTitle());
        return "bookView.jsp";
    }

    @GetMapping("/books")
    public String AllBooks(Model pagaData) {
        ArrayList<Book> bookArray = (ArrayList<Book>) bookService.allBooks();
        pagaData.addAttribute("allBooks", bookArray);
        System.out.println(bookArray);
        return "allBooks.jsp";
    }
}
