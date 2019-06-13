package myloe.controller;

import myloe.bean.Student;
import myloe.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping("list")
    public String list(ModelMap modelMap) {

        List<Student> students = studentService.selectAll();

        modelMap.addAttribute("students",students);
        return "list";
    }

    @RequestMapping("getOne")
    public String getOne(ModelMap modelMap){
        Student student=studentService.selectByPrimaryKey(1);

        modelMap.addAttribute("student",student);

        return "details";
    }
}
