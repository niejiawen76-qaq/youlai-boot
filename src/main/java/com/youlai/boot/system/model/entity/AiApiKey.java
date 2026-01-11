package com.youlai.boot.system.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 密钥管理实体对象
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Getter
@Setter
@TableName("ai_api_key")
public class AiApiKey extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关联的供应商ID
     */
    private Long providerId;
    /**
     * API Key
     */
    private String accessKey;
    /**
     * 剩余余额 
     */
    private BigDecimal currentBalance;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
