package br.com.mentorama.school.service;


import br.com.mentorama.school.model.Student;
import br.com.mentorama.school.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;


    public List<Student> findAll(){
        return studentsRepository.findAll();
    }


    public List<Student> findByName(String nome){
        if(studentsRepository.findByName(nome).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentsRepository.findByName(nome);
    }


    public Integer post(Student student){
        if (student.getId()==null){
            student.setId(studentsRepository.count()+1);
        }
        studentsRepository.post(student);
        return student.getId();
    }


    public void deleteById(Integer id){
       studentsRepository.deleteById(id);

    }
}