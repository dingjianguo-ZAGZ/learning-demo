package com.su.shopping_common.service;

import com.su.shopping_common.pojo.GoodsDesc;
import com.su.shopping_common.pojo.GoodsES;
import com.su.shopping_common.pojo.GoodsSearchParam;
import com.su.shopping_common.pojo.GoodsSearchResult;

import java.util.List;

//搜索服务
public interface SearchService {
    /**
     * 自动补齐搜索关键字
     * @param keyword 被补齐的关键字
     * @return 补齐的关键字集合
     */
    List<String> autoSuggest(String keyword);

    /**
     * 商品搜索
     * @param goodsSearchParam 商品搜索条件对象
     * @return 商品搜索结果对象
     */
    GoodsSearchResult search(GoodsSearchParam goodsSearchParam);

    /**
     * 将数据库中的商品信息同步到ES
     * @param goodsDesc 商品详细信息
     */
    void syncGoodsToES(GoodsDesc goodsDesc);

    /**
     * 删除ES中的商品数据
     * @param id
     */
    void delete(Long id);

}
