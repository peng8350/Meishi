package com.peng.meishi.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by peng on 16-10-12.
 */
public class MeishiInfo implements Parcelable {
	private String title;
	private String intro;
	private int id;
	private String pingjia;
	private String money;
	private float score;
	private String place;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPingjia() {
		return pingjia;
	}

	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public MeishiInfo(String title, String intro, int id) {
		this.title = title;
		this.intro = intro;
		this.id = id;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.title);
		dest.writeString(this.intro);
		dest.writeInt(this.id);
		dest.writeString(this.pingjia);
		dest.writeString(this.money);
		dest.writeFloat(this.score);
		dest.writeString(this.place);
	}

	protected MeishiInfo(Parcel in) {
		this.title = in.readString();
		this.intro = in.readString();
		this.id = in.readInt();
		this.pingjia = in.readString();
		this.money = in.readString();
		this.score = in.readFloat();
		this.place = in.readString();
	}

	public static final Creator<MeishiInfo> CREATOR = new Creator<MeishiInfo>() {
		public MeishiInfo createFromParcel(Parcel source) {
			return new MeishiInfo(source);
		}

		public MeishiInfo[] newArray(int size) {
			return new MeishiInfo[size];
		}
	};
}
