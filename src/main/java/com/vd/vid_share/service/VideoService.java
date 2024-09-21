package com.vd.vid_share.service;

import com.vd.vid_share.entities.User;
import com.vd.vid_share.entities.Video;
import com.vd.vid_share.repository.VidRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VideoService {


    private final VidRepo vidRepo;

    public VideoService(VidRepo vidRepo) {
        this.vidRepo = vidRepo;
    }

    public List<Video> getAllVideos() {
        return vidRepo.findAll();
    }

    public Video saveVideo(MultipartFile file, String title, String description, User user) throws IOException {
        System.out.println("Uploading video: " + title);
        String uploadDir = "C:/Users/Kuba/Desktop/Projekty/vid-share/vid-share/VIDEO_UPLOAD/";
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        File fileToSave = new File(uploadDir + fileName);
        file.transferTo(fileToSave);
        System.out.println("file to save: " + fileToSave);
        System.out.println("user: " + user.getUsername());
        Video video = new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setFilePath(fileToSave.getPath());
        video.setUploadDate(LocalDateTime.now());
        video.setUser(user);

        return vidRepo.save(video);
    }
}
