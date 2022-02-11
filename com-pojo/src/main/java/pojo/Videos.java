package pojo;

import lombok.Data;

import java.util.List;

@Data
public class Videos {
    private int vid;
    private String vtitle;
    private String vtext;
    private String vurl;
    private String vimg;
    private List<Reply> replies;
}
