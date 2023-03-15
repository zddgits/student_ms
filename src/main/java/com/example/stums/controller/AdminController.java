package com.example.stums.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.CourseStudent;
import com.example.stums.entity.Notice;
import com.example.stums.entity.Student;
import com.example.stums.entity.Teacher;
import com.example.stums.service.*;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.dc.pr.PRError;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    //    private int ADMIN_ID = BaseContext.getCurrentId();
    private int ADMIN_ID = 1;

    @Autowired
    private StudentService studentService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有的学生及其课表bingo
     * @return 返回一个分页对象
     */
    @GetMapping("/students/{current}&{limit}")
    public R<Page<CourseStudent>> queryAllStudents(@ApiParam(name = "current", value = "当前页", required = true)
                                                       @PathVariable int current,
                                                   @ApiParam(name = "limit", value = "每页数量", required = true)
                                                       @PathVariable int limit){
        R<Page<CourseStudent>> r = courseStudentService.findAll(current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询全部课程学生信息失败！");
        }
    }

    /**
     * 根据ID查询学生信息bingo
     * @param id 学生ID
     * @return 学生对象
     */
    @GetMapping("/student/{id}")
    public R<Student> queryStudentById(@PathVariable Integer id){
        Student student = studentService.getById(id);
        if(student != null) {
            return R.success(student);
        } else {
            return R.error("查询学生信息失败！");
        }
    }

    /**
     * 根据name查询学生信息bingo
     * @param name 课程name
     * @return 返回学生对象
     */
    @GetMapping("/studentsByName/{name}/{current}&{limit}")
    public R<Page<Student>> queryStudentByName(@PathVariable String name,
                                           @ApiParam(name = "current", value = "当前页", required = true)
                                           @PathVariable int current,
                                           @ApiParam(name = "limit", value = "每页数量", required = true)
                                               @PathVariable int limit){
        R<Page<Student>> r = studentService.findByName(name, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询学生失败！");
        }
    }

    /**
     * 根据ID查询teacher信息bingo
     * @param id teacherId
     * @return teacher对象
     */
    @GetMapping("/teacher/{id}")
    public R<Teacher> queryTeacherById(@PathVariable Integer id){
        Teacher teacher = teacherService.getById(id);
        if(teacher != null) {
            return R.success(teacher);
        } else {
            return R.error("查询学生信息失败！");
        }
    }

    /**
     * 根据name查询Teacher信息bingo
     * @param name TeacherID
     * @return Teacher对象
     */
    @GetMapping("/teacher/{name}/{current}&{limit}")
    public R<Page<Teacher>> queryTeacherByName(@PathVariable String name,
                                         @ApiParam(name = "current", value = "当前页", required = true)
                                         @PathVariable int current,
                                         @ApiParam(name = "limit", value = "每页数量", required = true)
                                             @PathVariable int limit){
        R<Page<Teacher>> r = teacherService.findByName(name, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询学生失败！");
        }
    }

    /**
     * 发布通知，将通知保存在数据库中
     * @return 返回成功与否
     */
    @PostMapping("/saveNotice")
    public R<String> saveNotice(@RequestBody Notice notice){
        Notice temp = noticeService.getById(notice.getId());
        if(temp == null){
            boolean flag = noticeService.save(notice);
            if(flag) {
                return R.success("已发布通知");
            }
            else {
                return R.error("发布通知失败");
            }
        } else {
            return R.error("该通知已存在");
        }
    }

    /**
     * 查询已经发布的所有通知bingo
     * @return 返回所有通知的分页对象
     */
    @GetMapping("/getNotices/{current}&{limit}")
    public R<Page<Notice>> getNotices(@ApiParam(name = "current", value = "当前页", required = true)
                                          @PathVariable int current,
                                      @ApiParam(name = "limit", value = "每页数量", required = true)
                                          @PathVariable int limit){
        R<Page<Notice>> r = noticeService.findPage(current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询全部通知失败！");
        }
    }
}

