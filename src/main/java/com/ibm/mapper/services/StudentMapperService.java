package com.ibm.mapper.services;

import com.ibm.beans.Student;
import com.ibm.configuration.MyBatisSqlSessionFactory;
import com.ibm.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Karim on 24/12/2014.
 */
public class StudentMapperService {

     public List<Student> findAllStudents() {
        // Ouverture de la connexion JDBC
         SqlSession session = MyBatisSqlSessionFactory.openSession();
         try {
                StudentMapper mapper = session.getMapper(StudentMapper.class);
                return mapper.findAllStudents();
         }
         finally {
             // Fermeture de la connexion JDBC
             session.close();
         }
    }
}
