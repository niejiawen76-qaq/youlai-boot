package com.youlai.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.boot.system.model.entity.AiApiKey;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.query.AiApiKeyQuery;
import com.youlai.boot.system.model.vo.AiApiKeyVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 密钥管理Mapper接口
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Mapper
public interface AiApiKeyMapper extends BaseMapper<AiApiKey> {

    /**
     * 获取密钥管理分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return {@link Page<AiApiKeyVO>} 密钥管理分页列表
     */
    Page<AiApiKeyVO> getAiApiKeyPage(Page<AiApiKeyVO> page, AiApiKeyQuery queryParams);

}
