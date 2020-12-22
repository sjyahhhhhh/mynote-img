package edu.njfu.sas.dao.impl;

import edu.njfu.sas.dao.StudentDao;
import edu.njfu.sas.model.Student;
import edu.njfu.sas.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentDaoImp2 implements StudentDao {
    private QueryRunner runner ;
    @Override

    public List<Student> getAllStudent() throws SQLException {
        String sql="select*from tbl_student";
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getConnection());
        List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
        return students;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return null;
    }

    @Override
    public List<Student> getStudentByPage(int page, int size) throws SQLException {
        String sql="select*from tbl_student where stuno limit ?,?";
        int start=(page-1)*size;
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getConnection());

        try{
            List<Student> students =  queryRunner.query(sql,new BeanListHandler<Student>(Student.class),new Object[]{start,size});
            return students;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student getStudentByNo(String stuno) {
        return null;
    }

    @Override
    public boolean saveStudent(Student s) {
        return false;
    }

    @Override
    public long countToString() {
        String sql="select count(*) as count from tbl_student";
        runner=new QueryRunner(C3p0Util.getConnection());
        long result=0;
        try{
            List<Map<String,Object>>query=runner.query(sql,new MapListHandler());
            result=(long)query.get(0).get("count");
            //块状用域，在块内使用的变量，快外不能使用
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
