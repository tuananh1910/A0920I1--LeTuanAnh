package com.example.borrowbook;

import com.example.borrowbook.model.BookAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BorrowBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowBookApplication.class, args);
    }

    @Bean
    public BookAspect logger(){
        return new BookAspect();
    }

}
