package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedFavDto;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FeedFavMapperTest {

    @Autowired
    private FeedFavMapper mapper;

    @Test
    public void insFeedFav() {
        FeedFavDto dto = new FeedFavDto();
        dto.setIfeed(3);
        dto.setIuser(1);

        int affectedRows1 = mapper.insFeedFav(dto);
        assertEquals(1, affectedRows1, "첫번재 insert");

        List<FeedFavDto> result = mapper.selFeedFavForTest(dto);
        assertEquals(1, result.size(), "첫번째 insert 확인");

        dto.setIfeed(6);
        dto.setIuser(1);

        int affectedRows2 = mapper.insFeedFav(dto);
        assertEquals(1, affectedRows2, "두번째 insert");

        List<FeedFavDto> result2 = mapper.selFeedFavForTest(dto);
        assertEquals(1, result2.size(), "두번째 insert 확인");

    }

    @Test
    public void delFeedFavTest() {
        FeedFavDto dto = new FeedFavDto();
        dto.setIfeed(6);
        dto.setIuser(2);

        int affectedRows1 = mapper.delFeedFav(dto);
        assertEquals(1, affectedRows1);

        int affectedRows2 = mapper.delFeedFav(dto);
        assertEquals(0, affectedRows2);

        List<FeedFavDto> result3 = mapper.selFeedFavForTest(dto);
        assertEquals(0, result3.size());
    }

    @Test
    public void delFeedFavAllTest() {
        final int ifeed = 3;

        FeedFavDto seldto = new FeedFavDto();
        seldto.setIfeed(ifeed);
        List<FeedFavDto> selList = mapper.selFeedFavForTest(seldto);

        FeedDelDto dto = new FeedDelDto();
        dto.setIfeed(ifeed);
        int delaffectedRows = mapper.delFeedFavAll(dto);
        assertEquals(selList.size(), delaffectedRows);

        List<FeedFavDto> selList2 = mapper.selFeedFavForTest(seldto);
        assertEquals(0, selList2.size());
    }
}