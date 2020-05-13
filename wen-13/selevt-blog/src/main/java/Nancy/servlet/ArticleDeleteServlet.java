package Nancy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ArticleDeleteServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/13 19:57
 * @Version 1.0
 **/
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String idsString = req.getParameter("ids");
        int[] ids = paraIds(idsString);
        //将ids传回数据库做删除操作
        return null;
    }
    public static int[] paraIds(String idsString){
        String[] idsArray = idsString.split(",");
        int[] ids = new int[idsArray.length];
        for(int i = 0;i < idsArray.length;i++){
            ids[i] = Integer.parseInt(idsArray[i]);
        }
        return ids;
    }
}
