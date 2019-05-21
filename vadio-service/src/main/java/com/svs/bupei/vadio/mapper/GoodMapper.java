package com.svs.bupei.vadio.mapper;

import com.svs.bupei.vadio.pojo.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper {

    /**
     * 模糊查询所有数据
     * @param good
     * @return
     */
    @Select("select gid,gdate,gnum,uname,vid from good where uname like concat('%',ifNull(#{uname},''), '%') and vid like concat('%',ifNull(#{vid},''), '%')")
    List<Good> selectAllGood(Good good);

    /**
     * 模糊查询数据总个数
     * @param good
     * @return
     */
    @Select("select count(gid) from good where uname like concat('%',ifNull(#{uname},''), '%') and vid like concat('%',ifNull(#{vid},''), '%')")
    int selectCountGood(Good good);

    /**
     * 添加一条点赞信息
     * @param good
     * @return
     */
    @Insert("insert into good(gid,gdate,gnum,uname,vid) values(#{gid},#{gdate},#{gnum},#{uname},#{vid})")
    int insertGood(Good good);

    /**
     * 删除一条点赞信息
     * @param good
     * @return
     */
    @Delete("delete from good where uname = #{uname} and vid = #{vid}")
    int deleteGood(Good good);

}
