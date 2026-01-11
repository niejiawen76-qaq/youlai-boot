package com.youlai.boot.system.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

/**
 * 模型供应商表单对象
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Getter
@Setter
@Schema(description = "模型供应商表单对象")
public class AiProviderForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "供应商名称")
    @NotBlank(message = "供应商名称不能为空")
    @Size(max=50, message="供应商名称长度不能超过50个字符")
    private String providerName;

    @Schema(description = "API基础URL")
    @Size(max=255, message="API基础URL长度不能超过255个字符")
    private String baseUrl;

    @Schema(description = "是否启用")
    @NotNull(message = "是否启用不能为空")
    private Integer isEnabled;


}
