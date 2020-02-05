package com.newer.service;

import com.newer.mapper.RoomMapper;
import com.newer.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoomService {
    private RoomMapper roomMapper;
    private SqlSession sqlSession;

    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        roomMapper=sqlSession.getMapper(RoomMapper.class);
    }
    public List<String> findTytes(){
        init();
        List<String>list=roomMapper.findTypes();
        SqlSessionUtil.close(sqlSession);
        return list;
    }
    //根据房间类型查询所有房间几何
    public List<Integer> findRoomId(String roomtype){
        init();
        List<Integer>list=roomMapper.findRoomId(roomtype);
        SqlSessionUtil.close(sqlSession);
        return list;
    }
}
