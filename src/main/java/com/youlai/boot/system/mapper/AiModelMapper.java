package com.youlai.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.system.model.entity.AiModel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.query.AiModelQuery;
import com.youlai.boot.system.model.vo.AiModelVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 模型信息Mapper接口
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Mapper
public interface AiModelMapper extends BaseMapper<AiModel> {

    /**
     * 获取模型信息分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<AiModelVO>} 模型信息分页列表
     */
    Page<AiModelVO> getAiModelPage(Page<AiModelVO> page, AiModelQuery queryParams);

}
