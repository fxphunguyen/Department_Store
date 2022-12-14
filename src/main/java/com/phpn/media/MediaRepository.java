package com.phpn.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.fx.qh.sapo.entities.media.Media;
import java.util.Optional;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, String> {
    @Query("SELECT m FROM Media AS m WHERE m.productId = :productId")
    List<Media> findAllById(@Param("productId") Integer productId);

    @Query(value = "call sp_getLinkMediaByProductIdIsMain(:productId)", nativeQuery = true)
    Optional<String> getLinkMediaByProductIdIsMain(@Param("productId") Integer productId);
}
