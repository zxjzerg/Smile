package com.zxjdev.smile.domain.moment;

import com.zxjdev.smile.domain.user.User;

import java.util.Date;

public class Moment {

  private String id;
  private Date createAt;
  private String content;
  private User owner;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }
}
