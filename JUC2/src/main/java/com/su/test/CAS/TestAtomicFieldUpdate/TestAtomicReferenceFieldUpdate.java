package com.su.test.CAS.TestAtomicFieldUpdate;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 应用类型字段修改器
 */
@Slf4j(topic = "c.AtomicReferenceFieldUpdate")
public class TestAtomicReferenceFieldUpdate {
    public static void main(String[] args) {
        Student stu = new Student();
        AtomicReferenceFieldUpdater<Student, String> update = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        System.out.println(update.compareAndSet(stu, null, "张三"));
        System.out.println(stu);
    }
}
class Student{
    volatile String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
