//package buyandsell.com.Repository;
//
//import buyandsell.com.Model.Student;
//import java.util.*;
//
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface StudentRepository extends MongoRepository<Student,UUID> {
//  List<Student> findByName(String name);
//  Student deleteById(ObjectId id);
//
//  boolean existsById(ObjectId id);
//
//  Student findById(ObjectId id);
//
//}
