package com.green.greengram3.dm;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import com.green.greengram3.user.UserMapper;
import com.green.greengram3.user.model.UserEntity;
import com.green.greengram3.user.model.UserSelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper mapper;
    private final UserMapper userMapper;

    public DmSelVo postDm(DmInsDto dto) {
        if(mapper.selDmByIns(dto) == null) {
            return null;
        }

        mapper.insDm(dto);
        mapper.insSelDm(dto);
        UserSelDto usDto = new UserSelDto();
        usDto.setIuser(dto.getOtherPersonIuser());
        UserEntity userEntity = userMapper.selUser(usDto);

        return DmSelVo.builder()
                .idm(dto.getIdm())
                .otherPersonIuser(userEntity.getIuser())
                .otherPersonNm(userEntity.getNm())
                .otherPersonPic(userEntity.getPic())
                .build();
    }

    public ResVo postDmMsg(DmMsgInsDto dto) {
        int affect = mapper.insDmMsg(dto);
        return new ResVo(dto.getSeq());
    }

    public List<DmSelVo> getDmAll(DmSelDto dto) {
        return mapper.selDmAll(dto);
    }

    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto) {
        return mapper.selDmMsgAll(dto);
    }

    public ResVo delDmMsg(DmMsgDelDto dto) {
        int result = mapper.delDmMsg(dto);
        if(result == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }
}
