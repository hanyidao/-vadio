package com.svs.bupei.vadio.other.mapper;

import com.svs.bupei.vadio.other.pojo.ReportText;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReportTextMapper {

    /**
     * 模糊查询所有数据
     * @param reportText
     * @return
     */
    @Select("select reid,qid,uname,retext,redate,resuccess from reporttext where uname like concat('%',ifNull(#{uname},''), '%') and resuccess = #{resuccess} limit #{page},#{limit}")
    List<ReportText> selectAllReportText(ReportText reportText);

    /**
     * 返回模糊查询后所有数据个数
     * @param reportText
     * @return
     */
    @Select("select count(reid) from reporttext where uname like concat('%',ifNull(#{uname},''), '%') and resuccess = #{resuccess}")
    int selectCountReportText(ReportText reportText);

    /**
     * 添加一条举报评论信息
     * @param reportText
     * @return
     */
    @Insert("insert into reporttext(qid,uname,retext,redate,resuccess) values(#{qid},#{uname},#{retext},#{redate},#{resuccess})")
    int insertReportText(ReportText reportText);

    /**
     * 删除一条评论信息
     * @param reid
     * @return
     */
    @Delete("delete from reporttext where reid = #{reid}")
    int deleteReportText(int reid);

    /**
     * 管理员处理一条信息
     * @param reportText
     * @return
     */
    @Update("update reporttext set resuccess = #{resuccess} where reid = #{reid}")
    int managerUpdateReportText(ReportText reportText);

    /**
     * 管理员处理一条信息后将该信息删除
     * @param reid
     * @return
     */
    @Update("update question set qdelete = '已删除' where qid = (select qid from reporttext where reid = #{reid})")
    int updateReportTextQuestion(int reid);
}
