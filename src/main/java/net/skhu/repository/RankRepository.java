package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.rank;

public interface RankRepository extends JpaRepository<rank, Integer> {
	List<rank> findAllByOrderByPayDesc();
}
