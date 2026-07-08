package com.irem.innerflowbooking.repository;
import com.irem.innerflowbooking.entity.Session;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findAllByOrderByIdAsc();
}
