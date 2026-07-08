
package com.irem.innerflowbooking.controller;

import com.irem.innerflowbooking.entity.Reservation;
import com.irem.innerflowbooking.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.irem.innerflowbooking.controller.UserController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.irem.innerflowbooking.service.SessionService;
import com.irem.innerflowbooking.entity.Session;
@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final SessionService sessionService;

    public ReservationController(
            ReservationService reservationService,
            SessionService sessionService) {

        this.reservationService = reservationService;
        this.sessionService = sessionService;
    }

    @GetMapping("/reserve/{sessionId}")
    public String reserveSession(@PathVariable Long sessionId) {

        Reservation reservation = new Reservation();

        reservation.setCustomerName(UserController.currentUser);
        reservation.setSessionId(sessionId);
        Session session = sessionService.getSessionById(sessionId);

        if (session != null) {
            reservation.setSessionTitle(session.getTitle());
        }

        reservationService.saveReservation(reservation);

        return "redirect:/";
    }

    @GetMapping("/reservations")
    public String showReservations(Model model) {

        model.addAttribute("reservations",
                reservationService.getAllReservations());

        return "reservations";
    }

    @GetMapping("/cancel/{id}")
    public String cancelReservation(@PathVariable Long id) {

        reservationService.deleteReservation(id);

        return "redirect:/reservations";
    }
    @GetMapping("/update/{id}")
    public String showUpdatePage(@PathVariable Long id,
                                 Model model) {

        Reservation reservation =
                reservationService.getReservationById(id);

        model.addAttribute("reservation", reservation);
        model.addAttribute("sessions",
                sessionService.getAllSessions());

        return "update-reservation";
    }
    @PostMapping("/update")
    public String updateReservation(
            @RequestParam Long reservationId,
            @RequestParam Long sessionId) {

        Reservation reservation =
                reservationService.getReservationById(reservationId);

        if (reservation != null) {

            reservation.setSessionId(sessionId);
            Session session = sessionService.getSessionById(sessionId);

            if (session != null) {
                reservation.setSessionTitle(session.getTitle());
            }

            reservationService.updateReservation(reservation);
        }

        return "redirect:/reservations";
    }
}