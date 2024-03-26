package com.jspiders.springcore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
private int id;
private String userName;
private String email;
private String password;
//bcoz to create objects using all args constructor we are using allargsconstructor annotation
//and string uses setters for object creation we need no args constructor so we are using noargsconstructor annotation 
}
