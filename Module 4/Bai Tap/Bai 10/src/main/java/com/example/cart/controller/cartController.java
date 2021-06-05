package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class cartController {
    @Autowired
    ProductService productService;

    @GetMapping("/add-to-card/{id}")
    public String addToCart(
            Model model,@PathVariable("id")int id,
            HttpSession session){
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>)session.getAttribute("myCartItems");
        if (cartItems==null){
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (product !=null){
            if (cartItems.containsKey(product.getId())){
                Cart item = cartItems.get(product.getId());
                item.setProduct(product);
                item.setQuantity(item.getQuantity()+1);
                cartItems.put(product.getId(), item);
            }else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(product.getId(),item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());

        model.addAttribute("message","Added To Cart");
        return "cart/list";
    }

    public double totalPrice(HashMap<Integer, Cart> cartItems){
        int count =0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()){
            count += list.getValue().getProduct().getPrice()*list.getValue().getQuantity();
        }
        return count;
    }

    @GetMapping("/carts")
    public ModelAndView getCartList(
            HttpSession session
    ){
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);

        return new ModelAndView("cart/list");
    }
//
//    @GetMapping("/remove/{productId}")
//    public ModelAndView viewRemove(
//            @PathVariable("productId")int productId,
//            HttpSession session){
//        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
//        if (cartItems == null) {
//            cartItems = new HashMap<>();
//        }
//        if (cartItems.containsKey(productId)) {
//            cartItems.remove(productId);
//        }
//        session.setAttribute("myCartItems", cartItems);
//        session.setAttribute("myCartTotal", totalPrice(cartItems));
//        session.setAttribute("myCartNum", cartItems.size());
//        return new ModelAndView("cart/list");
//    }

}
