package com.svs.bupei.vadio.mapper;

import com.svs.bupei.vadio.pojo.Depot;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepotMapper {

    @Insert("insert into depot(uname,dname,dlogo,dtext,dtype,dprice,doverplus,dsell) values(#{uname},#{dname},#{dlogo},#{dtext},#{dtype},#{dprice},#{doverplus},#{dsell})")
    int addDepot(Depot depot) ;

    @Delete("delete from depot where did= #{did}")
    int deleteDepot(String did) ;

    @Update("update depot set uname=#{uname},dname=#{dname},dlogo=#{dlogo},dtext=#{dtext},dtype=#{dtype},dprice=#{dprice},doverplus=#{doverplus},dsell=#{dsell} where did=#{did}")
    int updateDepot(Depot depot) ;

    @Select("select count(did) num from depot where uname like concat(ifNull(#{selectuname},''),'%') and dtype like concat(ifNull(#{selectdtype},''),'%') and dsell like concat(ifNull(#{selectdsell},''),'%')")
    int showListPageCount(Depot depot) ;

    @Select("select * from depot where uname like concat(ifNull(#{selectuname},''),'%') and dtype like concat(ifNull(#{selectdtype},''),'%') and dsell like concat(ifNull(#{selectdsell},''),'%') limit #{page},#{limit}")
    List<Map<String, Object>> showListPage(Depot depot) ;

    @Select("select doverplus from depot where dname=#{dname}and uname=#{uname}")
    int showDnu(Depot depot);

    @Select("select count(*) from depot where dname= #{dname}and uname=#{uname}")
    int selectName(Depot depot);

    @Select("select * from depot where dsell=0")
    List<Map<String, Object>> selectDsell(Depot depot);

    @Select("select dtype from depot where uname=#{uname}")
    List<Map<String, Object>> selectDtype(Depot depot);
}
