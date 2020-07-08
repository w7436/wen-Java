package nancy.servlet;

import nancy.dao.DictionaryTagDAO;
import nancy.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName DictionaryTagQueryServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/6 20:06
 * @Version 1.0
 **/
@WebServlet("/dict/tag/query")
public class DictionaryTagQueryServlet extends AbstrctBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> list = DictionaryTagDAO.query(key);
        return list;
    }
}
