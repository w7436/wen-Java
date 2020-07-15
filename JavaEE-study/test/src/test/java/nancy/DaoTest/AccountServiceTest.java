package nancy.DaoTest;

import config.SpringConfiguration;
import nancy.model.Account;
import nancy.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName AccountServiceTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 10:34
 * @Version 1.0
 **/


/**
 * 使用junit单元测试，测试我们的配置
 * spring整合junit的配置
 *          1、导入spring整合junit的jar包
 *          2、使用Junit提供的一个注解将原有的main方法提替换成spring提供的@Runwith
 *          3、告诉spring运行器，spring的IOC容器的创建时基于xml还是注解的
 *                  @ContextConfiguration:
 *                          locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                          classes:指定注解类所在的位置
 *
 * 当使用spring 5。x版本的时候，需要junit的jar必须是4.12ji以上版本
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    /**
     * 使用配置文件
     */
//    @Test
//    public void testFindAll(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//获取容器
//        IAccountService as = ac.getBean("accountService",IAccountService.class);//得到业务层对象
//        List<Account> list = as.findAllAccount();
//        for(Account account: list){
//            System.out.println(account);
//        }
//    }

    /**
     * 使用注解
     */
    @Autowired
    private IAccountService as = null;
    @Test
    public void testFindAll(){
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService",IAccountService.class);//得到业务层对象
        List<Account> list = as.findAllAccount();
        for(Account account: list){
            System.out.println(account);
       }
    }


}
