package com.irem.innerflowbooking.repository;

import com.irem.innerflowbooking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}