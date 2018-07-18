package com.mostcloud.layoutindex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    @Expose
    @SerializedName("user_key")
    public String user_key;
    @Expose
    @SerializedName("country")
    private String country;
    @Expose
    @SerializedName("postal_code")
    private String postal_code;
    @Expose
    @SerializedName("city")
    private String city;
    @Expose
    @SerializedName("gender")
    private String gender;
    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("fb_token")
    private String fb_token;
    @Expose
    @SerializedName("nic")
    private String nic;
    @Expose
    @SerializedName("mobile")
    private String mobile;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("address")
    private String address;
    @Expose
    @SerializedName("l_name")
    private String l_name;
    @Expose
    @SerializedName("f_name")
    private String f_name;
    @Expose
    @SerializedName("user_promo_code")
    public String user_promo_code;
    @Expose
    @SerializedName("title")
    public String title;


    public User(String user_key, String title, String country, String postal_code, String city, String gender, String image, String fb_token, String nic, String mobile, String email, String address, String l_name, String f_name, String user_promo_code) {
        this.user_key = user_key;
        this.title = title;
        this.country = country;
        this.postal_code = postal_code;
        this.city = city;
        this.gender = gender;
        this.image = image;
        this.fb_token = fb_token;
        this.nic = nic;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.l_name = l_name;
        this.f_name = f_name;
        this.user_promo_code = user_promo_code;
    }

    public String getTitle() {
        return title;
    }

    public String getUser_key() {
        return user_key;
    }

    public String getCountry() {
        return country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    public String getFb_token() {
        return fb_token;
    }

    public String getNic() {
        return nic;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getL_name() {
        return l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public String getUser_promo_code() {
        return user_promo_code;
    }
}
