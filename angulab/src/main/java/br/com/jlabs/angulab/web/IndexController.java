/**
 * 
 */
package br.com.jlabs.angulab.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.jlabs.angulab.entity.Keyword;

/**
 * @author sandro
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView index() {
		
		return new ModelAndView("index");
		
	}
	
	@RequestMapping("/keywords/list")
	public ModelAndView listKeywords() {
		
		return new ModelAndView("list");
		
	}

	@RequestMapping("/keywords")
	public @ResponseBody List<Keyword> getKeywords() {
		
		List<Keyword> keywords = new ArrayList<Keyword>();
		
		keywords.add(new Keyword(1, "teste.item.number1", "Teste item 1"));
		keywords.add(new Keyword(2, "teste.item.number2", "Teste item 2"));
		keywords.add(new Keyword(3, "teste.item.number3", "Teste item 3"));
		keywords.add(new Keyword(4, "teste.item.number4", "Teste item 4"));
		keywords.add(new Keyword(5, "teste.item.number5", "Teste item 5"));
		
		return keywords;
		
	}
}
