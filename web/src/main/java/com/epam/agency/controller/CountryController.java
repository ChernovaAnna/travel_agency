package com.epam.agency.controller;

import com.epam.agency.domain.Country;
import com.epam.agency.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class CountryController {
    private CountryService countryService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/countries")
    public String getCountryList(HttpServletRequest request) {
        List<Country> countries = countryService.findAll();
        request.getSession().setAttribute("countryList", countries);
        return PageName.COUNTRIES.getValue();
    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping(value = "/remove_country{id}")
//    public String removeCountry(@PathVariable("id") Long id, HttpServletRequest request) {
//        countryService.delete(countryService.findById(id));
//        return "redirect:/countries";
//    }
//
}