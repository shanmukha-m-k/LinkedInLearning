package buyandsell.com.Service;

import buyandsell.com.Model.Student;
import buyandsell.com.Repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
  private StudentRepository studentRepository;

  private Student student;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public StudentService() {

  }

  public String save(Student student, HttpServletResponse response)
    throws JsonProcessingException, JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();

    if (student.getName() == null || ("").equals(student.getAge())) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    student = studentRepository.save(student);
    JSONObject studentJson = new JSONObject(mapper.writeValueAsString(student));
    studentJson.put("id", student.getId().toHexString());
    responseJson.put("saveStudentResponse", studentJson);
    return responseJson.toString();
  }


  public List<Student> getAllStudent() {
    return studentRepository.findAll();
  }


  @Transactional
  public String updateStudent(ObjectId id, Student student, HttpServletResponse response)
    throws JsonProcessingException, JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();
    Student student1 = studentRepository.findById(id);
    boolean exist = studentRepository.existsById(id);

    if (!exist) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    if (student.getName() != null) {
      student1.setName(student.getName());
      student1.setAge(student.getAge());
      studentRepository.save(student1);


      JSONObject studentJson = new JSONObject(mapper.writeValueAsString(student1));
      studentJson.put("id", student1.getId().toHexString());
      responseJson.put("UpdateStudentResponse", studentJson);
    }
    return responseJson.toString();

  }

  public String deleteById(ObjectId id,  HttpServletResponse response)
    throws  JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();

    boolean exist = studentRepository.existsById(id);

    if (!exist) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    else {
      responseJson.put("deleted the student with id",id);
      studentRepository.deleteById(id);
    }
    return responseJson.toString();
  }


}
