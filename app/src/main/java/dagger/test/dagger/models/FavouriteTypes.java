package com.mostcloud.layoutindex.models;

/**
 * Created by Admin on 3/23/2018.
 */

public class FavouriteTypes {

    private String businessName;
    private String businessId;
    private String businessImage;

    public FavouriteTypes(String businessId, String businessName, String businessImage) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessImage = businessImage;
    }

    public String getBusinessId() {
        return businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getBusinessImage() {
        return businessImage;
    }

}
