/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tinip
 */
public class Ex7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         /**
     * @param args the command line arguments
     */
       Student emp1 = new Student(1, "Few", 3.5);
       Student emp2 = new Student(2, "Louis", 3.0);
       StudentTable.insertStudent(emp1);
       StudentTable.insertStudent(emp2);
       //Student stu;
       //stu = StudentTable.findStudentById(1);
       //if (stu != null) {
       //    stu.setName("Jack");
           //StudentTable.removeStudent(stu);
       //    StudentTable.updateStudent(stu);
       //}
       //List<Student> empList = StudentTable.findStudentByName("Marry"); 
       List<Student> empList = StudentTable.findAllStudent();
       printAllStudent(empList);
    }
    public static void printAllStudent(List<Student> employeeList) {
        for(Student stu : employeeList) {
           System.out.print(stu.getId() + " ");
           System.out.print(stu.getName() + " ");
           System.out.println(stu.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
   
