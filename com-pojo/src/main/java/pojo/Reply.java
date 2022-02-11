package pojo;

import lombok.Data;

import java.util.List;


@Data
public class Reply {
    private int id;
    private int videos_id;
    private int user_id;
    private String text;
    private int last_id;
    private String rtime;

    private String name;
    private String avatar;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", videos_id=" + videos_id +
                ", user_id=" + user_id +
                ", text='" + text + '\'' +
                ", last_id=" + last_id +
                ", rtime='" + rtime + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideos_id() {
        return videos_id;
    }

    public void setVideos_id(int videos_id) {
        this.videos_id = videos_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLast_id() {
        return last_id;
    }

    public void setLast_id(int last_id) {
        this.last_id = last_id;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }
}
