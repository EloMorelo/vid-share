package com.vd.vid_share.service;

import com.vd.vid_share.entities.User;
import com.vd.vid_share.entities.Video;
import com.vd.vid_share.repository.VidRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VideoService {

    @Value("${video.storage.location}")
    private String storageLocation;

    private final VidRepo vidRepo;

    public VideoService(VidRepo vidRepo) {
        this.vidRepo = vidRepo;
    }

    public List<Video> getAllVideos() {
        List<Video> videos = vidRepo.findAll();
        System.out.println("Retrieved videos: " + videos);
        return videos;
    }



    public Video saveVideo(MultipartFile file, String title, String description, User user) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path videopath = Paths.get(storageLocation, fileName);
        System.out.println("path to video = " + videopath);

        if (Files.notExists(videopath.getParent())) {
            Files.createDirectories(videopath.getParent());
        }

        Files.write(videopath,file.getBytes());

        Video video = new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setFileName(fileName);
        video.setUploadDate(LocalDateTime.now());
        video.setUser(user);
        System.out.println("Video saved: " + video.getFileName() + " | " + video.getTitle());
        return vidRepo.save(video);
    }
}
