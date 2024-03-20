package com.example.doan.controller;

import com.example.doan.entity.CartIterm;
import com.example.doan.entity.Product;
import com.example.doan.services.ProductService;
import com.example.doan.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("view")
    public String viewCart (Model model){
        model.addAttribute("all_items_in_shoppingCart",shoppingCartService.getAllitem());
        model.addAttribute("total_amount",shoppingCartService.getAmount());
        return "checkout";
    }
    @GetMapping("count")
    public String Count (Model model)
    {
        model.addAttribute("count",shoppingCartService.getCount());
        return "layout";
    }
    @GetMapping("add/{id}")
    public String addItem (@PathVariable("id") Long id)
    {
        Product product = productService.getProductById(id);
        if (product != null)
        {
            CartIterm item= new CartIterm();
            item.setProductid(product.getId());
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            item.setImg(product.getImage());
            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return  "redirect:/shopping-cart/view";
    }
    @GetMapping("clear")
    public  String clearCart()
    {
        shoppingCartService.clear();
        return  "redirect:/shopping-cart/view";
    }
    @GetMapping("remove/{id}")
    public String removeItem (@PathVariable("id") Integer id)
    {
        shoppingCartService.remove(id);
        return  "redirect:/shopping-cart/view";
    }
    @PostMapping("update")
    public String updateItem (@RequestParam("productId") Integer productId , @RequestParam("quantity") Integer quantity)
    {
        shoppingCartService.update(productId,quantity);
        return  "redirect:/shopping-cart/view";
    }


}
