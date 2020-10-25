package com.stmz.mgr.entity;

import com.stmz.mgr.entity.id.TeacherRelateClassID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @ClassName TeacherRelateClass
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:41
 * @Version 1.0
 */
@Entity
@Table(name="TB_TEACHER_REL_CLASS")
@IdClass(TeacherRelateClassID.class)
public class TeacherRelateClass {
    @Id
    private Long teacherId;

    @Id
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
}
