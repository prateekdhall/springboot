package com.springboot.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspectExampleController {
	
	private Logger logger = LoggerFactory.getLogger(AspectExampleController.class);

	@Autowired
	AspectExampleService aspectExampleServiceObject;
	
	@RequestMapping(value="/applyAOP", method = RequestMethod.GET)
	public ResponseEntity<Object>fetchServiceValue()
	{
		logger.info("Enter in AspectExampleController ");
		String val= aspectExampleServiceObject.fetchValue();
		logger.info("Value to be printed");
		logger.debug("Returned Value {}", val);
		return new ResponseEntity<Object>("Fetch value="+val,HttpStatus.OK);
	}

}
