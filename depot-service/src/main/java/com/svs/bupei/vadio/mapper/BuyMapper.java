package com.svs.bupei.vadio.mapper;

import com.svs.bupei.vadio.pojo.Buy;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuyMapper {

    @Insert("insert into buy(buname,uname,bnum,bmoney,bdate,baddress,bcall,bname,btype) values(#{buname},#{uname},#{bnum},#{bmoney},#{bdate},#{baddress},#{bcall},#{bname},#{btype})")
    int addBuy(Buy buy) ;

    @Select("select dprice from depot where dname = #{dname} and uname =#{uname}")
    int updateMoney(Buy buy);

    @Delete("delete from buy where bid= #{bid}")
    int deleteBuy(String bid) ;

    @Update("update buy set buname=#{buname},uname=#{uname},bnum=#{bnum},bmoney=#{bmoney},bdate=#{bdate},baddress=#{baddress},bcall=#{bcall},bname=#{bname},btype=#{btype} where bid=#{bid}")
    int updateBuy(Buy buy) ;

    @Update("update depot set doverplus=doverplus-#{bnum} where dname=#{dname}and uname=#{uname}")
    int  updateDepotbnum(Buy buy);

    @Select("select count(bid) num from buy where uname like concat(ifNull(#{selectuname},''),'%') and btype like concat(ifNull(#{selectbtype},''),'%')")
    int showListPageCount(Buy buy) ;

    @Select("select * from buy where buname = #{uname} limit #{page},#{limit}")
    List<Map<String, Object>> showListPage(Buy buy) ;

}
