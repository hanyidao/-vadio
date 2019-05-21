package com.svs.bupei.vadio.mapper;

import com.svs.bupei.vadio.pojo.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface QuestionMapper {

    /**
     * 模糊查询所有数据
     * @param question
     * @return
     */
    @Select("select qid,vid,qtext,uname,qdate,qdelete from question where uname like concat('%',ifNull(#{uname},''), '%') and vid like concat('%',ifNull(#{vid},''), '%') and qdelete = '未删除' limit #{page}, #{limit}")
    List<Question> selectAllQuestion(Question question);

    /**
     * 模糊查询后的数据总个数
     * @param question
     * @return
     */
    @Select("select count(qid) from question where uname like concat('%',ifNull(#{uname},''), '%') and vid like concat('%',ifNull(#{vid},''), '%') and qdelete = '未删除'")
    int selectCountQuestion(Question question);

    /**
     * 添加一条评论
     * @param question
     * @return
     */
    @Insert("insert into question(vid,qtext,uname,qdate,qdelete) values(#{vid},#{qtext},#{uname},#{qdate},#{qdelete})")
    int insertQuestion(Question question);

    /**
     * 删除一条评论
     * @param qid
     * @return
     */
    @Update("update question set qdelete = '已删除' where qid = #{qid}")
    int deleteQuestion(int qid);

    /**
     * 更新一条评论
     * @param question
     * @return
     */
    @Update("update question set qtext = #{qtext}, qdate = #{qdate} where qid = #{qid}")
    int updateQuestion(Question question);

}
