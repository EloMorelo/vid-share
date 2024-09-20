package com.vd.vid_share.repository;

import com.vd.vid_share.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VidRepo extends JpaRepository<Video, UUID> {

}
