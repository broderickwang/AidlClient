package com.haierbiomedical.deviceaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class FingerBean implements Parcelable {

    private String fingerType;

    private String index;

    private String result;

    private String status;

    private String remark;

    protected FingerBean(Parcel in) {
    }

    public static final Creator<FingerBean> CREATOR = new Creator<FingerBean>() {
        @Override
        public FingerBean createFromParcel(Parcel in) {
            return new FingerBean(in);
        }

        @Override
        public FingerBean[] newArray(int size) {
            return new FingerBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public void readFromParcel(Parcel parcel){
        this.fingerType = parcel.readString();
        this.index = parcel.readString();
        this.remark = parcel.readString();
        this.result = parcel.readString();
        this.status = parcel.readString();
    }
}
