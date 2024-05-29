package com.mmtk.manga.Service;

import com.mmtk.manga.Model.Webtoon;
import com.mmtk.manga.Repository.WebtoonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

import java.io.File;
import java.io.IOException;

@Service
public class WebtoonService {

    private final WebtoonRepository webtoonRepository;

    public WebtoonService(WebtoonRepository webtoonRepository) {
        this.webtoonRepository = webtoonRepository;
    }


    public String webtoonAdd(Webtoon webtoon, MultipartFile file) throws IOException {

        String folderPath = "A:/Trash/";

        String filePath = folderPath + file.getOriginalFilename();

        Webtoon newWebtoon = new Webtoon();
        newWebtoon.setWebtoonName(webtoon.getWebtoonName());
        newWebtoon.setWebtoonDesciption(webtoon.getWebtoonDesciption());
        newWebtoon.setCategories(webtoon.getCategories());
        newWebtoon.setUploadDate(Instant.now().toEpochMilli());
        newWebtoon.setFilePath(filePath);

        try {
            webtoonRepository.save(newWebtoon);
            File folder = new File(folderPath);
            folder.mkdirs();
            file.transferTo(new File(filePath));
            return "file uploaded successfully : " + filePath;
        }catch (IOException e) {
            // Handle file-related exceptions
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            return "An unexpected error occurred: " + e.getMessage();
        }
    }
}
