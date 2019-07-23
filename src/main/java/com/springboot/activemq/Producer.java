package com.springboot.activemq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

	@Autowired
	private Queue queue;

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(value = "publish/{msg}", method = RequestMethod.GET)
	public String publish(@PathVariable("msg") final String msg) {
		jmsTemplate.convertAndSend(queue, msg);
		return "Your message <b>" + msg + "</b> published successfully";
	}
}