package com.mmtk.manga.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    private String episodeName;
    private long uploadDate;
    @ManyToOne
    private Webtoon webtoon;

    public Episode() {
    }

    public Episode(Long eid, String episodeName, long uploadDate, Webtoon webtoon) {
        this.eid = eid;
        this.episodeName = episodeName;
        this.uploadDate = uploadDate;
        this.webtoon = webtoon;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public long getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(long uploadDate) {
        this.uploadDate = uploadDate;
    }
}
