package com.vd.vid_share.controller;

import com.vd.vid_share.entities.User;
import com.vd.vid_share.entities.Video;
import com.vd.vid_share.service.UserService;
import com.vd.vid_share.service.VideoService;
import com.vd.vid_share.secure.UserDet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Video> videos = videoService.getAllVideos();
        model.addAttribute("videos", videos);
        return "index";
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            UserDet userDet = (UserDet) authentication.getPrincipal();
            User user = userDet.getUser();
            model.addAttribute("userId", user.getId());
        }
        return "upload";
    }


    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("file") MultipartFile file, @RequestParam("userId") UUID userId, Model model) {
         try {
             User user = userService.getUserById(userId);
             Video savedVideo = videoService.saveVideo(file,title,description,user);
             model.addAttribute("message", "Video uploaded successfully!");
             return "redirect:/ ";
         } catch (IOException e) {
            model.addAttribute("message", "Failed to upload :" + e.getMessage());
        }
        return "index";
    }

}
