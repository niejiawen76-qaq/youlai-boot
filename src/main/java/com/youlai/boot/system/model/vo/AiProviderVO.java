package com.youlai.boot.system.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 模型供应商视图对象
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Getter
@Setter
@Schema( description = "模型供应商视图对象")
public class AiProviderVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;
    @Schema(description = "供应商名称")
    private String providerName;
    @Schema(description = "API基础URL")
    private String baseUrl;
    @Schema(description = "是否启用")
    private Integer isEnabled;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
