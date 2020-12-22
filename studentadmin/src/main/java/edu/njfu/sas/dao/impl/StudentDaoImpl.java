package edu.njfu.sas.dao.impl;
import edu.njfu.sas.dao.StudentDao;
import edu.njfu.sas.model.Student;
import edu.njfu.sas.util.DBHelper;

import java.lang.reflect.Parameter;
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

    @Override
    public List<Student> getStudentByName(String name) {
        String sql="select*from tbl_student where stuname like ?";
        System.out.println(sql);

        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add('%'+name+'%');
        List<Object> result=db.query(sql,params);

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

    @Override
    public List<Student> getStudentByPage(int page, int size) {
        String sql="select *from tbl_student where stuno limit ?,?";
        int start=(page-1)*size;
        DBHelper db=new DBHelper();
        List<Object> parm=new ArrayList<>();
        parm.add(start);
        parm.add(size);
        List<Object> result=db.query(sql,parm);
        List<Student> students=new ArrayList<>();
        for ( Object o :result){
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
                    ));
        };
        return students;
    }

    @Override
    public Student getStudentByNo(String stuno) {
        String sql="select*from tbl_student where stuno='"+stuno+"'";
        System.out.println(sql);

        DBHelper db=new DBHelper();
        List<Object> result=db.query(sql,null);

        Map map=(Map)result.get(0);
         return new Student(
            (String)map.get("stuno"),
            (String)map.get("stuname"),
            (String)map.get("classes"),
            (String)map.get("gender"),
            (String)map.get("department"),
            (String)map.get("tel"),
            (String)map.get("dormno"),
            (String)map.get("photopath")
            );

    }

    @Override
    public boolean saveStudent(Student s) {
        String sql="insert into tbl_student " +
                "values(?,?,?,?,?,?,?,?)";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add(s.getStuNo());
        params.add(s.getStuName());
        params.add(s.getClasses());
        params.add(s.getGender());
        params.add(s.getDepartment());
        params.add(s.getTel());
        params.add(s.getDormNo());

        if (s.getGender().equals("女")){
            params.add("./images/student/girl.jpg");
        }else{
            params.add("./images/student/boy.jpg");
        }
        int result=db.update(sql,params);
        return result>0;
    }

    @Override
    public long countToString() {
        String sql="SELECT count(*) as count from tbl_student";
        DBHelper db=new DBHelper();
        List<Object> objects=db.query(sql,null);

        return (long)((Map)objects.get(0)).get("count");
    }
    //实现studentdao
}
