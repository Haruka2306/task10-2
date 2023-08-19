package com.example.task10.service;

import com.example.task10.controller.form.GuestCreateForm;
import com.example.task10.controller.response.GuestResponse;
import com.example.task10.entity.Guest;

import java.util.List;


public interface GuestService {
    List<Guest> findAll();
    GuestResponse findGuestById(int id);
    Guest createGuest(GuestCreateForm guestCreateForm);
}
