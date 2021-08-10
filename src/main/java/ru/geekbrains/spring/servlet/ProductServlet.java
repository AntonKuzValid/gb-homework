package ru.geekbrains.spring.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.spring.dto.Product;
import ru.geekbrains.spring.service.ProductServletService;

import java.io.IOException;

@WebServlet(name = "product", urlPatterns = "/product")
@Slf4j
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Product p : new ProductServletService().getTenProducts()) {
            resp.getWriter().write(p.toString());
            resp.getWriter().write("\r\n");
        }
    }
}
