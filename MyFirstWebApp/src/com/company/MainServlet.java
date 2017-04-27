package com.company;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hackeru on 4/19/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    int counter =0;

    @Override
    public void init() throws ServletException {
        super.init();
    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        InputStream inputStream = request.getInputStream();
        byte[] buffer = new byte[1024];
        int actuallyRead = inputStream.read(buffer);
        String body = new String(buffer, 0, actuallyRead);
        System.out.println(body);

        String result = "you dont really learn"+counter;
        counter++;
        byte[] resultBytes = result.getBytes();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(resultBytes);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String queryString = request.getQueryString();
        Map<String, String> qs = new HashMap<>();
        if(queryString != null){
            String[] keyValues = queryString.split("&");
            for(String keyValue : keyValues){
                String[] keyValuePair = keyValue.split("=");
                if(keyValuePair.length != 2)
                    continue;
                qs.put(keyValuePair[0], keyValuePair[1]);
            }
        }

        String action = qs.get("action");
        if(action == null)
            return;
        String operand1String = qs.get("operand1");
        String operand2String = qs.get("operand2");
        if(operand1String == null || operand2String == null)
            return;
        int operand1 = 0;
        int operand2 = 0;
        try{
            operand1 = Integer.valueOf(operand1String);
            operand2 = Integer.valueOf(operand2String);
        }catch (Exception ex){
            return;
        }
        String result = "";
        switch (action){
            case "add":
                result = String.valueOf(operand1 + operand2);
                break;
            case "subtract":
                result = String.valueOf(operand1 - operand2);
                break;
            case "multiply":
                result = String.valueOf(operand1 * operand2);
                break;
            case "divide":
                if(operand2 == 0){
                    response.getWriter().write("division by zero error");
                    return;
                }
                result = String.valueOf(operand1 / operand2);
                break;
            default:
                return;
        }
        response.getWriter().write(result);
    }

}
