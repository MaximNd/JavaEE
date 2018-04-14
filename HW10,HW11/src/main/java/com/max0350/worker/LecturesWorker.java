package com.max0350.worker;

import com.max0350.data.DAO.LecturesDao;
import com.max0350.data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
public class LecturesWorker {
    @Autowired
    LecturesDao lecturesDao;

    public Lecture addLecture(Lecture lecture){
        lecture = lecturesDao.addLecture(lecture);
        return lecture;
    }

    public Lecture findLecture(int id) {
        return lecturesDao.getLecture(id);
    }
    public List<Lecture> findAllLectures() {
        return lecturesDao.getAllLectures();
    }

    public Lecture updateLecture(Lecture lecture) { lecturesDao.saveLecture(lecture); return lecture; }

    @Transactional
    public Lecture deleteLectureById(int id) {
        Lecture lecture = lecturesDao.getLecture(id);
        lecturesDao.deleteLecture(lecture);
        return lecture;
    }
}

