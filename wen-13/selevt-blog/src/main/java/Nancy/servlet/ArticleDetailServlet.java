package Nancy.servlet;

import Nancy.exception.ClientException;
import Nancy.modol.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @ClassName ArticleDetailServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 16:36
 * @Version 1.0
 **/
@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求中的文章ID
        String id = req.getParameter("id");
        Integer articleId;
        try {
           articleId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new ClientException("001","请求参数错误：[id="+id+"]");
        }
//        if(articleId == 1){
//            int i = 10/0;
//        }
        return testData();//测试代码，根据文章id查询文章
    }

    public static Article testData(){
        Article a1 = new Article();
        a1.setId(1);
        a1.setUserId(1);
        a1.setTitle("你好");
        a1.setContent("拥抱世界");
        a1.setCreateTime(new Date());
        return a1;
    }
}
