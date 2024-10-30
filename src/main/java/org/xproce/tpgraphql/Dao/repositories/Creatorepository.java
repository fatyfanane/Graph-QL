package org.xproce.tpgraphql.Dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.tpgraphql.Dao.entities.Creator;
import org.xproce.tpgraphql.Dao.entities.Video;

public interface Creatorepository extends JpaRepository<Creator,Integer> {
}
