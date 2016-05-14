package control.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/test/*")
public class test {
	
	@RequestMapping
	public void reqTest(HttpServletRequest request,
			@RequestParam Map<String, String> reqMap,
			ModelMap model) throws Exception {
		
		System.out.println("reqTest Start...");
		System.out.println(reqMap);
		System.out.println("reqTest End...");
		
		String json = JSONValue.toJSONString(reqMap);
		System.out.println(json);
		
		model.addAttribute(json);
	}
	
	@RequestMapping(value="/index.html")
	public ModelAndView index(HttpServletRequest request,
			ModelAndView mv) throws Exception {
		
		mv.setViewName("index.html");
		
		return mv;
	}
	
}
