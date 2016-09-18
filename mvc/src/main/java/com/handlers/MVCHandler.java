package com.handlers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class MVCHandler {
	@Autowired
	HttpSession httpSession;
	private final RequestMappingHandlerMapping handlerMapping;

	 @Autowired
	 public MVCHandler(RequestMappingHandlerMapping handlerMapping) {
	  this.handlerMapping = handlerMapping;
	 }
	
	/*
	  * This method is responsible to check number of URLS available in particular application 
	  */
	 @RequestMapping(value="/endpointdoc", method=RequestMethod.GET)
	 public void show(Model model) {
	  model.addAttribute("handlerMethods", this.handlerMapping.getHandlerMethods());
	  ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
     scanner.addIncludeFilter(new AnnotationTypeFilter(Controller.class));
     for (BeanDefinition beanDefinition : scanner.findCandidateComponents("com.handlers")){
         System.out.println(beanDefinition.getBeanClassName());
     }
	  System.out.println("model values ; " + model.asMap().toString());
	 } 
	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		System.out.println("is session new : " +httpSession.isNew());
		return "Arc1.0 MVC OK.";
		
	}
}
