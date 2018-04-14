package com.max0350.data.DAO;

import com.max0350.data.entities.Lecture;

import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
public interface LecturesDao {

    Lecture addLecture(Lecture lecture);

    Lecture getLecture(int id);
    List<Lecture> getAllLectures();

    void saveLecture(Lecture lecture);
    void deleteLecture(Lecture lecture);
}

