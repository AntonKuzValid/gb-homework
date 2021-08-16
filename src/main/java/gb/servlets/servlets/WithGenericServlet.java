package gb.servlets.servlets;

import jakarta.servlet.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class WithGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        List<Product> products = new CopyOnWriteArrayList<>();
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write("<table>");
        servletResponse.getWriter().write("<tr><th>ID</th><th>Title</th><th>Cost</th></tr>");
        for (int i = 0; i < 10; i++) {
            products.add(new Product());
            products.get(i).setId(i);
            products.get(i).setTitle("Продукт №" + i);
            products.get(i).setCost(BigDecimal.valueOf(10.00 + i));
            servletResponse.getWriter().write("<tr><td>" + products.get(i).getId() + "</td><td>" +  products.get(i).getTitle() + "</td><td>" + products.get(i).getCost() + "</td></tr>");
        }
        servletResponse.getWriter().write("</table>");
        servletResponse.getWriter().write("<a href=\"index.jsp\">На главную</a>");
    }
}
