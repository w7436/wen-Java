package Nancy.servlet;

import Nancy.dao.ArticleDAO;
import Nancy.exception.BusinessException;
import Nancy.modol.Article;
import Nancy.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @ClassName ArticleAddServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 15:55
 * @Version 1.0
 **/

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {


    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is = req.getInputStream();

        //
        Article article = JSONUtil.deserialize(is,Article.class);
        //模拟数据库插入数据
        System.out.println(" 0------- -----"+article);
        int num = ArticleDAO.insert(article);
        if(num != 1){
            throw new BusinessException("001","文章插入异常");
        }
        return null;
    }
}
