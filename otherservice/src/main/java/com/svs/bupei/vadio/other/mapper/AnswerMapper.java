package com.svs.bupei.vadio.other.mapper;

import com.svs.bupei.vadio.other.pojo.Answer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnswerMapper {

    /**
     * 模糊查询数据
     * @param answer
     * @return
     */
    @Select("select aid,uname,akeyword,atext from answer where uname like concat('%',ifNull(#{uname},''), '%') limit #{page}, #{limit}")
    List<Answer> selectAllAnswer(Answer answer);

    /**
     * 返回模糊查询数据总数
     * @param answer
     * @return
     */
    @Select("select count(aid) from answer where uname like concat('%',ifNull(#{uname},''), '%')")
    int selectCountAnswer(Answer answer);

    /**
     * 添加一条自动回复信息
     * @param answer
     * @return
     */
    @Insert("insert into answer(uname,akeyword,atext) values(#{uname}, #{akeyword}, #{atext})")
    int insertAnswer(Answer answer);

    /**
     * 按主键删除一条信息
     * @param aid
     * @return
     */
    @Delete("delete from answer where aid = #{aid}")
    int deleteAnswer(int aid);

    /**
     * 更新一条自动回复信息
     * @param answer
     * @return
     */
    @Update("update answer set akeyword = #{akeyword}, atext = #{atext} where aid = #{aid}")
    int updateAnswer(Answer answer);

}
