package com.zh.mapper;

import com.zh.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author xmr
 * @date 2019/7/28 15:00
 * @description
 */
@Mapper
public interface UserMapper {
   @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
   void insert(User user);
}
