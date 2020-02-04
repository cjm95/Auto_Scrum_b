package com.bespin.auto.mappers;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	int selectBoardListCnt() throws Exception;
	
	
}