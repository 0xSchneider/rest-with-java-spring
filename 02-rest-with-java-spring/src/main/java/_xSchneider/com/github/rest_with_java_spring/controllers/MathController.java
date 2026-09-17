package _xSchneider.com.github.rest_with_java_spring.controllers;

import _xSchneider.com.github.rest_with_java_spring.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws UnsupportedMathOperationException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo) )
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);


    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  throws UnsupportedMathOperationException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  throws UnsupportedMathOperationException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value");
        if(convertToDouble(numberTwo)==0) throw new UnsupportedMathOperationException("Number two cannot be zero");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/med/{numberOne}/{numberTwo}")
    public Double median(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw  new UnsupportedMathOperationException("Please, set a numeric value");
        return (convertToDouble(numberOne)+convertToDouble(numberTwo))/2;
    }

    @RequestMapping("/quad/{numberOne}")
    public double quad(
            @PathVariable("numberOne") String numberOne
    ) throws UnsupportedMathOperationException {
        if(!isNumeric(numberOne)) throw   new UnsupportedMathOperationException("Please, set a numeric value");
        return Math.sqrt(convertToDouble(numberOne));
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please, set a numeric value");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }


    private boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

}
