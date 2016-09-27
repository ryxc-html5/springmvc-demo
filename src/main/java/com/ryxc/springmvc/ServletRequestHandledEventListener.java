package com.ryxc.springmvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent> {

	private final  Log logger = LogFactory.getLog(this.getClass());
	@Override
	public void onApplicationEvent(ServletRequestHandledEvent event) {
		logger.info(" #############"+event.getDescription());
	}

}
