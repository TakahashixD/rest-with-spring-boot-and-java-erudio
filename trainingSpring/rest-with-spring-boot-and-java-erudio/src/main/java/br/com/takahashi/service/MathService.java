package br.com.takahashi.service;

public class MathService {
	
	public Double converToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public Double sum(String numberOne, String numberTwo) {
		return converToDouble(numberOne) + converToDouble(numberTwo);
	}
	
	public  Double sub(String numberOne, String numberTwo) {
		return converToDouble(numberOne) + converToDouble(numberTwo);
	}

	public Double mul(String numberOne, String numberTwo) {
		return converToDouble(numberOne) * converToDouble(numberTwo);
	}
	
	public Double div(String numberOne, String numberTwo) {
		return converToDouble(numberOne) / converToDouble(numberTwo);
	}
	
	public Double media(String numberOne, String numberTwo) {
		return (converToDouble(numberOne) + converToDouble(numberTwo))/2;
	}
	
	public Double raiz(String number) {
		return Math.sqrt(converToDouble(number));
	}
}
