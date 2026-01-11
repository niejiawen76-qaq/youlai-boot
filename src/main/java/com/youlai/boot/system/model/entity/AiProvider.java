package com.youlai.boot.system.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.youlai.boot.common.base.BaseEntity;

/**
 * 模型供应商实体对象
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Getter
@Setter
@TableName("ai_provider")
public class AiProvider extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商名称
     */
    private String providerName;
    /**
     * API基础URL
     */
    private String baseUrl;
    /**
     * 是否启用
     */
    private Integer isEnabled;
}
