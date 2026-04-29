package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CabController {

    List<Map<String, String>> bookings = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "Cab Booking System Running";
    }

    @PostMapping("/book")
    public String bookCab(@RequestBody Map<String, String> booking) {
        bookings.add(booking);
        return "Booking Added";
    }

    @GetMapping("/bookings")
    public List<Map<String, String>> getBookings() {
        return bookings;
    }
}