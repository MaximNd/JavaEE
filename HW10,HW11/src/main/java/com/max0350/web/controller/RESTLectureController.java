package com.max0350.web.controller;

import com.max0350.data.entities.Lecture;
import com.max0350.worker.LecturesWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Макс on 14.04.2018.
 */
@Controller
@RequestMapping(value = "/lectures")
public class RESTLectureController {
    @Autowired
    LecturesWorker lecturesWorker;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Lecture getLectureById(@PathVariable int id) {
        return this.lecturesWorker.findLecture(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Lecture> getAllLectures() {
        return this.lecturesWorker.findAllLectures();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Lecture addLecture(@RequestBody Lecture lecture) {
        return this.lecturesWorker.addLecture(lecture);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Lecture updateLecture(@RequestBody Lecture lecture) {
        return this.lecturesWorker.updateLecture(lecture);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Lecture deleteLectureById(@PathVariable int id) {
        return this.lecturesWorker.deleteLectureById(id);
    }
}