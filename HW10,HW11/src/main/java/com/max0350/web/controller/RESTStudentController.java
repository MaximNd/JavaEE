package com.max0350.web.controller;
import com.max0350.data.entities.Student;
import com.max0350.data.entities.Teacher;
import com.max0350.worker.StudentsWorker;
import com.max0350.worker.TeacherWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Макс on 14.04.2018.
 */


/**
 * Created by Макс on 14.04.2018.
 */
@Controller
@RequestMapping(value = "/students")
public class RESTStudentController {
    @Autowired
    StudentsWorker studentsWorker;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Student getStudentById(@PathVariable int id) {
        return this.studentsWorker.findStudent(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Student> getAllStudents() {
        return this.studentsWorker.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Student addStudent(@RequestBody Student student) {
        return this.studentsWorker.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Student updateStudent(@RequestBody Student student) {
        return this.studentsWorker.updateStudent(student);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Student deleteStudentById(@PathVariable int id) {
        return this.studentsWorker.deleteStudentById(id);
    }
}
