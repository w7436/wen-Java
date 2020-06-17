package nancy.controller;

import nancy.service.ArrticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/17 21:02
 * @Version 1.0
 **/

@RestController
public class ArticleController {
    @Autowired
    private ArrticleService arrticleService;

//    @RequestMapping("/query/{id}")
//    public Object queryId(@PathVariable("id") Integer id){
//        Article article = arrticleService.queryId(id);
//
//    }

}
