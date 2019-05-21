package com.svs.bupei.vadio.other.mapper;

import com.svs.bupei.vadio.other.pojo.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReportMapper {

    /**
     * 模糊查询所有数据
     * @param report
     * @return
     */
    @Select("select rid,vid,uname,rtext,rdate,rsuccess from report where vid like concat('%',ifNull(#{vid},''), '%') and uname like concat('%',ifNull(#{uname},''), '%') and rsuccess = #{rsuccess} limit #{page}, #{limit}")
    List<Report> selectAllReport(Report report);

    /**
     * 模糊查询后的数据总数
     * @param report
     * @return
     */
    @Select("select count(rid) from report where vid like concat('%',ifNull(#{vid},''), '%') and uname like concat('%',ifNull(#{uname},''), '%') and rsuccess = #{rsuccess}")
    int selectCountReport(Report report);

    /**
     * 添加一条数据
     * @param report
     * @return
     */
    @Insert("insert into report(vid,uname,rtext,rdate,rsuccess) values(#{vid},#{uname},#{rtext},#{rdate},#{rsuccess})")
    int insertReport(Report report);

    /**
     * 删除一条举报信息
     * @param rid
     * @return
     */
    @Delete("delete from report where rid = #{rid}")
    int deleteReport(int rid);

    /**
     * 管理员同意举报信息
     * @param report
     * @return
     */
    @Update("update report set rsuccess = #{rsuccess} where rid = #{rid}")
    int managerUpdateReport(Report report);

    /**
     * 当管理员同意一个举报信息后将视频删除
     * @param rid
     * @return
     */
    @Update("update vadio set vdelete = '已删除' where vid = (select vid from report where rid = #{rid})")
    int updateReportVadio(int rid);
}
