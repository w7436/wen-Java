package Nancy.servlet;

import Nancy.dao.ArticleDAO;
import Nancy.modol.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName ArticleListServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 14:35
 * @Version 1.0
 **/
@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {


    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Article> articles = ArticleDAO.list();
        return  articles;
    }

//    //测试数据
//    public static List<Article> testDate() {
//        List<Article> list = new ArrayList<>();
//        Article a1 = new Article();
//        a1.setId(1);
//        a1.setUserId(1);
//        a1.setTitle("你好");
//        a1.setContent("拥抱世界");
//        a1.setCreateTime(new Date());
//        list.add(a1);
//        return list;
//    }
}
