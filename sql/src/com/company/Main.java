package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.DoubleSummaryStatistics;

public class Main {

    public static void main(String[] args) {
        if("1"=="1") System.out.println("tembel");
        Connection connection = null;
        int sum = 0;
        boolean b;
        String orderID1,UNIT_PRICE,DISCOUNT,QUANTITY,customerId,orderId2,tempOrder="";
        Customer customer=new Customer("1", 0),tempCustomer=new Customer("", 0);
        try (Connection conn = DB.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT ORDER_ID,UNIT_PRICE,DISCOUNT,QUANTITY FROM ORDER_DETAILS ORDER BY ORDER_ID");
            try (ResultSet resultSet1 = statement.executeQuery()) {
                b=true;
                while (resultSet1.next()) {
                    if(b){tempOrder=resultSet1.getString(1);
                    b=false;}
                    orderID1 = resultSet1.getString(1);
                    UNIT_PRICE = resultSet1.getString(2);
                    DISCOUNT = resultSet1.getString(3);
                    QUANTITY = resultSet1.getString(4);

                    if (tempOrder.equals(orderID1)) {
                        sum+= Double.parseDouble(UNIT_PRICE)*Integer.parseInt(QUANTITY)*(1-Double.parseDouble(DISCOUNT));

                    }
                    else {
                        customer.price+=sum;
                        tempOrder = orderID1;
                        sum=0;
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CUSTOMER_ID,ORDER_ID FROM ORDERS ORDER BY CUSTOMER_ID");
            try (ResultSet resultSet2 = preparedStatement.executeQuery()) {
                b=true;
                while (resultSet2.next()) {
                    if(b){tempCustomer.costumerId=resultSet2.getString(1);
                        b=false;}
                    customerId = resultSet2.getString(1);
                    orderId2 = resultSet2.getString(2);
                    if(customerId==tempCustomer.costumerId){
                        if(tempOrder.equals(orderId2)){
                            tempCustomer.price+=sum;
                        }
                        if(tempCustomer.price>customer.price){
                            customer=tempCustomer;

                        }
                    }

                }
            }

            System.out.println(customer.costumerId);
//        System.out.println("enter a number");
//        String s=getInputFromUser();
//        //IN JAVA8 CONNECTION IS CLOSEABLE.
//        try (Connection conn=DB.getConnection()){
//            PreparedStatement statement=conn.prepareStatement("SELECT CUSTOMER_ID,COMPANY_NAME,CONTACT_NAME FROM CUSTOMERS WHERE CUSTOMER_ID<= ?");
//            statement.setString(1,s);
//            try(ResultSet resultSet=statement.executeQuery()){
//                while (resultSet.next()){
//                    String costumerId=resultSet.getString(1);
//                    String companyName=resultSet.getString(2);
//                    String contactName=resultSet.getString(3);
//                    System.out.println(costumerId+"."+companyName+","+contactName);
//
//                }
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection=DB.getConnection();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getInputFromUser(){
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        try {
            s=bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}

class Customer{
  String costumerId;
  int price;

    public Customer(String costumerId, int price) {
        this.costumerId = costumerId;
        this.price = price;
    }
}

//1.
//מי הלקוח שהזמין הכי הרבה מוצרים
// מותר SELECT פשוט חוץ מORDER BY
//אסור להשתמש במערך עזר
// שני פתרונות : עם ORDERBY בO)1)
//שני: בלי ORDERBY מקסימום יעילות(HASHMAP)
//2.
//