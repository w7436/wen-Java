package nancy.servlet;

import nancy.dao.BorrowRecordDAO;
import nancy.model.BorrowRecord;
import nancy.model.Page;
import nancy.util.Util;

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
@WebServlet("/borrowRecord/query")
public class BorrowRecordQueryServlet extends AbstrctBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Page pg = Util.parse(req);
        List<BorrowRecord> list = BorrowRecordDAO.query(pg);
        return list;
    }
}
