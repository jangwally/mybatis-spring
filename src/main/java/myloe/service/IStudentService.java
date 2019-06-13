package myloe.service;

import myloe.bean.Student;

import java.util.List;

/**
 * @program: mybatis-spring
 * @description:
 * @author: Mr.Loe
 * @create: 2019-06-11 10:41
 **/
public interface IStudentService {

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll();
}
