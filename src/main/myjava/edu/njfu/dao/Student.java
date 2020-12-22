package edu.njfu.dao;

public class Student {
    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }



    public Student(String stuNo, String stuName, String classes, String gender, String department, String tel, String dormNo, String photoPath) {
        this.stuNo = stuNo;
        StuName = stuName;
        this.classes = classes;
        this.gender = gender;
        this.department = department;
        this.tel = tel;
        this.dormNo = dormNo;
        this.photoPath = photoPath;
    }


    public Student() {
    }
    @Override
    public String toString() {
        return "student{" +
                "stuNo='" + stuNo + '\'' +
                ", StuName='" + StuName + '\'' +
                ", classes='" + classes + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", tel='" + tel + '\'' +
                ", dormNo='" + dormNo + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
    private  String stuNo;
    private String StuName;
    private String classes;
    private String gender;
    private String department;
    private String tel;
    private String dormNo;
    private String photoPath;
}
