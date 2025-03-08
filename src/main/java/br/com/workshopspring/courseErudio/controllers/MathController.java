package br.com.workshopspring.courseErudio.controllers;

import br.com.workshopspring.courseErudio.converters.NumberConverter;
import br.com.workshopspring.courseErudio.exceptions.UnsupportedMathOperationException;
import br.com.workshopspring.courseErudio.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private static final AtomicLong counter = new AtomicLong();

    private final SimpleMath simpleMath = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
}
