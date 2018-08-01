package com.ritikaneema.indorevisita;

public class Venue {
    // Venue items
    private String mTitle;
    private String mDescription;
    private String mLocation;
    private String mMapUrl;
    private String mTiming;
    private String mWebsite;
    private String mFee;

    private int mPhotoId;

    public Venue(String title, String description, String location, String mapUrl, String timing,
                 String website, String fee, int photoId){

        this.mTitle = title;
        this.mDescription = description;
        this.mLocation = location;
        this.mTiming = timing;
        this.mWebsite = website;
        this.mFee = fee;
        this.mMapUrl = mapUrl;
        this.mPhotoId = photoId;
    }

    public Venue(String title, String intro, String location,
                 String timing, String mapUrl, int photoId){

        this.mTitle = title;
        this.mDescription = intro;
        this.mLocation = location;
        this.mFee = timing;
        this.mMapUrl = mapUrl;
        this.mPhotoId = photoId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmTiming() {
        return mTiming;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public String getmFee() {
        return mFee;
    }

    public String getmMapUrl() {
        return mMapUrl;
    }

    public int getmPhotoId() {
        return mPhotoId;
    }
}
