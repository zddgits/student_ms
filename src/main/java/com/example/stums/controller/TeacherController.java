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
@RequestMapping("/teacher")
public class TeacherController {
//    private int TEACHER_ID = Math.toIntExact(BaseContext.getCurrentId());
    private int TEACHER_ID = 100000;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    /**
     * 根据id查询教师信息,用来查自己的bingo
     * @return 教师对象
     */
    @GetMapping("/teacher")
    public R<Teacher> queryTeacherById(){
        Teacher flag = teacherService.getById(TEACHER_ID);
        if(flag != null) {
            return R.success(flag);
        } else {
            return R.error("查询教师信息失败！");
        }
    }

    /**
     * 查询已经接受的acceptor=teacher的通知bingo
     * @return 返回所有通知的分页对象
     */
    @GetMapping("/getNoticesReceived/{current}&{limit}")
    public R<Page<Notice>> getNoticesReceived(
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable int current,
            @ApiParam(name = "limit", value = "每页数量", required = true)
            @PathVariable int limit){
        String acceptor = "teacher";
//        Page<Notice> page = noticeService.findPageByAcceptor(acceptor);
        R<Page<Notice>> r = noticeService.findPageByAcceptor(acceptor, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询已接受通知失败！");
        }
    }

    /**
     * 查询已经发布的通知bingo
     * @return 返回所有通知的分页对象
     */
    @GetMapping("/getNoticesDelivered/{current}&{limit}")
    public R<Page<Notice>> getNoticesDelivered(@ApiParam(name = "current", value = "当前页", required = true)
                                                   @PathVariable int current,
                                               @ApiParam(name = "limit", value = "每页数量", required = true)
                                                   @PathVariable int limit){
//        Page<Notice> page = noticeService.findPageByDeliver(TEACHER_ID);
        R<Page<Notice>> r = noticeService.findPageByDeliver(TEACHER_ID, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询已发布通知失败！");
        }
    }

    /**
     * 查询教师曾经和现在教过的全部课程bingo
     * @return 返回所有课程的分页对象
     */
    @GetMapping("/getCourseStudents/{current}&{limit}")
    public R<Page<CourseStudent>> getCourseTeachers(@ApiParam(name = "current", value = "当前页", required = true)
                                                        @PathVariable int current,
                                                    @ApiParam(name = "limit", value = "每页数量", required = true)
                                                        @PathVariable int limit){
//        Page<CourseStudent> page = courseStudentService.findPageByID("teacher", TEACHER_ID);
        R<Page<CourseStudent>> r = courseStudentService.findPageByID("teacher", TEACHER_ID, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询教师课程信息失败！");
        }
    }

    /**
     * 查询教师课表
     * @return 返回所有课表的分页对象
     */
    @GetMapping("/getTables/{current}&{limit}")
    public R<Page<Schedule>> getTables(@ApiParam(name = "current", value = "当前页", required = true)
                                        @PathVariable int current,
                                       @ApiParam(name = "limit", value = "每页数量", required = true)
                                        @PathVariable int limit){
//        Page<Schedule> page = scheduleService.findPageByWorkID(TEACHER_ID);
        R<Page<Schedule>> r = scheduleService.findPageByWorkID(TEACHER_ID, current, limit);
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
//     * 查询某一课程的具体信息bingo
//     * @param name 课程name
//     * @return 返回所有课程的分页对象
//     */
//    @GetMapping("/getCourse/{name}/{current}&{limit}")
//    public R<Page<Course>> getCourseByName(@PathVariable String name,
//                                           @ApiParam(name = "current", value = "当前页", required = true)
//                                           @PathVariable int current,
//                                           @ApiParam(name = "limit", value = "每页数量", required = true)
//                                               @PathVariable int limit){
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
     * 查询本教师某一课程的课程情况（学生和成绩）bingo
     * @param courseID 课程ID
     * @return 返回所有课程的分页对象
     */
    @GetMapping("/getCourseTeachers/{courseID}/{current}&{limit}")
    public R<Page<CourseStudent>> getCourseTeachers(
            @ApiParam(name = "courseID", value = "课程ID", required = true)
            @PathVariable Integer courseID,
            @ApiParam(name = "current", value = "当前页", required = true)
            @PathVariable int current,
            @ApiParam(name = "limit", value = "每页数量", required = true)
            @PathVariable int limit){
//        Page<CourseStudent> page = courseStudentService.findByTeacherAndCourse(TEACHER_ID, courseID);
        R<Page<CourseStudent>> r = courseStudentService.findByTeacherAndCourse(TEACHER_ID, courseID, current, limit);
        if(r != null) {
            return r;
        } else {
            return R.error("查询全部课程失败！");
        }
    }

    /**
     * 更新教师信息bingo
     * @param teacher 教师对象
     * @return 用R返回成功或失败
     * */
    @PutMapping("/updateTeacher")
    public R<String> updateTeacher(@RequestBody Teacher teacher){
        if(teacher.getId() != TEACHER_ID) return R.error("更新信息不是本人");
        boolean flag = teacherService.updateById(teacher);
        if(flag) {
            return R.success("更新教师信息成功！");
        } else {
            return R.error("更新教师信息失败！");
        }
    }

    /**
     * 更新教师教授的课程信息bingo
     * @param course 课程对象
     * @return 用R返回成功或失败
     * */
    @PutMapping("/updateCourse")
    public R<String> updateCourse(@RequestBody Course course){
        R<Page<CourseStudent>> page = courseStudentService.findByTeacherAndCourse(TEACHER_ID, course.getId(), 0, 0);
        if(page == null) {
            return R.error("该课程不被本教师教授");
        }
        boolean flag = courseService.updateById(course);
        if(flag) {
            return R.success("更新课程信息成功");
        } else {
            return R.error("更新课程信息失败！");
        }
    }

    /**
     * 更新学生成绩信息，需要先验证该课程是否是这个教师bingo
     * @param courseStudent 课程对象
     * @return 用R返回成功或失败
     * */
    @PutMapping("/updateCourseStudent")
    public R<String> updateCourseStudent(@RequestBody CourseStudent courseStudent){
        boolean flag = courseStudentService.updateById(courseStudent);
        CourseStudent temp = courseStudentService.getById(courseStudent.getId());
        if(temp.getTeacherId() != TEACHER_ID) return R.error("更新成绩不在教授课程内");
        if(flag) {
            return R.success("更新成绩成功！");
        } else {
            return R.error("更新成绩信息失败！");
        }
    }

    /**
     * 发布通知，将通知保存在数据库中bingo
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
     * 增加课程bingo
     * @return 返回成功与否
     */
    @PostMapping("/saveCourse")
    public R<String> saveCourse(@RequestBody Course course){
        Course temp = courseService.getById(course.getId());
        if(temp == null){
            boolean flag = courseService.save(course);
            if(flag) {
                return R.success("已增加课程");
            }
            else {
                return R.error("课程增加失败");
            }
        } else {
            return R.error("该课程已存在");
        }
    }

    /**
     * 增加学生和课程关系bingo
     * @return 返回成功与否
     */
    @PostMapping("/saveCourseStudent")
    public R<String> saveCourseStudent(@RequestBody CourseStudent courseStudent){
        CourseStudent temp = courseStudentService.getById(courseStudent.getId());
        if(temp == null){
            boolean flag = courseStudentService.save(courseStudent);
            if(flag) {
                return R.success("已添加课程-学生关系");
            }
            else {
                return R.error("添加失败");
            }
        } else {
            return R.error("该关系已存在");
        }
    }

    /**
     * 删除CourseStudent中数据bingo
     * @param CSid CourseStudent的id
     * */
    @DeleteMapping("/deleteCourseStudent/{CSid}")
    public R<String> deleteCourseStudent(@PathVariable Integer CSid){
        CourseStudent courseStudent = courseStudentService.getById(CSid);
        if(TEACHER_ID != courseStudent.getTeacherId()){
            return R.error("不是本教师，不能删除");
        }
        boolean flag = courseStudentService.removeById(CSid);
        if(flag) {
            return R.success("删除成功");
        }
        else {
            return R.error("删除失败");
        }
    }
}

