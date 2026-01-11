package com.youlai.boot.system.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 * 密钥管理视图对象
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Getter
@Setter
@Schema( description = "密钥管理视图对象")
public class AiApiKeyVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;
    @Schema(description = "关联的供应商ID")
    private Long providerId;
    @Schema(description = "API Key")
    private String accessKey;
    @Schema(description = "剩余余额 ")
    private BigDecimal currentBalance;
    @Schema(description = "状态")
    private Integer status;
    @Schema(description = "备注")
    private String remark;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
