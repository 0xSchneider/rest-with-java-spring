package _xSchneider.com.github.rest_with_java_spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger log = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String restLog(){
        log.debug("This is a debug log");
        log.info("This is a info log");
        log.warn("This is a warn log");
        log.error("This is a error log");
        return "Logs generated successfully";


    }
}
