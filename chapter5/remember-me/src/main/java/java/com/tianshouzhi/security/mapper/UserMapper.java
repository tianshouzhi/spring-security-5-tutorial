package java.com.tianshouzhi.security.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tianshouzhi.security.entity.UserEntity;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username=#{username}")
    UserEntity loadUserByUsername(@Param("username") String username);

    @Insert("INSERT INTO user(username,password,age,birthday) " +
            "VALUES(#{username},#{password},#{age},#{birthday})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insert(UserEntity userEntity);
}
