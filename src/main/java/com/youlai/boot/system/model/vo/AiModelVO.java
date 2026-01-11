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
 * 模型信息视图对象
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Getter
@Setter
@Schema( description = "模型信息视图对象")
public class AiModelVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;
    @Schema(description = "所属供应商ID")
    private Long providerId;
    @Schema(description = "模型调用标识，如: gpt-4-turbo")
    private String modelName;
    @Schema(description = "输入价格 (每1k token / USD)")
    private BigDecimal inputPrice;
    @Schema(description = "输出价格 (每1k token / USD)")
    private BigDecimal outputPrice;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
