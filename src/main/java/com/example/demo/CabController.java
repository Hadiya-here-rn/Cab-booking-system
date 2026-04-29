package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CabController {

    List<Map<String, String>> bookings = new ArrayList<>();

    // CREATE
    @PostMapping("/book")
    public String bookCab(@RequestBody Map<String, String> booking) {
        bookings.add(booking);
        return "Booking Added";
    }

    // READ
    @GetMapping("/bookings")
    public List<Map<String, String>> getBookings() {
        return bookings;
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String updateBooking(@PathVariable int id, @RequestBody Map<String, String> newBooking) {
        if (id < bookings.size()) {
            bookings.set(id, newBooking);
            return "Booking Updated";
        }
        return "Invalid ID";
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable int id) {
        if (id < bookings.size()) {
            bookings.remove(id);
            return "Booking Deleted";
        }
        return "Invalid ID";
    }

    // HOME
    @GetMapping("/")
    public String home() {
        return "Cab Booking System Running";
    }
}