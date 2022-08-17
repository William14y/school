package br.com.mentorama.school.controllers;

import br.com.mentorama.school.model.Student;
import br.com.mentorama.school.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsController {

        @Autowired
        private StudentsService studentsService;

      
        @RolesAllowed("user")
        @GetMapping
        public ResponseEntity<List<Student>> findAll(){
            return new ResponseEntity<>
                    (studentsService.findAll(), HttpStatus.OK);
        }

       
        @RolesAllowed("user")
        @GetMapping("/{nome}")
        public  ResponseEntity<List<Student>> findByName(@PathVariable ("nome") String nome ){
            return new ResponseEntity<>(studentsService.findByName(nome), HttpStatus.OK);
        }

     
        @RolesAllowed("user")
        @PostMapping
        public ResponseEntity<Integer> post(@RequestBody Student student){
            return new ResponseEntity<>(studentsService.post(student), HttpStatus.CREATED);
        }

   
        @RolesAllowed("user")
        @DeleteMapping("/{id}")
        public ResponseEntity deleteById(@PathVariable ("id") Integer id){
            studentsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        }