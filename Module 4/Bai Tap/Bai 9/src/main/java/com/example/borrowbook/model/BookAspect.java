package com.example.borrowbook.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BookAspect {
    //display list book log
    @Before(value = "execution(* com.example.borrowbook.service.impl.BookServiceImpl.findAll(..))")
    public void getAllBookBefore(JoinPoint joinPoint){
        System.out.println("Before call method : " + joinPoint.toString());
        System.out.println("Before , Display List Book");
    }

    @After(value = "execution(* com.example.borrowbook.service.impl.BookServiceImpl.findAll(..))")
    public void getAllBookAfter(JoinPoint joinPoint){
        System.out.println("After call method : " + joinPoint.toString());
        System.out.println("After , Display List Book Success");
    }


    // borrow book log
    @Before(value="execution(* com.example.borrowbook.service.impl.BookServiceImpl.borrowBook(..))")
    public void getBorrowBookBefore(JoinPoint joinPoint){
        System.out.println("Before call method get :"+ joinPoint.toString());
        System.out.println("Before method borrow book");
    }

    @After(value="execution(* com.example.borrowbook.service.impl.BookServiceImpl.borrowBook(..))")
    public void BorrowSuccessAfter(JoinPoint joinPoint){
        System.out.println("After call method get :"+ joinPoint.toString());
        System.out.println("After borrow book success");
    }

    @After(value="execution(* com.example.borrowbook.service.impl.BookServiceImpl.decreaseAmount(..))")
    public void DecreaseBookAfter(JoinPoint joinPoint){
        System.out.println("After call method get :"+ joinPoint.toString());
        System.out.println("After borrow book success : decrease Amount`");
    }




    //give book back log
    @Before(value="execution(* com.example.borrowbook.service.impl.BookServiceImpl.giveBookBack(..))")
    public void GiveBookBackBefore(JoinPoint joinPoint){
        System.out.println("Before call method get :"+ joinPoint.toString());
        System.out.println("Before method give book back");
    }

    @After(value="execution(* com.example.borrowbook.service.impl.BookServiceImpl.giveBookBack(..))")
    public void GiveBackSuccessAfter(JoinPoint joinPoint){
        System.out.println("After call method get :"+ joinPoint.toString());
        System.out.println("After give book back success");
    }

    @After(value="execution(* com.example.borrowbook.service.impl.BookServiceImpl.increaseAmount(..))")
    public void IncreaseBookAfter(JoinPoint joinPoint){
        System.out.println("After call method get :"+ joinPoint.toString());
        System.out.println("After give book back success : increase amount`");
    }


}
