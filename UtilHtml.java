/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.SBSampleJSP;

import com.example.bean.Porfolio;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author M. Calla
 */
@Component(value = "utilHtml")
public class UtilHtml {

    @Autowired
    ConectMysql conDB;

    @Autowired
    TwiterInfo twt;

    public String iniPage() {

        String sHTML = "<!doctype html>"
                + " <html lang=\"en\">"
                + " <head>"
                + "    <meta charset=\"utf-8\">"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                + " <link href=\"https://stackpath.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css\" rel=\"stylesheet\" type=\"text/css\" />"
                + " <style>table {border-collapse: collapse;} th, td {border: 1px solid orange;padding: 10px;text-align: left;}</style>"
                + "    <title>test</title>"
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
        html = html + " <a href=\"/SBSampleJSP/newPagePortFolio\">Create new portFolio</a> <br><br>";
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
            html = html + "<td><a href='/SBSampleJSP/twiterPage?id=" + p.getTwitter_user_id() + "&name=" + p.getNames() + "'> Detail</a>&nbsp;&nbsp;&nbsp;<a href=\"#\">Edit</a>&nbsp;&nbsp;&nbsp;<a href=\"#\">Delete</a> </td>";
            html = html + "</tr>";

        }
        html = html + "</table></center>";

        return html;

    }

    public String creatPortfolioPage() {

        String html = "<html>"
                + " <body><br><br><br><center><h1>Create a new portfolio</h1> ";
        html = html + "<form action=\"savePorFolio\" method=\"post\" name ='Porfolio'>"
                + " <div>"
                + " <label for=\"description\">Description </label>"
                + " <input name=\"description\" id=\"description\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"exSuma\">Experience Summary </label>"
                + " <input name=\"exSuma\" id=\"exSuma\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"id\">Id </label>"
                + " <input name=\"id\" id=\"id\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"img\">Image URL </label>"
                + " <input name=\"img\" id=\"img\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"lastname\">Last name </label>"
                + " <input name=\"lastname\" id=\"lastname\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"names\">Names </label>"
                + " <input name=\"names\" id=\"names\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"title\">Title </label>"
                + " <input name=\"title\" id=\"title\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"t_user_id\">Twiter user id </label>"
                + " <input name=\"t_user_id\" id=\"t_user_id\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"t_user_name\">Twiter user name </label>"
                + " <input name=\"t_user_name\" id=\"t_user_name\" value=''>"
                + "</div>"
                + " <div>"
                + " <label for=\"userid\">User id </label>"
                + " <input name=\"userid\" id=\"userid\" value=''>"
                + "</div><br><br><br>"
                + "<div>"
                + " <input type='submit' value='Create' />"
                + "</div>"
                + "</form>";
        html = html + "</center><br></body></html>";
        return html;
//<button>Create</button>
    }

    /**
     * Create Porfolio row
     *
     */
    public boolean createPortfolio(Porfolio dat) throws Exception {
        String s = dat.getDescription();
        System.out.println("createPortfolio " + s);
        conDB.insertProfile(dat);
        return true;
    }

    public boolean createPortfolioAlfa(Porfolio dat) throws Exception {
        String s = dat.getDescription();
        System.out.println("createPortfolio " + s);
        conDB.insertProfile(dat);
        return true;
    }

    public String createTwiterPage(String Id, String name) {
        Map data = null;
        String table = "";
        List<Map> fiveTwist = new ArrayList();
        String sHTML = "<!doctype html>"
                + " <html lang=\"en\">"
                + " <head>"
                + "    <meta charset=\"utf-8\">"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                + "    <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css' rel='stylesheet'/>"
                + "    <title>Twiter</title>"
                + "  </head>";
        sHTML = sHTML + "<body><center><h1>Twitter information</h1><br><br>";
        data = twt.getInfoTwiter(Id);

        fiveTwist = (List) data.get("ListTwiet");
        String name1 = data.get("nameUser").toString();
        table = "<table><tr><th><img src=\"https://pbs.twimg.com/profile_images/1352347417421754368/59u6g7w5_400x400.jpg\" alt=\"Image\" width=\"300\" height=\"300\"></th><tr>";
        for (Map minfo : fiveTwist) {
            table = table + "<tr>";
            table = table + "<td><p><mark><b>" + minfo.get("User").toString() + "</b></mark><br>";
            table = table + minfo.get("Text").toString() + "</td></tr>";
        }
        table = table + "<tr><td><a href='https://twitter.com/i/flow/login?input_flow_data=%7B%22requested_variant%22%3A%22eyJsYW5nIjoiZXMifQ%3D%3D%22%7D'>Go to Account</a></td></tr>";
        table = table + "</table>";
        sHTML = sHTML + "<div class='container'>"
                + "<div class='row'>"
                + " <div class='col'><span class='border border-top-0 p-2 border-primary'>"
                + " " + table
                + " </span></div>"
                + "  <div class='col '>"
                + "  <h1>" + name1 + "</h1>"
                + "   <p>" + data.get("ComentIni") + "</p>"
                + "  </div>"
                + "</div>"
                + "</div>";
        sHTML = sHTML + "</center></body>";

        return sHTML;

    }

    public boolean updatePortfolio(Porfolio dat) throws Exception {
        long l = dat.getIdportfolio();
        System.out.println("updatePortfolio " + l);
        conDB.updateProfile(dat);
        return true;
    }

    public boolean deletePortfolio(Porfolio dat) throws Exception {
        long id = dat.getIdportfolio();
        System.out.println("deletePortfolio " + id);
        conDB.deleteProfile(dat);
        return true;
    }

    public List<Porfolio> getListPorFolio() {
        conDB.getInfoProperties();
        List<Porfolio> lInfo = conDB.getData();
        return lInfo;
    }
}
