package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.rank;
import net.skhu.repository.RankRepository;

@RestController
@CrossOrigin(origins = "http://sellery.me.s3-website.ap-northeast-2.amazonaws.com")
@RequestMapping("api")
public class MainController {

	@Autowired RankRepository rank;
	
    @RequestMapping("list")
    public List<rank> list(Model model) {
    	
        List<rank> list = rank.findAllByOrderByPayDesc();
        model.addAttribute("list", list);
       
        return list;
    }
    
    @RequestMapping("insert/{pay}")
    public double rank(@PathVariable("pay") int pay) {
    	rank r = new rank(); 
    	r.setPay(pay);
    	rank.save(r);
 	
    	List<rank> list = rank.findAllByOrderByPayDesc();
    	
    	
    	int size = list.size();
    	double result=0;
    	int index = 0;
    	
    	for(int i=0; i<size; i++) {
    		if(list.get(i).getPay()==pay) {
    			index=i;
    		}    		
    	}
    	
    	System.out.println(size +" "+ index);
    	
    	System.out.format("%.2f%n", index/(double)size);
    	result=index/(double)size;
    	System.out.println(result);
    	
    	return result;
    }


}
