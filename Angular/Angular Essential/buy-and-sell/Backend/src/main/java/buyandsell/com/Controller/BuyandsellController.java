package buyandsell.com.Controller;

import buyandsell.com.Model.BuyAndSell;
import buyandsell.com.Service.BuyandSellService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
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

public class BuyandsellController {
  private Logger logger =LoggerFactory.getLogger(BuyandsellController.class);
  private final BuyandSellService buyandSellService;

  @Autowired
  public BuyandsellController(BuyandSellService buyandSellService){
    this.buyandSellService = buyandSellService;
  }

  @PostMapping(path="/listings")
  public @ResponseBody
  String addListings(@RequestBody BuyAndSell buyAndSell, HttpServletResponse response)
    throws JSONException, JsonProcessingException {
    return buyandSellService.save(buyAndSell,response);
  }


  @GetMapping(path = "/findAllListings",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<BuyAndSell> getAllListings(HttpServletResponse response){
    return buyandSellService.getAllListings();
  }


  @PutMapping(path="/listings/{itemId}")
  public String updateListings(@PathVariable("itemId") int itemId, @RequestBody BuyAndSell buyAndSell, HttpServletResponse response)
    throws JsonProcessingException, JSONException {
    return  buyandSellService.updateListings(itemId,buyAndSell,response);
  }

  @DeleteMapping(path = "/delete/{itemId}")
  public String deleteListings(@PathVariable int itemId,HttpServletResponse response)
    throws JSONException, JsonProcessingException {
    return buyandSellService.deleteById(itemId,response);
  }

}
