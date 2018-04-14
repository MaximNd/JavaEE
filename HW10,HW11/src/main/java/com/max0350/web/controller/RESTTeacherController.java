package com.max0350.web.controller;

import com.max0350.data.entities.Teacher;
import com.max0350.worker.TeacherWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Макс on 14.04.2018.
 */
@Controller
@RequestMapping(value = "/teachers")
public class RESTTeacherController {
    @Autowired
    TeacherWorker teacherWorker;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Teacher getTeacherById(@PathVariable int id) {
        return this.teacherWorker.findTeacher(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Teacher> getAllTeachers() {
        return this.teacherWorker.findAllTeacher();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Teacher addTeacher(@RequestBody Teacher teacher) {
        return this.teacherWorker.addTeacher(teacher);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Teacher updateTeacher(@RequestBody Teacher teacher) {
        return this.teacherWorker.updateTeacher(teacher);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Teacher deleteTeacherById(@PathVariable int id) {
        return this.teacherWorker.deleteTeacherById(id);
    }
}
