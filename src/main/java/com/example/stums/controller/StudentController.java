package com.example.stums.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.*;
import com.example.stums.service.*;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/student")
public class StudentController {
//    private int STUDENT_ID = BaseContext.getCurrentId();
    private int STUDENT_ID = 200000;

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

    /**
     * 根据id查询学生信息,用来查自己的bingo
     * @return 学生对象
     */
    @GetMapping("/student")
    public R<Student> queryStudentById(){
        Student flag = studentService.getById(STUDENT_ID);
        if(flag != null) {
            return R.success(flag);
        } else {
            return R.error("查询学生信息失败！");
        }
    }

    /**
     * 查询已经发布的acceptor=student的通知bingo total"8"
     * @return 返回所有通知的分页对象
     */
    @GetMapping("/getNotices/{current}&{limit}")
    public R<Page<Notice>> getNotices(
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable int current,
            @ApiParam(name = "limit", value = "每页数量", required = true)
            @PathVariable int limit){
        String acceptor = "student";
//        Page<Notice> page = noticeService.findPageByAcceptor(acceptor);
        R<Page<Notice>> r = noticeService.findPageByAcceptor(acceptor, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询已接受通知失败！");
        }
    }

    /**
     * 查询学生曾经和现在选过的全部课程以及成绩bingo
     * @return 返回所有课程的分页对象
     */
    @GetMapping("/getCourseStudents/{current}&{limit}")
    public R<Page<CourseStudent>> getCourseStudents(@ApiParam(name = "current", value = "当前页", required = true)
                                                        @PathVariable int current,
                                                    @ApiParam(name = "limit", value = "每页数量", required = true)
                                                        @PathVariable int limit){
        //        Page<CourseStudent> page = courseStudentService.findPageByID("student", STUDENT_ID);
        R<Page<CourseStudent>> r = courseStudentService.findPageByID("student", STUDENT_ID, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询教师课程信息失败！");
        }
    }

    /**
     * 查询学生课表bingo
     * @return 返回所有课表的分页对象
     */
    @GetMapping("/getTables/{current}&{limit}")
    public R<Page<Schedule>> getTables(@ApiParam(name = "current", value = "当前页", required = true)
                                        @PathVariable int current,
                                       @ApiParam(name = "limit", value = "每页数量", required = true)
                                        @PathVariable int limit){
        //        Page<Schedule> page = scheduleService.findPageByWorkID(STUDENT_ID);
        R<Page<Schedule>> r = scheduleService.findPageByWorkID(STUDENT_ID, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询教师课表失败！");
        }
    }

    /**
     * 查询某一课程的具体信息bingo
     * @param id 课程ID
     * @return 返回所有课程的分页对象
     */
    @GetMapping("/getCourse/{id}")
    public R<Course> getCourse(@PathVariable Integer id){
        Course course = courseService.getById(id);
        if(course != null){
            return R.success(course);
        } else {
            return R.error("查询课程失败");
        }
    }

//    /**
//     * 查询某一课程的具体信息
//     * @param name 课程name
//     * @return 返回所有课程的分页对象
//     */
//    @GetMapping("/getCourseByName/{name}/{current}&{limit}")
//    public R<Page<Course>> getCourseByName(@PathVariable String name,
//                                           @ApiParam(name = "current", value = "当前页", required = true)
//                                           @PathVariable int current,
//                                           @ApiParam(name = "limit", value = "每页数量", required = true)
//                                           @PathVariable int limit){
////        Page<Course> page = courseService.findByName(name);
//        R<Page<Course>> r = courseService.findByName(name, current, limit);
//        if(r != null) {
//            return r;
//        } else {
//            return R.error("查询课程失败！");
//        }
//    }

    /**
     * 查询数据库内所有课程的具体信息bingo
     * @return 返回所有课程的分页对象
     */
    @GetMapping("/getCourses/{current}&{limit}")
    public R<Page<Course>> getCourses(@ApiParam(name = "current", value = "当前页", required = true)
                                          @PathVariable int current,
                                      @ApiParam(name = "limit", value = "每页数量", required = true)
                                          @PathVariable int limit){
        //        Page<Course> page = courseService.findPage();
        R<Page<Course>> r = courseService.findPage(current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询全部课程失败！");
        }
    }

    /**
     * 查询与本学生同一课程的课程情况（同班同学和教师）bingo
     * @param courseID 课程ID
     * @return 返回所有课程的分页对象
     */
    @GetMapping("/getCourseStudents/{courseID}/{current}&{limit}")
    public R<Page<CourseStudent>> getCourseStudents(
            @ApiParam(name = "courseID", value = "课程ID", required = true)
            @PathVariable Integer courseID,
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable int current,
            @ApiParam(name = "limit", value = "每页数量", required = true)
            @PathVariable int limit
    ){
        //        Page<CourseStudent> page = courseStudentService.findByTeacherAndCourse(STUDENT_ID, courseID);
        R<Page<CourseStudent>> r = courseStudentService.findByStudentAndCourse(STUDENT_ID, courseID, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询全部课程失败！");
        }
    }

    /**
     * 更新学生信息bingo
     * @param student 学生对象
     * @return 用R返回成功或失败
     * */
    @PutMapping("/updateStudent")
    public R<String> updateStudent(@RequestBody Student student){
        if(student.getId() != STUDENT_ID) return R.error("更新信息不是本人");
        boolean flag = studentService.updateById(student);
        if(flag) {
            return R.success("更新学生信息成功！");
        } else {
            return R.error("更新学生信息失败！");
        }
    }
}

