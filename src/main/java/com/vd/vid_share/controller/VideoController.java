package com.vd.vid_share.controller;

import com.vd.vid_share.entities.Video;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.vd.vid_share.service.VideoService;
import java.util.List;

@Controller
public class VideoController {

    VideoService videoService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Video> videos = videoService.getAllVideos();
        model.addAttribute("videos", videos);
        return "index";
    }
    

}
