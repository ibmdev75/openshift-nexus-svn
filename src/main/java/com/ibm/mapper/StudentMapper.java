package com.ibm.mapper;

import com.ibm.beans.Student;

import java.util.List;

/**
 * Created by Karim on 24/12/2014.
 */
public interface StudentMapper {

    List<Student> findAllStudents();
}
