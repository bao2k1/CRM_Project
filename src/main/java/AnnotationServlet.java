import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="annotationServlet",urlPatterns={"/demo"})
public class AnnotationServlet extends HttpServlet {
  //GET: Mac dinh khi goi duong dan, Khong bao mat tham so
//    cach truyen: ?thamso=giatri
//    co gioi han ve tham so
//    Post: truyen ngam tham so, se duoc bao mat, truyen qua code va the form HTML
// ko co gioi han so luong tham so

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =req.getParameter("username");
        String password =req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        writer.println("demo Annotation");
        writer.println("hello " +username+" -pass: "+password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Do Post");
    }
}
