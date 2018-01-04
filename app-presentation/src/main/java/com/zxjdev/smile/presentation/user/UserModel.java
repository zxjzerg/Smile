package com.zxjdev.smile.presentation.user;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrew on 7/6/16.
 */
public class UserModel implements Parcelable {

  private String username;
  private String avatar;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  @Override
  public int describeContents() { return 0; }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.username);
    dest.writeString(this.avatar);
  }

  public UserModel() {}

  protected UserModel(Parcel in) {
    this.username = in.readString();
    this.avatar = in.readString();
  }

  public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
    @Override
    public UserModel createFromParcel(Parcel source) {return new UserModel(source);}

    @Override
    public UserModel[] newArray(int size) {return new UserModel[size];}
  };
}
