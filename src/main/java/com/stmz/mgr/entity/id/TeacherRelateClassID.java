package com.stmz.mgr.entity.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName TeacherRelateClassID
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:38
 * @Version 1.0
 */
public class TeacherRelateClassID implements Serializable {

    private Long teacherId;

    private Long classId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherRelateClassID that = (TeacherRelateClassID) o;
        return Objects.equals(teacherId, that.teacherId) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, classId);
    }
}
