package edu.njfu.sas.dao;
import edu.njfu.sas.model.*;

import java.sql.SQLException;
import java.util.List;
public interface StudentDao {
    List<Student> getAllStudent() throws SQLException;
    List<Student> getStudentByName(String name);
    List<Student> getStudentByPage(int page,int size) throws SQLException;
    Student getStudentByNo(String stuno);
    boolean saveStudent(Student s);
    long countToString();
}
