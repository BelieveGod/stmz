package com.stmz.mgr.vo;

/**
 * @ClassName CourseVO
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/23 16:09
 * @Version 1.0
 */
public class CourseVO {

    private Long teacherId;
    private Long classId;
    private String teacherName;
    private String teacherSn;
    private String className;
    private String SubjectName;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSn() {
        return teacherSn;
    }

    public void setTeacherSn(String teacherSn) {
        this.teacherSn = teacherSn;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    @Override
    public String toString() {
        return "CourseVO{" +
                "teacherId=" + teacherId +
                ", classId=" + classId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSn='" + teacherSn + '\'' +
                ", className='" + className + '\'' +
                ", SubjectName='" + SubjectName + '\'' +
                '}';
    }
}
