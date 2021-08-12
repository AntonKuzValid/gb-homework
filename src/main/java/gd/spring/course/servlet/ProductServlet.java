package gd.spring.course.servlet;

import gd.spring.course.model.Product;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Сервлет обрабатывает запрос вида /product?amount=7
@WebServlet(name = "productServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String amountOfProducts = req.getParameter("amount");

        if (amountOfProducts == null) {
            resp.sendError(400, "Количество продуктов не задано"); // ошибка 400 Bad Request
            return;
        }

        try {
            Integer.parseInt(amountOfProducts);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Количество продуктов должно быть целым числом"); // ошибка 400 Bad Request
            return;
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Список продуктов:</h1>");

        final int amountInt = Integer.parseInt(amountOfProducts);
        for (int i = 0; i < amountInt; i++) {
            final Product product = new Product(i, "Продукт_" + i, 1.0 + i);
            resp.getWriter().println("<h4>" + product.getId() + ": " + product.getTitle() + " (цена $" + product.getCost() + ")" + "</h4>");
        }

        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}
