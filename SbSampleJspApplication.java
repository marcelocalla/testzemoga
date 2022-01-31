package com.example.SBSampleJSP;

import com.example.bean.Porfolio;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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

    /**
     * Controller for PortFolio
     */
    //@EnableSwagger2
    @RestController
    public static class WarInitializerController {

        @Autowired
        UtilHtml util;

        /**
         * Start the listing page
         */
        @GetMapping("/init")
        public String handler(Map<String, Object> model) {
            String html = util.createLisPage();
            return html;
        }

        /**
         * Go to the portFolio creation page
         */
        //@GetMapping("newPagePortFolio")  
        @RequestMapping(value = "newPagePortFolio", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
        @ResponseBody
        public String createPF(Map<String, Object> model) {
            String html = util.creatPortfolioPage();
            return html;
        }

        /**
         * Save the portFolio data
         */
        @RequestMapping(value = "savePorFolio", method = RequestMethod.POST, produces = "text/html; charset=utf-8", consumes = {"application/xml", "application/json"})
        @ResponseBody
        public String savePF(@RequestBody Porfolio pf) {
            try {
                System.out.println("savePF" + pf);
                boolean b = util.createPortfolio(pf);
            } catch (Exception ee) {
                ee.printStackTrace();
                return "<b>No se grabo correctamente</b> Error :" + ee.getMessage();
            }
            return "<b>Se grabo correctamente</b>";
        }

        /**
         * Send Twitter data page
         */
        @RequestMapping(value = "twiterPage", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
        @ResponseBody
        public String createTwiterPage(@RequestParam String id, @RequestParam String name) {
            String html = util.createTwiterPage(id, name);
            return html;
        }

        /**
         * Update the portFolio data
         */
        @RequestMapping(value = "updatePorFolio", method = RequestMethod.PUT, produces = "text/html; charset=utf-8", consumes = {"application/xml", "application/json"})
        @ResponseBody
        public String updatePF(@RequestBody Porfolio pf) {
            try {
                System.out.println("savePF" + pf);
                boolean b = util.updatePortfolio(pf);
            } catch (Exception ee) {
                ee.printStackTrace();
                return "<b>No se grabo correctamente</b> Error :" + ee.getMessage();
            }
            return "<b>Se grabo correctamente</b>";
        }

        /**
         * Delete the portFolio data
         */
        @RequestMapping(value = "deletePorFolio", method = RequestMethod.PUT, produces = "text/html; charset=utf-8", consumes = {"application/xml", "application/json"})
        @ResponseBody
        public String deletePF(@RequestBody Porfolio pf) {
            try {
                System.out.println("savePF" + pf);
                boolean b = util.deletePortfolio(pf);
            } catch (Exception ee) {
                ee.printStackTrace();
                return "<b>Se tiene errores para borrar el registro:" + pf.getIdportfolio() + "</b>, Error :" + ee.getMessage();
            }
            return "<b>Se booro correctamente</b>";
        }

        @RequestMapping(value = "/savePorFolioAlfa", method = RequestMethod.POST, produces = "application/json")
        @ResponseBody
        public ResponseEntity savePortFolioAlfa(@RequestBody Porfolio pf) {
            try {
                boolean b = util.createPortfolio(pf);
                return new ResponseEntity("Se agrego correctamente", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("Error:" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @RequestMapping(value = "updatePorFolioAlfa", method = RequestMethod.PUT, produces = "application/json", consumes = {"application/json"})
        @ResponseBody
        public ResponseEntity updatePFAlfa(@RequestBody Porfolio pf) {
            try {
                System.out.println("savePF" + pf);
                boolean b = util.updatePortfolio(pf);
                return new ResponseEntity("Se actualizo correctamente", HttpStatus.OK);
            } catch (Exception ee) {
                ee.printStackTrace();
                return new ResponseEntity("Error:" + ee.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @RequestMapping(value = "getListPF", method = RequestMethod.GET, produces = "application/json")
        @ResponseBody
        public ResponseEntity getListPFAlfa() {
            try {
                List<Porfolio> lpf = util.getListPorFolio();
                return new ResponseEntity(lpf, HttpStatus.OK);
            } catch (Exception ee) {
                ee.printStackTrace();
                return new ResponseEntity("Error:" + ee.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
