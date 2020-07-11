package nancy.servlet;

import nancy.dao.BorrowRecordDAO;
import nancy.exception.BusinessException;
import nancy.model.BorrowRecord;
import nancy.util.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BorrowRecordUpdateServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/11 16:15
 * @Version 1.0
 **/
@WebServlet("/borrowRecord/update")
public class BorrowRecordUpdateServlet extends AbstrctBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        BorrowRecord br = JsonUtil.read(req.getInputStream(),BorrowRecord.class);
        int num = BorrowRecordDAO.update(br);
        if(num != 1) {
            throw new BusinessException("00009","插入图书借阅信息异常");
        }
        return null;
    }
}
