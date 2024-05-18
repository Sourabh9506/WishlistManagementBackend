package com.productWishlist.CustomException;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }
}
