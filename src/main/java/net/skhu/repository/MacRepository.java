package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.mac;
import net.skhu.domain.rank;

public interface MacRepository extends JpaRepository<mac, Integer> {
	List<mac> findAll();
}
