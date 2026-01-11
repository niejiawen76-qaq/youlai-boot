package com.youlai.boot.system.model.query;

import com.youlai.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

/**
 * 模型信息分页查询对象
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Schema(description ="模型信息查询对象")
@Getter
@Setter
public class AiModelQuery extends BasePageQuery {

    @Schema(description = "模型调用标识，如: gpt-4-turbo")
    private String modelName;
}
