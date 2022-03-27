package com.best.mytask5j.Users;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
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
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            String name = source.readString();
            int id = source.readInt();
            return new User(name, id);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
