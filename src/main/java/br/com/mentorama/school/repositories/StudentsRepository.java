package br.com.mentorama.school.repositories;

import br.com.mentorama.school.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentsRepository {

    private Student students;

    private List<Student> student;

    public StudentsRepository(){
        this.student = new ArrayList<>();

        Student student1 = new Student(1, "Carlos", 18);
        Student student2 = new Student(2, "Paulo", 17);

        student.add(student1);
        student.add(student2);
    }


    public List<Student> findAll(){
        return student;
    }


    public List<Student> findByName(String nome){
        return student.stream()
                .filter(a-> a.getNome().contains(nome))
                .collect(Collectors.toList());
    }

    public void post (Student student){
        this.student.add(student);
    }
    public Integer count(){
        return student.size();
    }


    public void deleteById(Integer id){
        this.student.removeIf(a->a.getId().equals(id));
    }
}