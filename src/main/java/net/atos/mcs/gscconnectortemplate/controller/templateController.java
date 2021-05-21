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
public class templateController {

	private static final Logger logEnMinuscula = LoggerFactory.getLogger(templateController.class);
	
	@GetMapping("/helloWorld")
	public String HelloWorld() {
        logEnMinuscula.trace("A TRACE Message" + " Suma de Strings");
        logEnMinuscula.debug("A DEBUG Message");
        logEnMinuscula.info("An INFO Message");
        logEnMinuscula.warn("A WARN Message");
        logEnMinuscula.error("An ERROR Message");
		return "Hello World!";
	}

	@GetMapping("/exception")
	public String exception() {
		logEnMinuscula.error("exception");
		throw new TemplateException();
	}

	@PostMapping("/myRequest")
	private TemplateResponse myRequest(@RequestBody TemplateRequest request) {
		logEnMinuscula.debug("The request is: {}", request);
		TemplateResponse response = new TemplateResponse();

		response.setMyString("Hello " + request.getMyInt() + "!");

		return response;
	}

	@GetMapping("/hello/{id}")
	public TemplateResponse one(@PathVariable Long id) {
		logEnMinuscula.debug("The parameter is: {}", id);
//		TemplateResponse response = new TemplateResponse();
		TemplateResponse response = null;

		response.setMyString("Hello " + id + "!");

		return response;
	}

}
