package com.launchacademy.marathon.repositories;

import com.launchacademy.marathon.models.Songs;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends PagingAndSortingRepository<Songs, Integer> {
  public List<Songs> findAll();
}
