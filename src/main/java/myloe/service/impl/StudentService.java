package myloe.service.impl;

import myloe.bean.Student;
import myloe.mapper.StudentMapper;
import myloe.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student selectByPrimaryKey(Integer id) {
        Student student= studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }
}
