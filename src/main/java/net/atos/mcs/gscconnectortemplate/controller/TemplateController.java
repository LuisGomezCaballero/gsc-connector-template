/**
 * 
 */
package net.atos.mcs.gscconnectortemplate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.atos.mcs.gscconnectortemplate.domain.TemplateRequest;
import net.atos.mcs.gscconnectortemplate.domain.TemplateResponse;
import net.atos.mcs.gscconnectortemplate.exception.TemplateException;

/**
 * @author Luis
 *
 */
@RestController
public class TemplateController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

	@GetMapping("/helloWorld")
	public String helloWorld() {
        LOGGER.trace("A TRACE Message");
        LOGGER.debug("A DEBUG Message");
        LOGGER.info("An INFO Message");
        LOGGER.warn("A WARN Message");
        LOGGER.error("An ERROR Message");
		return "Hello World!";
	}

	@GetMapping("/exception")
	public  String exception() {
		LOGGER.error("exception");
		throw new TemplateException();
	}

	@PostMapping("/myRequest")
	public  TemplateResponse myRequest(@RequestBody TemplateRequest request) {
		LOGGER.debug("The request is: {}", request);
		TemplateResponse response = new TemplateResponse();

		response.setMyString("Hello " + request.getMyInt() + "!");

		return response;
	}

	@GetMapping("/hello/{id}")
	public  TemplateResponse one(@PathVariable Long id) {
		LOGGER.debug("The parameter is: {}", id);
		TemplateResponse response = new TemplateResponse();

		response.setMyString("Hello " + id + "!");

		return response;
	}

}
