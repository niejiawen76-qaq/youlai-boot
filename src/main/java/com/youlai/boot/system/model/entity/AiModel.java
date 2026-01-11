package com.youlai.boot.system.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 模型信息实体对象
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Getter
@Setter
@TableName("ai_model")
public class AiModel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 所属供应商ID
     */
    private Long providerId;
    /**
     * 模型调用标识，如: gpt-4-turbo
     */
    private String modelName;
    /**
     * 前端显示名称
     */
    private String displayName;
    /**
     * 输入价格 (每1k token / USD)
     */
    private BigDecimal inputPrice;
    /**
     * 输出价格 (每1k token / USD)
     */
    private BigDecimal outputPrice;
}
