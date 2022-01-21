package com.example.pukaaradmin.Response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ForumResponse {

    @SerializedName("data")
    public ArrayList<FirstDatum>  Fdata = null;

    public class FirstDatum {

        @SerializedName("id")
        public int id = 0;

        @SerializedName("content")
        public String content = "";

        @SerializedName("picture")
        public String picture = "";

        @SerializedName("user_id")
        public String userId = "";

        @SerializedName("created_at")
        public String createdAt = "";

        @SerializedName("updated_at")
        public String updatedAt = "";

        @SerializedName("comments")
        public ArrayList<Datum> comments;

        public FirstDatum.userData getUserData() {
            return userData;
        }

        public void setUserData(FirstDatum.userData userData) {
            this.userData = userData;
        }

        @SerializedName("user")
        public userData userData;


        public class Datum {
            @SerializedName("id")
            public int id;
            @SerializedName("comment")
            public String comment;

            @SerializedName("post_id")
            public String post_id = "";

            @SerializedName("user_id")
            public String userId = "";

            @SerializedName("created_at")
            public String createdAt = "";

            @SerializedName("updated_at")
            public String updatedAt = "";

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getPost_id() {
                return post_id;
            }

            public void setPost_id(String post_id) {
                this.post_id = post_id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
public class userData{
    @SerializedName("id")
    public int id;

    @SerializedName("first_name")
    public String  first_name ="";

      @SerializedName("last_name")
    public String last_name = "";

    @SerializedName("mobile_number")
    public String mobile_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public ArrayList<Datum> getComments() {
            return comments;
        }

        public void setComments(ArrayList<Datum> comments) {
            this.comments = comments;
        }

       /* public FirstDatum.userData getUserData() {
            return userData;
        }

        public void setUserData(FirstDatum.userData userData) {
            this.userData = userData;
        }*/
    }

}
