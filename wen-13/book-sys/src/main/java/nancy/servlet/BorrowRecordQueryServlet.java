package nancy.servlet;

import nancy.dao.BorrowRecordDAO;
import nancy.model.BorrowRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName BorrowRecordQueryServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/6 18:58
 * @Version 1.0
 **/
@WebServlet("/borrowRecord/queryById")
public class BorrowRecordQueryServlet extends AbstrctBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<BorrowRecord> list = BorrowRecordDAO.query();
        return list;
    }
}
