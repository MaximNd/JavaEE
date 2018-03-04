package worker;

import data.DAO.LecturesDao;
import data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;

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
}

