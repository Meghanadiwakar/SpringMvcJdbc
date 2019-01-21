package com.stackroute.DB;

import java.sql.*;

public class Crudoperation {
    private Connection con;
    public void displayData() {
        try{
            System.out.println("havvha");
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login","meghanad","meghanad");
            //create statement object
            System.out.println("got connected");

            Statement stmt=con.createStatement();
            //execute query

            ResultSet rs=stmt.executeQuery("select * from loginandpassword");
            //process result
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                System.out.println("finally");
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayCustomerByName(String name) {

        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login","meghanad","meghanad");
            //create statement object
            System.out.println("got connected");


            PreparedStatement stmt=con.prepareStatement("Select * from loginandpassword where userName=?");
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();
            //execute query
            //  ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println("Username= "+rs.getString(1)+"  "+rs.getString(2));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertCustomer(String userName, String passWord) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login","meghanad","meghanad");
            System.out.println("got connected");
            PreparedStatement statement=con.prepareStatement("insert into loginandpassword values(?,?)");
            statement.setString(1,userName);
            statement.setString(2,passWord);
            statement.execute();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


    }
}


