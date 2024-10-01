package com.luvina.la.dto;

import com.luvina.la.entity.Cart;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 6868189362900231672L;

    private Integer id;
    private String username;
    private String email;
    private Cart cart;
}
