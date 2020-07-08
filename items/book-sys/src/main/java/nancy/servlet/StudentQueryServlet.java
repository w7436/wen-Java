package nancy.servlet;

import nancy.dao.StudentDAO;
import nancy.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName StudentQueryServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/8 17:12
 * @Version 1.0
 **/

@WebServlet("/student/queryAsDict")
public class StudentQueryServlet extends AbstrctBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id = Integer.parseInt(req.getParameter("dictionaryKey"));//获取班级id
        List<Student> list = StudentDAO.query(id);
        return list;
    }
}
