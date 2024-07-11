package br.com.takahashi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberOne") String numberTwo
			) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		return converToDouble(numberOne) + converToDouble(numberTwo);
	}

	private int converToDouble(String strNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean isNumeric(String strNumber) {
		// TODO Auto-generated method stub
		return false;
	}
}
