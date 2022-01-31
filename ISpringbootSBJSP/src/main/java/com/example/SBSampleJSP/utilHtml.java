/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.SBSampleJSP;

import com.example.bean.Porfolio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author M. Calla
 */
@Component(value = "utilHtml")
public class utilHtml {

    @Autowired
    ConectMysql conDB;

    public String iniPage() {

        String sHTML = "<!doctype html>"
                + " <html lang=\"en\">"
                + " <head>"
                + "    <meta charset=\"utf-8\">"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                + " <link href=\"https://stackpath.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css\" rel=\"stylesheet\" type=\"text/css\" />"
                + " <style>table {border-collapse: collapse;} th, td {border: 1px solid orange;padding: 10px;text-align: left;}</style>"
                + "    <title>¡Hola Mundo!</title>"
                + "  </head>";
        return sHTML;

    }

   public String createLisPage() {
        conDB.getInfoProperties();
        List<Porfolio> lInfo = conDB.getData();
        String html = this.iniPage() + " <body>";
        html = html + "<center><h1>List of PortFolio</h1></center>";
        System.out.println("dd");
        List<String> in = new ArrayList();
        in.add("Dan");
        in.add("Dan1");
        in.add("Dan2");
        html = html + " <a href=\"#\">Create new portFolio</a> <br><br>";
        html = html + " <center> <table>";
        html = html + "<tr> "
                + " <th>Profile</th>"
                + "  <th>Image</th>"
                + "  <th>Name</th>"
                + "  <th>Text</th>"
                + "  <th>Action</th>"
                + " </tr>";
        for (Porfolio p : lInfo) {

            html = html + "<tr>";
            html = html + "<td><a href=\"#\">" + p.getDescription() + "</a></td>";
            html = html + "<td>" + p.getImage_url() + "</td>";
            html = html + "<td>" + p.getNames() + "</td>";
            html = html + "<td>" + p.getTittle() + "</td>";
            html = html + "<td><a href=\"#\">Detail</a>&nbsp;&nbsp;&nbsp;<a href=\"#\">Edit</a>&nbsp;&nbsp;&nbsp;<a href=\"#\">Delete</a> </td>";
            html = html + "</tr>";

        }
        html = html + "</table></center>";

        return html;

    }

}
