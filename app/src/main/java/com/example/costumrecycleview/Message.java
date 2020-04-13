package com.example.costumrecycleview;


public class Message {

    private String mName;
    private int mMmgIdRec;
    private static boolean mLikeImg;


    public Message(String name, int imgIdRec, boolean mlike) {
        mName = name;
        mLikeImg = mlike;
        mMmgIdRec = imgIdRec;
    }

    static public boolean isLikeImg() {
        return mLikeImg;
    }

    static public void setLikeImg(boolean likeImg) {
        mLikeImg = likeImg;
    }

    public int getmMmgIdRec() {
        return mMmgIdRec;
    }


    public String getName() {
        return mName;
    }

}