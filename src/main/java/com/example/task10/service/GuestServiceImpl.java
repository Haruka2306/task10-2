package com.example.task10.service;

import com.example.task10.controller.form.GuestCreateForm;
import com.example.task10.controller.response.GuestResponse;
import com.example.task10.entity.Guest;
import com.example.task10.exception.ResourceNotFoundException;
import com.example.task10.mapper.GuestMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {
    private GuestMapper guestMapper;

    public GuestServiceImpl(GuestMapper guestMapper) {
        this.guestMapper = guestMapper;
    }

    @Override
    public List<Guest> findAll() {
        return guestMapper.findAll();
    }

    @Override
    public GuestResponse findGuestById(int id) {
        Optional<GuestResponse> guestResponse = guestMapper.findGuestById(id);
        return guestResponse.orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
    }

    @Override
    public Guest createGuest(GuestCreateForm guestCreateForm) {
        Guest guest = new Guest(
                0,
                guestCreateForm.getName(),
                guestCreateForm.getAge(),
                guestCreateForm.getAddress());

        return guest;
    }
}
