package com.springgb.gbwebservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ListOfProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String getNew = req.getParameter("getNew");

        if (getNew == null) {
            resp.sendError(400, "request not correct !");
            return;
        }
//        ArrayList<Product> productArrayList = new ArrayList<>();
        final int getNewInt = Integer.parseInt(getNew);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        for (int i = 0; i < getNewInt; i++) {
            Product newProduct = new Product("product" + i);
//            productArrayList.add(newProduct);
            String response = "id: " + newProduct.getId() + " name: " + newProduct.getTitle() + " cost: " + newProduct.getCost() + "; ";
            resp.getWriter().write("<div>" + response + "</div>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Attention access denied !!!");
    }
}
