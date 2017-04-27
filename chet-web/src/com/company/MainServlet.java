package com.company;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hackeru on 4/19/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {


    List<String> messages;
    int counter = 0;
    Map<String, String> users;

    @Override
    public void init() throws ServletException {
        super.init();

        messages = new ArrayList();
        users = new HashMap<>();
    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        InputStream inputStream = request.getInputStream();
        byte[] buffer = new byte[1024];
        int actuallyRead = inputStream.read(buffer);
        String body = new String(buffer, 0, actuallyRead);
        System.out.println(body);

        String result = "you dont really learn" + counter;
        counter++;
        byte[] resultBytes = result.getBytes();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(resultBytes);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String queryString = request.getQueryString();
        Map<String, String> qs = new HashMap<>();
        if (queryString == null) return;
        String[] keyValues = queryString.split("&");
        for (String keyValue : keyValues) {
            String[] keyValuePair = keyValue.split("=");
            if (keyValuePair.length != 2)
                continue;
            qs.put(keyValuePair[0], keyValuePair[1]);
        }

        String messageNow = qs.get("message");
        String positionNow = qs.get("position");
        String action = qs.get("action");
        if (action == null)
            return;
        switch (action) {
            case "sighup":
                synchronized (users) {
                    users.put(qs.get("name"), qs.get("password"));
                }
                response.getWriter().write("ok");
                break;
            case "login":
                if ((!users.get(qs.get("name")).equals(qs.get("password")))||(users.get(qs.get("name"))==null)) {
                    response.getWriter().write("notEquals");
                    return;
                } else {
                    response.getWriter().write("ok");
                }
                break;
            case "getMessage":
                StringBuilder message = new StringBuilder("");
                for (int i = Integer.parseInt(positionNow); i < messages.size(); i++) {
                    message.append(messages.get(i) + "&&&");
                }
                // message.delete(message.length()-3,message.length());
                response.getWriter().write(message.toString());
                break;
            case "addMessage":
                if (messageNow == null)
                    return;
                messages.add(messageNow);
                response.getWriter().write("OK");
                break;
        }


    }


}
