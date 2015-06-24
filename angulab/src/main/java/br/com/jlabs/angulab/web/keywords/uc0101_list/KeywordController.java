package br.com.jlabs.angulab.web.keywords.uc0101_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.jlabs.angulab.business.keywords.uc0101_list.KeywordBusiness;
import br.com.jlabs.infra.rest.PagedSearchFilter;
import br.com.jlabs.infra.rest.RestResponse;

@Controller
public class KeywordController {

	@Autowired
	private KeywordBusiness keywordBusiness;
	
	@RequestMapping(value="/keyword/list/template")
	public ModelAndView listPage() {
		
		return new ModelAndView("keyword/list");
		
	}
	
	@RequestMapping(value="/keyword/list")
	public @ResponseBody RestResponse list(PagedSearchFilter searchFilter) {
		
		keywordBusiness.list(searchFilter);
		
		return RestResponse.success(keywordBusiness.list(searchFilter));
		
	}
	
}
