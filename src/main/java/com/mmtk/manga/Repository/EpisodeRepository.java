package com.mmtk.manga.Repository;

import com.mmtk.manga.Model.Episode;
import com.mmtk.manga.Model.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {

}
