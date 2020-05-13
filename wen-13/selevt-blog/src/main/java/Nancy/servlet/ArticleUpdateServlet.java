package Nancy.servlet;

import Nancy.modol.Article;
import Nancy.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @ClassName ArticleUpdateServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/13 19:50
 * @Version 1.0
 **/
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //文章修改包括：title，content,id
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is,Article.class);
        System.out.println("--------"+article);
        return  null;

    }
}
