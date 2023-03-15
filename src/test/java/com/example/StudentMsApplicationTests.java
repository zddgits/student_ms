package com.example;



import com.example.stums.service.StudentService;
import com.example.stums.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class StudentMsApplicationTests {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;


}
