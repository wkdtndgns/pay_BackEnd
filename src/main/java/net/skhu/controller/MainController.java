package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.rank;
import net.skhu.repository.RankRepository;

@RestController
@RequestMapping("api")
public class MainController {

	@Autowired RankRepository rank;
	
    @RequestMapping("list")
    public List<rank> list(Model model) {
        List<rank> list = rank.findAll();
        model.addAttribute("list", list);
  
        return list;
    }
    
    @RequestMapping("insert/{pay}")
    public void rank(@PathVariable("pay") int pay) {
    	rank r = new rank(); 
    	r.setPay(pay);
    	rank.save(r);
 	
    }


}
