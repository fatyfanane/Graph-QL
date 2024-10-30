package org.xproce.tpgraphql.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.xproce.tpgraphql.Dao.entities.Creator;
import org.xproce.tpgraphql.Dao.entities.Video;
import org.xproce.tpgraphql.Dao.repositories.Creatorepository;
import org.xproce.tpgraphql.Dao.repositories.Videorepository;

import java.util.List;

@Controller
public class VideoGraphQlController {

    private final Creatorepository creatorRepository;
    private final Videorepository videoRepository;

    @Autowired
    public VideoGraphQlController(Creatorepository creatorRepository, Videorepository videoRepository) {
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }

    @QueryMapping
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Integer id) {
        return creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", id)));
    }
}
