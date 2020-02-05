package com.newer.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomMapper {
    @Select("select distinct roomtype from rooms")
    List<String> findTypes();
    @Select("select roomid from rooms where roomtype=#{roomtype} and state=1")
    List<Integer>findRoomId(@Param("roomtype")String roomtype);

}
