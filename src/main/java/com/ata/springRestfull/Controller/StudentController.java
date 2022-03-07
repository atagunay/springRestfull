package com.ata.springRestfull.Controller;

import com.ata.springRestfull.Entity.Student;
import com.ata.springRestfull.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getall")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/addStudent")
    public void addNewStudent(@RequestBody Student student){
         studentService.addNewStudent(student);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/updateStudent/{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);

    }

}
