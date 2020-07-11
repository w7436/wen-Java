package nancy.servlet;

import nancy.dao.BorrowRecordDAO;
import nancy.exception.BusinessException;
import nancy.model.BorrowRecord;
import nancy.util.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BorrowRecordDeleteServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/11 16:14
 * @Version 1.0
 **/
@WebServlet("/borrowRecord/delete")
public class BorrowRecordDeleteServlet extends AbstrctBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids = req.getParameterValues("ids");//ids=4&ids=5....
        int num = BorrowRecordDAO.delete(ids);
        if(num != ids.length) {
            throw new BusinessException("00005","删除图书借阅信息异常");
        }
        return null;
    }
}
