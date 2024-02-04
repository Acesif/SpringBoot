package com.mycompany.propertymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.propertymanagement.dto.CalculatorDTO;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public String add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2){
        return "<h1>%s</h1>".formatted(num1+num2);
    }
    @GetMapping("/sub/{num1}/{num2}")
    public String sub(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        return "<h1>%s</h1>".formatted(num1-num2);
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorDTO calculatorDTO){
        Double product = calculatorDTO.getNum1()*calculatorDTO.getNum2();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(product,HttpStatus.CREATED);
        return responseEntity;
    }
}
