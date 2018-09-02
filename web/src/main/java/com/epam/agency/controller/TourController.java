package com.epam.agency.controller;

import com.epam.agency.domain.Client;
import com.epam.agency.domain.Tour;
import com.epam.agency.service.ClientService;
import com.epam.agency.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class TourController {
    private TourService tourService;

    private ClientService clientService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/tours")
    public String findAllTours(HttpServletRequest request) {
        List<Tour> tours = tourService.findAll();
        request.getSession().setAttribute("tourList", tours);
        return PageName.TOURS.getValue();
    }

//    @PreAuthorize("hasAuthority('MEMBER')")
//    @GetMapping(value = "/order_tour{id}")
//    public String orderTour(@PathVariable("id") Long id, HttpServletRequest request) {
//        Client client = (Client) request.getSession().getAttribute("user");
//        Tour tour = tourService.findById(id);
////        client.addTour(tour);
//        clientService.update(client);
//        return PageName.REDIRECT.getValue();
//    }

//    @PreAuthorize("hasAuthority('MEMBER')")
//    @GetMapping(value = "/remove_tour{id}")
//    public String removeUserTour(@PathVariable("id") int id, HttpServletRequest request) {
//        Client client = (Client) request.getSession().getAttribute("user");
////        client.removeTour(id);
//        clientService.update(client);
//        return "redirect:/mytours";
//    }
//
//
//    @GetMapping(value = "/user_tracks")
//    public String showUserTracks(Model model, HttpServletRequest request) {
//        Client client = (Client) request.getSession().getAttribute("user");
////        model.addAttribute("userTours", client.getTours());
//        return USER_TOURS;
//    }


}