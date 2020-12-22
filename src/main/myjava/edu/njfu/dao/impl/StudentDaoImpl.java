package edu.njfu.dao.impl;


import edu.njfu.dao.Student;
import edu.njfu.dao.StudentDao;
import edu.njfu.util.DBHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getAllStudent() {
        String sql="select*from tbl_student";
        DBHelper db=new DBHelper();
        List<Object> result=db.query(sql,null);
        List<Student> students=new ArrayList<>();
        for (Object o:result){
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("department"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );

        }
        return students;
    }
    //实现studentdao
}
