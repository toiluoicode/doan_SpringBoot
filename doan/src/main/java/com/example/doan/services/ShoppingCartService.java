package com.example.doan.services;

import com.example.doan.entity.CartIterm;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {
    Map <Long, CartIterm> shoppingCart =new HashMap<>();
    public void add (CartIterm newIterm)
    {
        CartIterm cartIterm =shoppingCart.get(newIterm.getProductid());
        if(cartIterm == null)
        {
            shoppingCart.put(newIterm.getProductid(),newIterm);
        }
        else
        {
            cartIterm.setQuantity(cartIterm.getQuantity()+1);
        }
    }
    public void remove (long id) {
        shoppingCart.remove(id);
    }
    public CartIterm update (long productID, int quantity)
    {
        CartIterm cartIterm =shoppingCart.get(productID);
        cartIterm.setQuantity(quantity);
        return cartIterm;
    }
    public void clear() {shoppingCart.clear();}

    public double getAmount () {
        return shoppingCart.values().stream().mapToDouble(item ->item.getQuantity()*item.getPrice()).sum();
    }
    public int getCount(){return shoppingCart.values().size();}
    public Collection<CartIterm> getAllitem (){return shoppingCart.values();}

}
