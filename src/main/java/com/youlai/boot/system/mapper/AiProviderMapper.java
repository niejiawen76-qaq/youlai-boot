package com.youlai.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.system.model.entity.AiProvider;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.query.AiProviderQuery;
import com.youlai.boot.system.model.vo.AiProviderVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 模型供应商Mapper接口
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Mapper
public interface AiProviderMapper extends BaseMapper<AiProvider> {

    /**
     * 获取模型供应商分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<AiProviderVO>} 模型供应商分页列表
     */
    Page<AiProviderVO> getAiProviderPage(Page<AiProviderVO> page, AiProviderQuery queryParams);

}
