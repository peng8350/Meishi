package com.peng.meishi.entity;

import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

import android.os.Parcel;

/**
 * Created by peng on 16-10-9.
 */
public class MyBean implements AsymmetricItem {
	public static final Creator<MyBean> CREATOR = new Creator<MyBean>() {
		public MyBean createFromParcel(Parcel source) {
			return new MyBean(source);
		}

		public MyBean[] newArray(int size) {
			return new MyBean[size];
		}
	};
	private int columnSpan;
	private int rowSpan;
	private int position;

	public MyBean(int columnSpan, int rowSpan, int position) {
		this.columnSpan = columnSpan;
		this.rowSpan = rowSpan;
		this.position = position;
	}

	public MyBean() {

	}

	protected MyBean(Parcel in) {
		this.columnSpan = in.readInt();
		this.rowSpan = in.readInt();
		this.position = in.readInt();
	}

	@Override
	public int getColumnSpan() {
		return columnSpan;
	}

	@Override
	public int getRowSpan() {
		return rowSpan;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.columnSpan);
		dest.writeInt(this.rowSpan);
		dest.writeInt(this.position);
	}
}
