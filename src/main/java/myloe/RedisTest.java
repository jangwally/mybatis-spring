package myloe;

import myloe.bean.Student;
import myloe.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
@SuppressWarnings("all")
public class RedisTest {


    @Autowired
    private RedisTemplate redisStringTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IStudentService studentService;
    @Test
    public void test() {

        redisTemplate.opsForValue().set("k1", "v1");
        Object obj = redisStringTemplate.opsForValue().get("k1");
        System.out.println(obj.toString());

    }


    @Test
    public void test2(){

        //原生jedis 访问方式
       /* Jedis jedis=new Jedis("47.101.142.72",6379);

        jedis.set("k2","v2");

        String str=jedis.get("k2");

        System.out.println("redis value is :"+str);

        jedis.close();*/
    }

    @Test
    public void test3(){
        Map myhash = redisTemplate.opsForHash().entries("myhash");

        System.out.println(myhash.toString());
    }

    @Test
    public void test4(){
        List<Student> students = studentService.selectAll();
        System.out.println(students);
    }
}
