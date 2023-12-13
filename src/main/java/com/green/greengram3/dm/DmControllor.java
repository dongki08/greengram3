package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dm")
public class DmControllor {
    private final DmService service;


    @PostMapping()
    public DmSelVo postDm(@RequestBody DmInsDto dto) {
        return service.postDm(dto);
    }

    @PostMapping("/msg")
    public ResVo postDmMsg(@RequestBody DmMsgInsDto dto) {
        return service.postDmMsg(dto);
    }

    @GetMapping
    public List<DmSelVo> getDmAll(DmSelDto dto) {
        return service.getDmAll(dto);
    }

    @GetMapping("/msg")
    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        log.info("dto : {}", dto);
        return service.getMsgAll(dto);
    }

    @DeleteMapping("/msg")
    public ResVo delDmMsg(DmMsgDelDto dto) {
        return service.delDmMsg(dto);
    }
}
