package com.example.task10.controller;

import com.example.task10.controller.form.GuestCreateForm;
import com.example.task10.controller.response.GuestResponse;
import com.example.task10.entity.Guest;
import com.example.task10.exception.ResourceNotFoundException;
import com.example.task10.service.GuestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class GuestController {

    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    public List<GuestResponse> guests() {
        List<Guest> guests = guestService.findAll();
        List<GuestResponse> guestResponses = guests.stream().map(guest -> new GuestResponse(guest.getId(), guest.getName(), guest.getAge())).toList();
        return guestResponses;
    }

    @GetMapping("/guests/{id}")
    public GuestResponse findGuestById (@PathVariable("id") int id){
        return guestService.findGuestById(id);
    }
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guests")
    public ResponseEntity<Guest> createGuest(@RequestBody GuestCreateForm guestCreateForm) {
        Guest guest = guestService.createGuest(guestCreateForm);
        Guest guestResponse = new Guest(guestCreateForm.getId(), guestCreateForm.getName(), guestCreateForm.getAge(), guestCreateForm.getAddress());

        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/guests/" + guestResponse.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(guestResponse);
    }
}



