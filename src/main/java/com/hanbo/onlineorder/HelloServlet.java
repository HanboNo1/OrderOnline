package com.hanbo.onlineorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanbo.onlineorder.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// 1.receive request
// 2.Parse URL -> Which servlet to use
// 3.parse http method -> which method to call
// 4.HelloServlet.doGet()/ doPost()

@WebServlet(name = "helloServlet", value = "/hello-servlet") // 让tomcat知道有servlet，和map关系
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html"); //  data format
//
//        // read
//        String customer = request.getParameter("username");
//        // handler object that can print data into response body
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + "Hello " + customer + "</h1>");
//        out.println("</body></html>");
        response.setContentType("application/json");
        // String customer = request.getParameter("username");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setEmail("sun@qq.com");
        out.println(mapper.writeValueAsString(customer));
//        JSONObject object = new JSONObject();
//        object.put("email", "xxx@qq.com");
//        object.put("name", "customer");
//        out.println(object);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject obj = new JSONObject(IOUtils.toString(request.getReader()));
        String email = obj.getString("email");
        System.out.println(email);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("status", "OK");
        out.println(responseJSON);
    }
    public void destroy() {
    }
}