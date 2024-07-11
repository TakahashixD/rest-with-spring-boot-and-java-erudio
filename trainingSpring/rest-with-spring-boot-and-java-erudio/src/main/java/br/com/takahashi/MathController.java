package br.com.takahashi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.com.takahashi.exceptions.UnsupportedMathOperationException;
import br.com.takahashi.service.MathService;

@RestController
public class MathController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private MathService mathService = new MathService();
	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a correct numeric value");
		}
		return mathService.sum(numberOne, numberTwo);
	}
	
	@GetMapping(value = "/sub/{numberOne}/{numberTwo}")
	public Double sub(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a correct numeric value");
		}
		return mathService.sub(numberOne, numberTwo);
	}

	@GetMapping(value = "/mul/{numberOne}/{numberTwo}")
	public Double mul(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a correct numeric value");
		}
		return mathService.mul(numberOne, numberTwo);
	}
	
	@GetMapping(value = "/div/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a correct numeric value");
		}
		return mathService.div(numberOne, numberTwo);
	}
	
	@GetMapping(value = "/media/{numberOne}/{numberTwo}")
	public Double media(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a correct numeric value");
		}
		return mathService.media(numberOne, numberTwo);
	}
	
	@GetMapping(value = "/raiz/{number}")
	public Double raiz(
			@PathVariable(value="number") String number
			) throws Exception {
		if(!mathService.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a correct numeric value");
		}
		return mathService.raiz(number);
	}
}
