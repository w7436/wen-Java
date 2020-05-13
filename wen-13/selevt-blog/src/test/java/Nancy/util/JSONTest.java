package Nancy.util;

import Nancy.modol.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName JSONTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 10:30
 * @Version 1.0
 **/
public class JSONTest {
    @Test
    public void t1() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Article article = new Article();
            article.setId(1);
            article.setUserId(1);
            article.setTitle("你好");
            article.setContent("拥抱世界");
            article.setCreateTime(new Date());


            //将对象转化为json字符串
            String s = objectMapper.writeValueAsString(article);
            System.out.println(s);

            Article a = objectMapper.readValue(s,Article.class);
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
