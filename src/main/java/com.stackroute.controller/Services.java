package com.stackroute.controller;

import com.stackroute.DB.CrudOperation;
import org.springframework.stereotype.Service;

@Service
public class Services {
    User user =new User();
    public String message(User user)
    {

        String userName=user.getUsername();
        String password=user.getPassword();
        CrudOperation crudOperation=new CrudOperation();
      crudOperation.insertCustomer(userName,password);
        return "Welcome "+user.getUsername()+" to stackroute";
    }


}
