package com.youlai.boot.system.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

/**
 * 模型信息表单对象
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Getter
@Setter
@Schema(description = "模型信息表单对象")
public class AiModelForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "所属供应商ID")
    @NotNull(message = "所属供应商ID不能为空")
    private Long providerId;

    @Schema(description = "模型调用标识，如: gpt-4-turbo")
    @NotBlank(message = "模型调用标识，如: gpt-4-turbo不能为空")
    @Size(max=100, message="模型调用标识，如: gpt-4-turbo长度不能超过100个字符")
    private String modelName;

    @Schema(description = "输入价格 (每1k token / USD)")
    private BigDecimal inputPrice;

    @Schema(description = "输出价格 (每1k token / USD)")
    private BigDecimal outputPrice;


}
