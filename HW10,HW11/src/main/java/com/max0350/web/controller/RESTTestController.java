package com.max0350.web.controller;

import com.max0350.data.entities.Lecture;
import com.max0350.data.entities.Test;
import com.max0350.worker.LecturesWorker;
import com.max0350.worker.TestWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Макс on 14.04.2018.
 */
@Controller
@RequestMapping(value = "/tests")
public class RESTTestController {
    @Autowired
    TestWorker testWorker;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Test getTestById(@PathVariable int id) {
        return this.testWorker.findTest(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Test> getAllTest() {
        return this.testWorker.getAllTests();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Test addTest(@RequestBody Test test) {
        return this.testWorker.addTest(test);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Test updateTest(@RequestBody Test test) {
        return this.testWorker.updateTest(test);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Test deleteTestById(@PathVariable int id) {
        return this.deleteTestById(id);
    }
}
