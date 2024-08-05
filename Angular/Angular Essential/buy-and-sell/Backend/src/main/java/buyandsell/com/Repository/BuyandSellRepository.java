package buyandsell.com.Repository;

import buyandsell.com.Model.BuyAndSell;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BuyandSellRepository extends MongoRepository<BuyAndSell,Integer> {
//  List <BuyAndSell> findByName(String itemName);

  BuyAndSell deleteById(int itemId);

  boolean existsById(int itemId);

  BuyAndSell findById(int itemId);
}
