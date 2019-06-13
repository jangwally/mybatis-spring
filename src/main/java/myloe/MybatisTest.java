package myloe;

import myloe.bean.Student;
import myloe.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: mybatis-spring
 * @description:
 * @author: Mr.Loe
 * @create: 2019-06-11 10:42
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
@SuppressWarnings("all")
public class MybatisTest {

    @Autowired
    private IStudentService studentService;


    @Test
    public void test1(){
        Student student = studentService.selectByPrimaryKey(1);
        System.out.println(11);
        System.out.println("test");
        System.out.println("6666");
        System.out.println(777);
    }
}
