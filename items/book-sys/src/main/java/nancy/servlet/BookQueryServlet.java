package nancy.servlet;

import nancy.dao.BookDAO;
import nancy.model.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName BookQueryServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/8 16:33
 * @Version 1.0
 **/

@WebServlet("/book/queryAsDict2")
public class BookQueryServlet extends AbstrctBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Book> list = BookDAO.queryAsDict();
        return list;
    }
}
