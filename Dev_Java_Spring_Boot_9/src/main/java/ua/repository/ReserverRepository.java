package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.UserReserver;

public interface ReserverRepository extends JpaRepository<UserReserver, Integer> {
	
}
