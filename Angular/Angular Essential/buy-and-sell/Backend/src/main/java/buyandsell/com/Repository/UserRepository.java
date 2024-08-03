package buyandsell.com.Repository;

import buyandsell.com.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
  List<User> findByAge(int age);
}