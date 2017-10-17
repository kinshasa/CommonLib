package net.xicp.liushaobo.server.module;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liushaobo on 2017/10/17.
 */

public class Data implements Parcelable {
    public String name;

    protected Data(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
