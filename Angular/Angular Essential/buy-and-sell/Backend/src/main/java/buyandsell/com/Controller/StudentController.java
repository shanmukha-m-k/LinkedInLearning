package buyandsell.com.Controller;

import buyandsell.com.Model.Student;
import buyandsell.com.Service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentController {
  private Logger logger = LoggerFactory.getLogger(StudentController.class);

  private final StudentService studentService;

  @Autowired
  public  StudentController(StudentService studentService){
this.studentService=studentService;
  }


  @PostMapping(path="/add")
  public @ResponseBody
  String addStudent(@RequestBody Student student, HttpServletResponse response)
    throws JSONException, JsonProcessingException {
    return studentService.save(student,response);
  }


  @GetMapping(path = "/findAllStudents",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Student> getAllStudent(HttpServletResponse response){
    return studentService.getAllStudent();
  }


  @PutMapping(path="/student/{id}")
  public String updateStudent(@PathVariable("id")ObjectId id,@RequestBody Student student,HttpServletResponse response)
    throws JsonProcessingException, JSONException {
    return  studentService.updateStudent(id,student,response);
  }

  @DeleteMapping(path = "/delete/{id}")
  public String deleteStudent(@PathVariable ObjectId id,HttpServletResponse response) throws JSONException, JsonProcessingException {
    return studentService.deleteById(id,response);
  }
}
