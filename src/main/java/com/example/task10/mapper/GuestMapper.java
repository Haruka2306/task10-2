package com.example.task10.mapper;

import com.example.task10.controller.response.GuestResponse;
import com.example.task10.entity.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GuestMapper {
    @Select("Select * FROM guests")
    List<Guest> findAll();

    //id検索
    @Select("SELECT * FROM guests WHERE id = #{id}")
    Optional<GuestResponse> findGuestById(int id);
}
