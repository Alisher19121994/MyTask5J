package com.best.mytask5j.Users;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {
 String name;
 int id;

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(id);
    }
    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel source) {
            String name = source.readString();
            int id = source.readInt();
            return new Member(name, id);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };
}
