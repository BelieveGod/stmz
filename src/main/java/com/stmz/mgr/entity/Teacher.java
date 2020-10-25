package com.stmz.mgr.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:31
 * @Version 1.0
 */
@Entity
@Table
public class Teacher {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String teacherSn;

    private String education;

    private String department;

    private String office;

    private String phone;

    private Date birthday;

    private String description;

    private Integer salary;

    private Long subjectId;

    private String subjectName;

    private String userName;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherSn='" + teacherSn + '\'' +
                ", education='" + education + '\'' +
                ", department='" + department + '\'' +
                ", office='" + office + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherSn() {
        return teacherSn;
    }

    public void setTeacherSn(String teacherSn) {
        this.teacherSn = teacherSn;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
