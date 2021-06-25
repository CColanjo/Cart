package com.ccolanjo.cart.controller;

import com.ccolanjo.cart.entity.Cart;
import com.ccolanjo.cart.entity.ShoppingList;
import com.ccolanjo.cart.repository.ShoppingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingListController {

    private ShoppingListRepository shoppingListRepository;
    private static final Logger log = LoggerFactory.getLogger(ShoppingListController.class);

    public ShoppingListController(ShoppingListRepository shoppingListRepository) {
         this.shoppingListRepository = shoppingListRepository;
    }

    @GetMapping("/shoppingList")
    List<ShoppingList> getAllItems(){
       return shoppingListRepository.findAll();
    }

    @PostMapping("/shoppingList")
    ShoppingList newItemList(@RequestBody ShoppingList itemList){
        return shoppingListRepository.save(itemList);
    }

    @DeleteMapping("/shoppingList/{id}")
    void deleteItemList(@PathVariable Long id){
        shoppingListRepository.deleteById(id);
    }

    @PatchMapping("/shoppingList/{id}")
    void updateQuantity(@RequestBody ShoppingList item, @PathVariable Long id) {
         shoppingListRepository.findById(id).map(shoppingList -> {
                shoppingList.setQuantity(item.getQuantity());
                return  shoppingListRepository.save(shoppingList);
         });
    }

    @DeleteMapping("/shoppingList")
    void deleteAllItems(){
        shoppingListRepository.deleteAll();
    }

    @PatchMapping("/shoppingList")
    void removedItemsList(@RequestBody List<Cart> cartItems){
        List<ShoppingList> listItems = shoppingListRepository.findAll();

        cartItems.forEach(cartItem -> listItems.stream()
                .filter(listItem ->  (listItem.getProductId()==cartItem.getProductId()))
                .forEach(listItem ->{
                    listItem.setRemoved(true);
                    shoppingListRepository.save(listItem);
                }));
    }
}
