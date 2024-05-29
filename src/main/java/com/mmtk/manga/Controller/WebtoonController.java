package com.mmtk.manga.Controller;

import com.mmtk.manga.Model.Webtoon;
import com.mmtk.manga.Repository.WebtoonRepository;
import com.mmtk.manga.Service.WebtoonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class WebtoonController {

    private final WebtoonService webtoonService;
    private final WebApplicationContext webApplicationContext;
    private final WebtoonRepository webtoonRepository;

    public WebtoonController(WebtoonService webtoonService, WebApplicationContext webApplicationContext, WebtoonRepository webtoonRepository) {
        this.webtoonService = webtoonService;
        this.webApplicationContext = webApplicationContext;
        this.webtoonRepository = webtoonRepository;
    }

    @PostMapping("/uploadWebtoon")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestBody MultipartFile file,@RequestBody Webtoon webtoon) throws IOException {
        String uploadWebtoon = webtoonService.webtoonAdd(webtoon, file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadWebtoon);
    }

    @DeleteMapping("/deleteWebtoon/{id}")
    public ResponseEntity<String> deleteWebtoon(@PathVariable Long id){
        try {
            webtoonRepository.deleteById(id);
            return new ResponseEntity<>("Webtoon deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete webtoon", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
