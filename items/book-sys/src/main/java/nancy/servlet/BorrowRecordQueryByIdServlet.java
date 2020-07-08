package nancy.servlet;

import nancy.dao.BorrowRecordDAO;
import nancy.model.BorrowRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BorrowRecordQueryByIdServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/8 17:40
 * @Version 1.0
 **/

@WebServlet("/borrowRecord/queryById")
public class BorrowRecordQueryByIdServlet extends AbstrctBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        BorrowRecord borrowRecord = BorrowRecordDAO.queryById(id);
        return borrowRecord;
    }
}
