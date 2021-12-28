package com.haierbiomedical.deviceaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DoorBean implements Parcelable {

    private String doorType;//锁控类型 1

    private String index;

    private String status;

    private String result;

    private String remark;

    protected DoorBean(Parcel in) {
    }

    public static final Creator<DoorBean> CREATOR = new Creator<DoorBean>() {
        @Override
        public DoorBean createFromParcel(Parcel in) {
            return new DoorBean(in);
        }

        @Override
        public DoorBean[] newArray(int size) {
            return new DoorBean[size];
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
        this.doorType = parcel.readString();
        this.index = parcel.readString();
        this.remark = parcel.readString();
        this.result = parcel.readString();
        this.status = parcel.readString();
    }


}
