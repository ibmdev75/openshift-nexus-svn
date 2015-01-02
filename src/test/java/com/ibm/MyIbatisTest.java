package com.ibm;


import com.ibm.beans.Student;
import com.ibm.mapper.services.StudentMapperService;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Karim on 23/12/2014.
 */
public class MyIbatisTest extends TestCase {

    Logger logger = LoggerFactory.getLogger(MyIbatisTest.class);
    private static StudentMapperService service;

    @BeforeClass
    public  static void setup() {
        service = new StudentMapperService();
    }
    public void testMyIbatis() {

        try {
            service = new StudentMapperService();
            List<Student> l =  service.findAllStudents();
            logger.info("Recherche de la liste des éléments : "+l.size());
            }
        catch(Exception e) {
            logger.error("Erreur SQL");
        }

    }



}
