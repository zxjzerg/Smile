package com.zxjdev.smile.presentation.moment;

import android.os.Parcel;
import android.os.Parcelable;

import com.zxjdev.smile.presentation.user.UserModel;

import java.util.Date;

public class MomentModel implements Parcelable {

  private UserModel owner;
  private String content;
  private Date createAt;

  public UserModel getOwner() {
    return owner;
  }

  public void setOwner(UserModel owner) {
    this.owner = owner;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  @Override
  public int describeContents() { return 0; }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.owner, flags);
    dest.writeString(this.content);
    dest.writeLong(this.createAt != null ? this.createAt.getTime() : -1);
  }

  public MomentModel() {}

  protected MomentModel(Parcel in) {
    this.owner = in.readParcelable(UserModel.class.getClassLoader());
    this.content = in.readString();
    long tmpCreateAt = in.readLong();
    this.createAt = tmpCreateAt == -1 ? null : new Date(tmpCreateAt);
  }

  public static final Parcelable.Creator<MomentModel> CREATOR = new Parcelable.Creator<MomentModel>() {
    @Override
    public MomentModel createFromParcel(Parcel source) {return new MomentModel(source);}

    @Override
    public MomentModel[] newArray(int size) {return new MomentModel[size];}
  };
}
