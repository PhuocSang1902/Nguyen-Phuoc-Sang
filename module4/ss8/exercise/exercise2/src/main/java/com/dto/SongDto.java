package com.dto;

import javax.validation.constraints.Pattern;

public class SongDto {
    private Integer id;
    @Pattern(regexp = "^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]+)$", message = "{invalid}")
    private String name;
    @Pattern(regexp = "^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]+)$", message = "{invalid}")
    private String singer;
//    @Pattern(regexp = "^(Trữ tình)|(Nhạc trẻ)|(Nhạc vàng)|(Nhạc đỏ)$", message = "{invalid}")
    private String songType;
    private String link;

    public SongDto() {
    }

    public SongDto(Integer id, String name, String singer, String songType, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.songType = songType;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
