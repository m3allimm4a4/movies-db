package com.beshara.moviesdbapi.dao.creator;

import com.beshara.moviesdbapi.models.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorDao extends JpaRepository<Creator, Long> {
}
