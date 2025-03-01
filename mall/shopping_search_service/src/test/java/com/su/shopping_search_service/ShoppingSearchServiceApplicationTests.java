package com.su.shopping_search_service;

import com.su.shopping_common.pojo.GoodsDesc;
import com.su.shopping_common.service.GoodsService;
import com.su.shopping_common.service.SearchService;
import com.su.shopping_search_service.service.SearchServiceImpl;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShoppingSearchServiceApplicationTests {
    @Autowired
    private SearchServiceImpl searchService;
    //@DubboReference
    //private GoodsService goodsService;

    @Test
    void contextLoads() {
        List<String> analyzer = searchService.analyze("我在太原理工大学", "ik_pinyin");
        System.out.println(analyzer);
    }
    /*@Test
    void testSycGoodsToEs(){
        List<GoodsDesc> all = goodsService.findAll();
        for (GoodsDesc goodsDesc : all) {
            //商品是商家状态进行同步
            if(goodsDesc.getIsMarketable()){
                searchService.syncGoodsToES(goodsDesc);
            }
        }
    }*/
    @Test
    void testSuggest(){
        List<String> strings = searchService.autoSuggest("ip");
        System.out.println(strings);
    }
}
