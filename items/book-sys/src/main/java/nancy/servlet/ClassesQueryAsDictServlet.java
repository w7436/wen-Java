package nancy.servlet;

import nancy.dao.ClassesDAO;
import nancy.model.Classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName ClassesQueryAsDictServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/6 20:55
 * @Version 1.0
 **/
@WebServlet("/classes/queryAsDict")
public class ClassesQueryAsDictServlet extends AbstrctBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Classes> list = ClassesDAO.queryList();
        return list;

    }
}
