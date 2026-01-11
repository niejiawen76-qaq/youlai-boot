package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 模型供应商分页查询对象
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Schema(description ="模型供应商查询对象")
@Getter
@Setter
public class AiProviderQuery extends BasePageQuery {

    @Schema(description = "供应商名称")
    private String providerName;
}
