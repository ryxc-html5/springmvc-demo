package com.ryxc.springmvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController implements EnvironmentAware{
	private final  Log logger = LogFactory.getLog(this.getClass());
	
	
	@RequestMapping(value = {"/showOrderForm"}, method = {RequestMethod.GET})
	public String showOrderForm(Model model){
		logger.info("============= processed by showOrderForm ===========");
		return "orderForm.jsp";
	}
	
	@RequestMapping(value = {"/submit"}, method = {RequestMethod.POST})
	public String orderSubmit(@RequestParam String orderId,@RequestParam String sessionId,RedirectAttributes attr){
		logger.info("============= processed by orderSubmit ===========");
		logger.info("### orderId:"+orderId);
		logger.info("### sessionId:"+sessionId);
		
		if("".equals(sessionId)){
			
		}else{
			
		}
		
		attr.addFlashAttribute("orderId", orderId);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:showOrder";
	}
	
	@RequestMapping(value = {"/showOrder"}, method = {RequestMethod.GET})
	public String showOrder(Model model){
		logger.info("============= processed by showOrder ===========");
		model.addAttribute("msg","Go Go Go");
		return "showOrder.jsp";
	}
	
	
	

	private Environment environment = null;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
}
