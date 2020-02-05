package com.newer.test;

import com.newer.mapper.RoomMapper;
import com.newer.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class hoteltest {
@Test
    public void testFind(){
    SqlSession SqlSession = SqlSessionUtil.getSqlSession();
    RoomMapper roomMapper =SqlSession.getMapper(RoomMapper.class);
    roomMapper.findTypes().forEach(roomsTyte-> System.out.println(roomsTyte));
}
}
