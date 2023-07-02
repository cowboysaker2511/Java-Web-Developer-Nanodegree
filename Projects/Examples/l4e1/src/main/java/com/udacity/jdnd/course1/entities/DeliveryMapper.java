package com.udacity.jdnd.course1.entities;

import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;

@Mapper
public interface DeliveryMapper {
    @Select("SELECT * FROM Delivery WHERE id = #{deliveryId}")
    Delivery findDelivery(Integer deliveryId);

    @Insert("INSERT INTO Delivery(orderId, time) VALUES(#{orderId}, #{time}")
    @Options (useGeneratedKeys = true, keyProperty = "id")
    int insertDelivery(Integer orderId, LocalDateTime time);

    @Delete("DELETE FROM Delivery WHERE id = #{deliveryId}")
    int deleteDelivery(Integer deliveryId);

}
