package com.exercise_extra.repository;

import com.exercise_extra.model.Phim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhimRepository extends JpaRepository<Phim, Long> {
}
