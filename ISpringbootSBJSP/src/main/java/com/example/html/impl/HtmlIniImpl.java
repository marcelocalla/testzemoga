/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.html.impl;

import org.springframework.stereotype.Service;
import com.example.html.HtmlIni;

/**
 *
 * @author M. Calla
 */
@Service("HtmlIni")
public class HtmlIniImpl implements HtmlIni {

    public String iniPage(){
        String sHTML = "<!doctype html>"
                + " <html lang=\"en\">"
                + " <head>"
                + "    <!-- Etiquetas <meta> obligatorias para Bootstrap -->"
                + "    <meta charset=\"utf-8\">"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                + "    <!-- Enlazando el CSS de Bootstrap -->"
                + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\""
                + "          integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"
                + "    <title>¡Hola Mundo!</title>"
                + "  </head>";
        return sHTML;

    }

}
