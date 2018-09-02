package com.epam.agency.controller;

import com.epam.agency.domain.Hotel;
import com.epam.agency.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class HotelController {
    private HotelService hotelService;

    @GetMapping(value = "/hotels")
    public String findAllHotels(HttpServletRequest request) {
        List<Hotel> hotels = hotelService.findAll();
        request.getSession().setAttribute("hotelList", hotels);
        return PageName.HOTELS.getValue();
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping(value = "/remove_hotel{id}")
//    public String removeHotel(@PathVariable("id") Long id, HttpServletRequest request) {
//        hotelService.delete(hotelService.findById(id));
//        return "redirect:/hotels";
//    }
//
}