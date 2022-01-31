/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SBSampleJSP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author M. Calla
 */
@Component(value = "TwiterInfo")
public class TwiterInfo {

    static ConfigurationBuilder cb = new ConfigurationBuilder();
    TwitterFactory tf;

    public TwiterInfo() {
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("KRy7l0v8wex3w8Sy5zThai3Ea")
                .setOAuthConsumerSecret("X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu")
                .setOAuthAccessToken("1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja")
                .setOAuthAccessTokenSecret("tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj");

         tf = new TwitterFactory(cb.build());
    }

    public Map getInfoTwiter(String ConsumerKey) {
        Map returns = new HashMap();
        int iCount = 0;
        Map mDat = new HashMap();
        List<Map> mTwiters = new ArrayList();
        String Msg = "";
        Twitter twitter = tf.getInstance();
        List<Status> statusList = null;
        twitter4j.User Use=null;
        try {
            statusList = twitter.getUserTimeline("@Citi"); //"@Citi"
            long userID = twitter.getId();
            Use= twitter.showUser(userID);
        } catch (TwitterException error) {
            error.printStackTrace();
        }
        for (Status status : statusList) {
            System.out.println(status.toString());
            mDat = new HashMap();
            mDat.put("User", status.getUser().getName());
            mDat.put("Text", status.getText());
            Msg = status.getText();
            mTwiters.add(mDat);
            ++iCount;
            if (iCount > 4) {
                break;
            }
        }
        returns.put("ListTwiet", mTwiters);
        returns.put("ComentIni", Msg);
        returns.put("nameUser", Use.getName());
        System.out.println(mTwiters);
        return returns;
    }

}
