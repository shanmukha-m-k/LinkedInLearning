package buyandsell.com.Service;

import buyandsell.com.Model.BuyAndSell;
import buyandsell.com.Model.Student;
import buyandsell.com.Repository.BuyandSellRepository;
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
public class BuyandSellService {

  private BuyandSellRepository buyandSellRepository;
  private BuyAndSell buyAndSell;
  @Autowired
  public BuyandSellService(BuyandSellRepository buyandSellRepository){
    this.buyandSellRepository = buyandSellRepository;
  }

  public BuyandSellService(){}

  public String save(BuyAndSell buyAndSell , HttpServletResponse response)
    throws JsonProcessingException, JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();

    if (buyAndSell.getItemName() == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    buyAndSell = buyandSellRepository.save(buyAndSell);
    JSONObject listingsJson = new JSONObject(mapper.writeValueAsString(buyAndSell));
    listingsJson.put("id", buyAndSell.getItemId());
    responseJson.put("Save Item Response", listingsJson);
    return responseJson.toString();
  }




  public List<BuyAndSell> getAllListings() {
    return buyandSellRepository.findAll();
  }


  @Transactional
  public String updateListings(int id, BuyAndSell listings, HttpServletResponse response)
    throws JsonProcessingException, JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();
    BuyAndSell listings1 = buyandSellRepository.findById(id);
    boolean exist = buyandSellRepository.existsById(id);

    if (!exist) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    if (listings.getItemName() != null) {
      listings1.setItemName(buyAndSell.getItemName());
      listings1.setItemDescription(buyAndSell.getItemDescription());
      listings1.setItemPrice(buyAndSell.getItemPrice());
      buyandSellRepository.save(listings1);


      JSONObject listingsJson = new JSONObject(mapper.writeValueAsString(listings1));
      listingsJson.put("id", listings1.getItemId());
      responseJson.put("Update Listings Response", listingsJson);
    }
    return responseJson.toString();

  }

  public String deleteById(int id,  HttpServletResponse response)
    throws  JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();

    boolean exist = buyandSellRepository.existsById(id);

    if (!exist) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    else {
      responseJson.put("deleted the student with id",id);
      buyandSellRepository.deleteById(id);
    }
    return responseJson.toString();
  }

}
