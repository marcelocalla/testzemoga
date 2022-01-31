/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SBSampleJSP;

import com.example.bean.Porfolio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.stereotype.Component;

/**
 * Class for conection and get data to Mysql
 *
 * @author M. Calla
 */
@Component(value = "ConectMysql")
public class ConectMysql {

    private Connection con;
    private String user;
    private String password;
    private String nameDataBase;
    private String ipDataBase;
    private String Port;

    public ConectMysql(Connection con, String user, String password, String nameDataBase, String ipDataBase) {
        this.con = con;
        this.user = user;
        this.password = password;
        this.nameDataBase = nameDataBase;
        this.ipDataBase = ipDataBase;
    }

    public ConectMysql() {
        this.getInfoProperties();
    }

    public void setParams(String user, String password, String ipDataBase, String Port) {
        this.user = user;
        this.password = password;
        this.Port = Port;
        this.ipDataBase = ipDataBase;
    }

    /**
     * Get conection to Mysql
     */
    public Connection getConection(String user, String password, String nameDataBase, String ipDataBas, String Port) {
        //"jdbc:mysql://zemoga-test-db.crhpedy9xxto.us-east-1.rds.amazonaws.com:3306/?user=zemoga_test_db&password=Zem0ga.101");
        try {
            System.out.println("conec:" + "jdbc:mysql://" + ipDataBas + ":" + Port + "/?user=" + user + "&password=" + password);
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://" + ipDataBas + ":" + Port + "/?user=" + user + "&password=" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.con;
    }

    public Connection getConectionNoParam() {
        try {
            System.out.println("conec:" + "jdbc:mysql://" + this.ipDataBase + ":" + this.Port + "/?user=" + this.user + "&password=" + this.password);
            Class.forName("com.mysql.jdbc.Driver"); 
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://" + this.ipDataBase.trim() + ":" + this.Port.trim() + "/?user=" + this.user.trim() + "&password=" + this.password.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.con;
    }

    /**
     * *
     * Close conection
     */
    public boolean closeConection() {
        try {
            this.con.close();
        } catch (Exception ee) {
            ee.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * get List of Porfolio
     */
    public List<Porfolio> getData() {
        List<Porfolio> data = new ArrayList();
        Porfolio portfolio = null;
        String SQl = "select  * from zemoga_test_db.portfolio";
        try {
            this.getConectionNoParam();
            PreparedStatement preparedStatement = this.con.prepareStatement(SQl);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               
                portfolio = new Porfolio();
                portfolio.setId(resultSet.getLong("id"));
                portfolio.setIdportfolio(resultSet.getLong("idportfolio"));
                portfolio.setDescription(resultSet.getString("description"));
                portfolio.setExperience_summary(resultSet.getString("experience_summary"));
                portfolio.setImage_url(resultSet.getString("image_url"));
                portfolio.setLast_names(resultSet.getString("last_names"));
                portfolio.setNames(resultSet.getString("names"));
                portfolio.setTittle(resultSet.getString("tittle"));
                portfolio.setTwitter_user_id(resultSet.getString("twitter_user_id"));
                portfolio.setTwitter_user_name(resultSet.getString("twitter_user_name"));
                portfolio.setUser_id(resultSet.getString("user_id"));
                System.out.println("getData:"+resultSet.getLong("id"));
                data.add(portfolio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception ee) {
            ee.printStackTrace();
            return null;
        }
        return data;

    }

    /**
     * Insert to porfolio
     */
    public boolean insertProfile(Porfolio pf) throws Exception {
        long lIdportfolio = 0;
        String SqlMax = "select  max(idportfolio)+1 as newValue from zemoga_test_db.portfolio";
        boolean bResult = false;
        String sqlInsert = "INSERT INTO `zemoga_test_db`.`portfolio`"
                + "(`idportfolio`,`description`,`experience_summary`,`id`,`image_url`,`last_names`,`names`,`tittle`,"
                + "`twitter_user_id`,`twitter_user_name`,`user_id`)"
                + "VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?);";
        Connection c = null;
        try {
            c = getConectionNoParam();
            PreparedStatement preparedStmt = c.prepareStatement(SqlMax);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                lIdportfolio = resultSet.getLong("newValue");
            }
            // create the mysql insert preparedstatement
            preparedStmt = c.prepareStatement(sqlInsert);
            preparedStmt.setLong(1, lIdportfolio);
            preparedStmt.setString(2, pf.getDescription());
            preparedStmt.setString(3, pf.getExperience_summary());
            preparedStmt.setLong(4, (pf.getId() == null) ? 0 : pf.getId());
            preparedStmt.setString(5, pf.getImage_url());

            preparedStmt.setString(6, pf.getLast_names());
            preparedStmt.setString(7, pf.getNames());
            preparedStmt.setString(8, pf.getTittle());

            preparedStmt.setString(9, pf.getTwitter_user_id());
            preparedStmt.setString(10, pf.getTwitter_user_name());
            preparedStmt.setString(11, pf.getUser_id());

            preparedStmt.execute();
            bResult = true;
        } catch (Exception ee) {
            ee.printStackTrace();
            throw new Exception(ee.getMessage());
            
        } finally {
            try {
                c.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return bResult;

    }

    /**
     * Update porFolio
     */
    public boolean updateProfile(Porfolio pf) {

        boolean bResult = false;
        String sqlUpdate = "UPDATE `zemoga_test_db`.`portfolio`"
                + " SET "
                + " `description` = ?,"
                + " `experience_summary` = ?,"
                + " `id` = ?,"
                + " `image_url` = ?,"
                + " `last_names` = ?,"
                + " `names` = ?,"
                + " `tittle` = ?,"
                + " `twitter_user_id` = ?,"
                + " `twitter_user_name` = ?,"
                + " `user_id` = ?"
                + " WHERE idportfolio = ?";

        Connection c = null;
        try {
            c = getConectionNoParam();
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = c.prepareStatement(sqlUpdate);

            preparedStmt.setString(1, pf.getDescription());
            preparedStmt.setString(2, pf.getExperience_summary());
            preparedStmt.setLong(3, (pf.getId() == null) ? 0 : pf.getId());
            preparedStmt.setString(4, pf.getImage_url());

            preparedStmt.setString(5, pf.getLast_names());
            preparedStmt.setString(6, pf.getNames());
            preparedStmt.setString(7, pf.getTittle());

            preparedStmt.setString(8, pf.getTwitter_user_id());
            preparedStmt.setString(9, pf.getTwitter_user_name());
            preparedStmt.setString(10, pf.getUser_id());

            preparedStmt.setLong(11, pf.getIdportfolio());

            preparedStmt.execute();
            bResult = true;
        } catch (Exception ee) {
            ee.printStackTrace();
            bResult = false;
        } finally {
            try {
                c.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return bResult;

    }

    /**
     * delete profile by idportfolio
     */
    public boolean deleteProfile(Porfolio pf) throws Exception {
        boolean bResult = false;
        String sqlDel = "DELETE FROM `zemoga_test_db`.`portfolio`"
                + " WHERE  idportfolio = ? ";
        Connection c = null;
        if (pf.getIdportfolio() < 7 || pf.getIdportfolio() > 12) {
            new Exception("range not allowed!");
        }
        try {
            c = getConectionNoParam();
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = c.prepareStatement(sqlDel);
            preparedStmt.setLong(1, pf.getIdportfolio());
            preparedStmt.execute();
            bResult = true;
        } catch (Exception ee) {
            ee.printStackTrace();
            bResult = false;
        } finally {
            try {
                c.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return bResult;
    }

    public boolean getInfoProperties() {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "accesDB.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found ");
            }
            this.user = prop.getProperty("userDB").toString();
            this.password = prop.getProperty("paswwordDB").toString();
            this.Port = prop.getProperty("port").toString();
            this.ipDataBase = prop.getProperty("ipDataBase").toString();
            System.out.println("------>user"+this.user+":::"+this.password+":"+this.Port+":"+this.ipDataBase);

        } catch (IOException ee) {
            ee.printStackTrace();
            return false;
        } catch (Exception ee) {
            ee.printStackTrace();
            return false;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        return true;

    }
}
