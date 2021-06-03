package com.example.borrowbook.controller;

import com.example.borrowbook.exception.BorrowBookException;
import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.RentBook;
import com.example.borrowbook.service.BookService;
import com.example.borrowbook.service.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class bookController {
    @Autowired
    BookService bookService;

    @Autowired
    RentBookService rentBookService;

    @GetMapping("/")
    public ModelAndView getHome(Model model,
                                @RequestParam(name = "page", required = false, defaultValue = "0")Integer page,
                                @RequestParam(name = "size", required = false, defaultValue = "5")Integer size,
                                @RequestParam(name = "sort", required = false, defaultValue = "ASC")String sort){

            Sort sortable = null;
            if (sort.equals("ASC")){
                sortable = Sort.by("id").ascending();
            }
            if (sort.equals("DESC")){
                sortable= Sort.by("id").descending();
            }
            assert sortable != null;
            Pageable pageable = PageRequest.of(page,size,sortable);

            return new ModelAndView("book/list", "books", bookService.findAll(pageable));
    }

    @GetMapping("/borrow-book-form/{id}")
    public ModelAndView borrowBookForm(@PathVariable(value = "id")Long id){
        return new ModelAndView("rentBook/borrow","book",bookService.findById(id));
    }

    @PostMapping("/borrow")
    public ModelAndView borrowBook(Book book) throws BorrowBookException {


        Long idBorrow = bookService.borrowBook(book);


        return new ModelAndView("rentBook/borrowSuccess","idBorrow",idBorrow);

    }

    @GetMapping("/give-book-back-form")
    public ModelAndView giveBookBackForm(){
        return new ModelAndView("rentBook/giveBookBack","rentBook", new RentBook());
    }

    @PostMapping("/give-book-back")
    public ModelAndView giveBookBack(@ModelAttribute("rentBook") RentBook rentBook){
        if (!bookService.giveBookBack(rentBook)){
            return new ModelAndView("rentBook/giveBookBack","message","Rental Dd Not Found");
        }
        return new ModelAndView("rentBook/giveBookBackSuccess");
    }

    @ExceptionHandler(BorrowBookException.class)
    public ModelAndView showError(){
        return new ModelAndView("rentBook/error");
    }
}
