/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bean;

/**
 * Bean for portfolio
 * @author M. Calla
 */
public class Porfolio {

    private Long idportfolio;
    private String description;
    private String experience_summary;
    private Long id;
    private String image_url;
    private String last_names;
    private String names;
    private String tittle;
    private String twitter_user_id;
    private String twitter_user_name;
    private String user_id;

    public Porfolio() {
    }

    public Porfolio(Long idportfolio, String description, String experience_summary, Long id, String image_url, String last_names, String names, String tittle, String twitter_user_id, String twitter_user_name, String user_id) {
        this.idportfolio = idportfolio;
        this.description = description;
        this.experience_summary = experience_summary;
        this.id = id;
        this.image_url = image_url;
        this.last_names = last_names;
        this.names = names;
        this.tittle = tittle;
        this.twitter_user_id = twitter_user_id;
        this.twitter_user_name = twitter_user_name;
        this.user_id = user_id;
    }

    public Long getIdportfolio() {
        return idportfolio;
    }

    public void setIdportfolio(Long idportfolio) {
        this.idportfolio = idportfolio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience_summary() {
        return experience_summary;
    }

    public void setExperience_summary(String experience_summary) {
        this.experience_summary = experience_summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTwitter_user_id() {
        return twitter_user_id;
    }

    public void setTwitter_user_id(String twitter_user_id) {
        this.twitter_user_id = twitter_user_id;
    }

    public String getTwitter_user_name() {
        return twitter_user_name;
    }

    public void setTwitter_user_name(String twitter_user_name) {
        this.twitter_user_name = twitter_user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

}
