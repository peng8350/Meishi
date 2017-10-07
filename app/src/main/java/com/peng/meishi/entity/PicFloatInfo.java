package com.peng.meishi.entity;

import android.os.Parcel;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

/**
 * Created by peng on 16-10-12.
 */
public class PicFloatInfo implements AsymmetricItem {
    private int width;
    private int height;
    private MeishiInfo meishi;

    public PicFloatInfo(int width, int height, MeishiInfo meishi) {
        this.width = width;
        this.height = height;
        this.meishi = meishi;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MeishiInfo getMeishi() {
        return meishi;
    }

    public void setMeishi(MeishiInfo meishi) {
        this.meishi = meishi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeParcelable(this.meishi, 0);
    }

    protected PicFloatInfo(Parcel in) {
        this.width = in.readInt();
        this.height = in.readInt();
        this.meishi = in.readParcelable(MeishiInfo.class.getClassLoader());
    }

    public static final Creator<PicFloatInfo> CREATOR = new Creator<PicFloatInfo>() {
        public PicFloatInfo createFromParcel(Parcel source) {
            return new PicFloatInfo(source);
        }

        public PicFloatInfo[] newArray(int size) {
            return new PicFloatInfo[size];
        }
    };

    @Override
    public int getColumnSpan() {
        return width;
    }

    @Override
    public int getRowSpan() {
        return height;
    }
}
