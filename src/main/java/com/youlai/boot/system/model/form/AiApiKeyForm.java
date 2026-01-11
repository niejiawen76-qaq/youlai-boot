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
 * 密钥管理表单对象
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Getter
@Setter
@Schema(description = "密钥管理表单对象")
public class AiApiKeyForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "关联的供应商ID")
    @NotNull(message = "关联的供应商ID不能为空")
    private Long providerId;

    @Schema(description = "API Key")
    @NotBlank(message = "API Key不能为空")
    @Size(max=255, message="API Key长度不能超过255个字符")
    private String accessKey;

    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "备注")
    @Size(max=100, message="备注长度不能超过100个字符")
    private String remark;


}
