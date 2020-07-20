package frank.servlet;

import frank.dao.BorrowRecordDAO;
import frank.model.BorrowRecord;
import frank.model.Page;
import frank.util.Util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/borrowRecord/query")
public class BorrowRecordQueryServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //url中的请求数据，通过getParameter获取
        Page p = Util.parse(req);
        List<BorrowRecord> records = BorrowRecordDAO.query(p);
        return records;
    }
}
