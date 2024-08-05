package buyandsell.com.Service;

import buyandsell.com.Model.BuyAndSell;
import buyandsell.com.Repository.BuyandSellRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
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
    listingsJson.put("itemId", buyAndSell.getItemId());
    responseJson.put("Save Item Response", listingsJson);
    return responseJson.toString();
  }




  public List<BuyAndSell> getAllListings() {
    return buyandSellRepository.findAll();
  }


  @Transactional
  public String updateListings(int itemId, BuyAndSell listings, HttpServletResponse response)
    throws JsonProcessingException, JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();
    BuyAndSell listings1 = buyandSellRepository.findById(itemId);
    boolean exist = buyandSellRepository.existsById(itemId);

    if (!exist) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    if (listings.getItemName() != null) {
      listings1.setItemName(listings.getItemName());
      listings1.setItemDescription(listings.getItemDescription());
      listings1.setItemPrice(listings.getItemPrice());
      buyandSellRepository.save(listings1);


      JSONObject listingsJson = new JSONObject(mapper.writeValueAsString(listings1));
      listingsJson.put("itemId", listings1.getItemId());
      responseJson.put("UpdateListingsResponse", listingsJson);
    }
    return responseJson.toString();

  }

  public String deleteById(int itemId,  HttpServletResponse response)
    throws  JSONException {
    JSONObject responseJson = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();

    boolean exist = buyandSellRepository.existsById(itemId);

    if (!exist) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    else {
      responseJson.put("deleted the student with id",itemId);
      buyandSellRepository.deleteById(itemId);
    }
    return responseJson.toString();
  }

}
