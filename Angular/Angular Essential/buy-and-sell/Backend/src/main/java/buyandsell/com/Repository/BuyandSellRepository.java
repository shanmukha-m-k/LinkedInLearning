package buyandsell.com.Repository;

import buyandsell.com.Model.BuyAndSell;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BuyandSellRepository extends MongoRepository<BuyAndSell,UUID> {
  List <BuyAndSell> findByName(String itemName);

  BuyAndSell deleteById(int id);

  boolean existsById(int id);

  BuyAndSell findById(int id);
}
