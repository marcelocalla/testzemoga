package com.example.SBSampleJSP;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.html.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SbSampleJspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(SbSampleJspApplication.class);
    }

    public static void main(String[] args) {
        //SpringApplication.run(SbSampleJspApplication.class, args);
        SpringApplication sa = new SpringApplication(
                SbSampleJspApplication.class);
        sa.run(args);
    }


    @RestController
    public static class WarInitializerController {

        @Autowired
        utilHtml util;

        @GetMapping("/init")
        public String handler(Map<String, Object> model) {
            String html = util.createLisPage();
            return html;
        }
    }

}
