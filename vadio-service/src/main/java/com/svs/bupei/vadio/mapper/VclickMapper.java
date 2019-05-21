package com.svs.bupei.vadio.mapper;

import com.svs.bupei.vadio.pojo.Vclick;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VclickMapper {

    /**
     * 查询模糊查询后所有数据
     * @param vclick
     * @return 模糊查询后数据
     */
    @Select("select a.vcid,a.vcdate,a.vcuname,b.vname from vclick a left join vadio b on a.vid = b.vid where vcuname like concat('%',ifNull(#{vcuname},''), '%') order by vcdate desc limit #{page}, #{limit}")
    List<Vclick> selectAllVclick(Vclick vclick);

    /**
     * 模糊查询后数据个数
     * @param vclick
     * @return 模糊查询数据个数
     */
    @Select("select count(vcid) from vclick where vcuname like concat('%',ifNull(#{vcuname},''), '%')")
    int selectCountVclick(Vclick vclick);

    /**
     * 添加一条信息
     * @param vclick
     * @return
     */
    @Insert("insert into vclick(vcdate,vcuname,vid) values(#{vcdate},#{vcuname},#{vid})")
    int insertVclick(Vclick vclick);

}
