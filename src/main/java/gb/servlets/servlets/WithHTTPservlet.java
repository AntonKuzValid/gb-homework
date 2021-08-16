package gb.servlets.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "servletHTTP", value = "/httpproducts")
public class WithHTTPservlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Product> products = new CopyOnWriteArrayList<>();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<table>");
        response.getWriter().write("<tr><th>ID</th><th>Title</th><th>Cost</th></tr>");
        for (int i = 0; i < 10; i++) {
            products.add(new Product());
            products.get(i).setId(i);
            products.get(i).setTitle("Продукт №" + i);
            products.get(i).setCost(BigDecimal.valueOf(10.00 + i));
            response.getWriter().write("<tr><td>" + products.get(i).getId() + "</td><td>" +  products.get(i).getTitle() + "</td><td>" + products.get(i).getCost() + "</td></tr>");
        }
        response.getWriter().write("</table>");
        response.getWriter().write("<a href=\"index.jsp\">На главную</a>");
    }
}