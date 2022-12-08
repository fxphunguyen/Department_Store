package com.phpn.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fx.qh.sapo.entities.media.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, String> {
}
