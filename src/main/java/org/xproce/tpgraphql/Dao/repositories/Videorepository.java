package org.xproce.tpgraphql.Dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.tpgraphql.Dao.entities.Video;

public interface Videorepository extends JpaRepository<Video,Integer> {
}
