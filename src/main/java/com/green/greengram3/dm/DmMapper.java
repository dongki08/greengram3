package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {

    //t_dm
    int insDm(DmInsDto dto);

    int insSelDm(DmInsDto dto);//

    //t_dm_msg
    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);

    List<DmSelVo> selDmAll(DmSelDto dto);

    int insDmMsg(DmMsgInsDto dto);

    int delDmMsg(DmMsgDelDto dto);

    Integer selDmByIns(DmInsDto dto);
}
