package com.example.travel.mapper;

import com.example.travel.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token")String token);

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,bio,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    public void insert(User user);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}
