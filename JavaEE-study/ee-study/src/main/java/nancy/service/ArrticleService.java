package nancy.service;

import nancy.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ArrticleService
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/17 21:03
 * @Version 1.0
 **/
@Service
public class ArrticleService {

    @Resource
    private ArticleMapper articleMapper;

//    public Article queryId(Integer id) {
//
//    }
}
