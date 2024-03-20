package com.example.doan.controller;

import com.example.doan.entity.Product;
import com.example.doan.repository.IProductRepository;
import com.example.doan.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private IProductRepository iProductRepository;

    @GetMapping
    public String home(Model model,@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        List<Product> products;
        if(keyword != null && !keyword.trim().isEmpty()){
            products=iProductRepository.searchProductHome(keyword.trim());
        }
        else{
            products=iProductRepository.findAll();
        }
        model.addAttribute("listProduct", products);

        return "home/index";
    }

    @GetMapping("/filter")
    public String filterProducts(Model model,String key){
        List<Product> products;
        key="Laptops";
        products= iProductRepository.filterProducts(key);
        model.addAttribute("listProduct",products);

        return "home/index";


    }

    @GetMapping("/filter2")
    public String filterProducts2(Model model,String key){
        List<Product> products;
        key="Smart Phone";
        products= iProductRepository.filterProducts(key);
        model.addAttribute("listProduct",products);

        return "home/index";


    }

    @GetMapping("/filter3")
    public String filterProducts3(Model model,String key){
        List<Product> products;
        key="Cameras";
        products= iProductRepository.filterProducts(key);
        model.addAttribute("listProduct",products);

        return "home/index";


    }

    @GetMapping("/filter4")
    public String filterProducts4(Model model,String key){
        List<Product> products;
        key="Accessories";
        products= iProductRepository.filterProducts(key);
        model.addAttribute("listProduct",products);

        return "home/index";


    }

}
