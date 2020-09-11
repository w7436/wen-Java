package nancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName PringHtml
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/15 11:03
 * @Version 1.0
 **/
public class PringHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>\r\n");
        writer.write("   <html lang=\"en\">\r\n");
        writer.write("   <head>\r\n");
        writer.write("        <meta charset=\"UTF-8\">\r\n");
        writer.write("        <title>Title</title>\r\n");
        writer.write("   </head>\r\n");
        writer.write(" <body>\r\n");
        writer.write(" 这是html页面数据\r\n");
        writer.write(" </body>\r\n");
        writer.write("</html>\r\n");
        writer.write("\r\n");






    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
