package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

/**
 * 密钥管理分页查询对象
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Schema(description ="密钥管理查询对象")
@Getter
@Setter
public class AiApiKeyQuery extends BasePageQuery {

    @Schema(description = "API Key")
    private String accessKey;
    @Schema(description = "剩余余额 ")
    private BigDecimal currentBalance;
    @Schema(description = "状态")
    private Integer status;
}
