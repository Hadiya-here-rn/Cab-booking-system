package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CabController {

    List<Map<String, String>> bookings = new ArrayList<>();

    // CREATE
    @PostMapping("/book")
public String bookCab(@RequestBody Map<String, String> booking) {
    booking.put("time", new Date().toString());   // timestamp
    booking.put("status", "Booked");              // status
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

        Map<String, String> old = bookings.get(id);

        old.put("name", newBooking.get("name"));
        old.put("location", newBooking.get("location"));

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
    @PutMapping("/complete/{id}")
public String completeRide(@PathVariable int id) {
    if (id < bookings.size()) {
        bookings.get(id).put("status", "Completed");
        return "Ride Completed";
    }
    return "Invalid ID";
}

    // HOME
    @GetMapping("/home")
    public String home() {
        return "Cab Booking System Running";
    }
}