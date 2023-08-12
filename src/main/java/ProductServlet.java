import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="productServlet",urlPatterns={"/product"})
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("product page");
        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String productName=(String)req.getParameter("productname");
        int soLuong=Integer.parseInt(req.getParameter("soluong"));
        int giaBan=Integer.parseInt(req.getParameter("giaban"));

        Product sp = new Product();
        sp.setProductName(productName);
        sp.setSoluong(soLuong);
        sp.setGiaban(giaBan);
        List<Product> list = (List<Product>) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<Product>();
        }
        list.add(sp);
        // Lưu danh sách sản phẩm vào session
        session.setAttribute("list", URLEncoder.encode(list.toString(), StandardCharsets.UTF_8.toString()));
        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }
}
