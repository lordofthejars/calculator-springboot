package org.superbiz.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CalculatorApplication {

    private CalculatorDecorator calculatorDecorator = new CalculatorDecorator();

    @RequestMapping(method = RequestMethod.GET, value = "/sum/{a}/{b}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sum(@PathVariable int a, @PathVariable int b) {
        return calculatorDecorator.add(a, b);
    }

    @RequestMapping(method = RequestMethod.GET, value="/healthz")
    @ResponseBody
    public ResponseEntity health() {
        return new ResponseEntity(HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}
