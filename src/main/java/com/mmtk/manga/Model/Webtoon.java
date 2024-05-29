package com.mmtk.manga.Model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Table
public class Webtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wid;
    private String webtoonName;
    private String webtoonDesciption;
    private String categories;
    private long uploadDate;
    private String filePath;
    @OneToMany(mappedBy = "webtoon")
    private List<Episode> episode;

    public Webtoon() {
    }

    public Webtoon(Long wid, String webtoonName, String webtoonDesciption, String categories, long uploadDate, String filePath, List<Episode> episode) {
        this.wid = wid;
        this.webtoonName = webtoonName;
        this.webtoonDesciption = webtoonDesciption;
        this.categories = categories;
        this.uploadDate = uploadDate;
        this.filePath = filePath;
        this.episode = episode;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getWebtoonName() {
        return webtoonName;
    }

    public void setWebtoonName(String webtoonName) {
        this.webtoonName = webtoonName;
    }

    public String getWebtoonDesciption() {
        return webtoonDesciption;
    }

    public void setWebtoonDesciption(String webtoonDesciption) {
        this.webtoonDesciption = webtoonDesciption;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public long getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(long uploadDate) {
        this.uploadDate = uploadDate;
    }

    public List<Episode> getEpisode() {
        return episode;
    }

    public void setEpisode(List<Episode> episode) {
        this.episode = episode;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
