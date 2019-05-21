package com.svs.bupei.vadio.mapper;

import com.svs.bupei.vadio.pojo.Vadio;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VadioMapper {

    /**
     * 查询所有数据（模糊查询+分页）
     * @param vadio 前台返回的数据模型
     * @return 模糊查询出的所有数据
     */
    @Select("select * from vadio where vname like concat('%' , ifNull(#{vname},'') , '%') and vtype like concat('%' , ifNull(#{vtype},'') , '%') and uname like concat('%' , ifNull(#{uname},'') , '%') and vsuccess = '已审核' and vdelete = '未删除' order by vlv desc limit #{page}, #{limit}")
    List<Vadio> selectAllVadio(Vadio vadio);

    /**
     * 返回所有已被管理员删除视频
     */
    @Select("select * from vadio where vname like concat('%' , ifNull(#{vname},'') , '%') and vtype like concat('%' , ifNull(#{vtype},'') , '%') and vdelete = '已删除' limit #{page},#{limit}")
    List<Vadio> selectDeleteVadio(Vadio vadio);

    @Select("select count(vid) from vadio where vname like concat('%' , ifNull(#{vname},'') , '%') and vtype like concat('%' , ifNull(#{vtype},'') , '%') and vdelete = '已删除'")
    int selectDeleteCountVadio(Vadio vadio);

    /**
     * 查询模糊查询后数据总个数
     * @param vadio
     * @return 模糊查询后数据个数
     */
    @Select("select count(vid) from vadio where vname like concat('%' , ifNull(#{vname},'') , '%') and vtype like concat('%' , ifNull(#{vtype},'') , '%') and uname like concat('%' , ifNull(#{uname},'') , '%') and vsuccess = '已审核' and vdelete = '未删除'")
    int selectCountVadio(Vadio vadio);

    /**
     * 插入一条vadio数据
     * @param vadio
     * @return
     */
    @Insert("insert into vadio(vid,vpath,vname,vtype,uname,vdate,vsuccess,vlv,vdelete) values(#{vid},#{vpath},#{vname},#{vtype},#{uname},#{vdate},#{vsuccess},#{vlv},#{vdelete})")
    int insertVadio(Vadio vadio);

    /**
     * 删除一条数据
     * @param vid
     * @return
     */
    @Update("update vadio set vdelete = '已删除' where vid = #{vid}")
    int deleteVadio(int vid);

    /**
     * 更改一条数据
     * @param vadio
     * @return
     */
    @Update("update vadio set vname = #{vname}, vtype = #{vtype} where vid = #{vid}")
    int updateVadio(Vadio vadio);
}
