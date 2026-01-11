package com.youlai.boot.system.controller;

import com.youlai.boot.system.service.AiApiKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.AiApiKeyForm;
import com.youlai.boot.system.model.query.AiApiKeyQuery;
import com.youlai.boot.system.model.vo.AiApiKeyVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.boot.core.web.PageResult;
import com.youlai.boot.core.web.Result;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 * 密钥管理前端控制层
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Tag(name = "密钥管理接口")
@RestController
@RequestMapping("/api/v1/ai-api-key")
@RequiredArgsConstructor
public class AiApiKeyController  {

    private final AiApiKeyService aiApiKeyService;

    @Operation(summary = "密钥管理分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:ai-api-key:query')")
    public PageResult<AiApiKeyVO> getAiApiKeyPage(AiApiKeyQuery queryParams ) {
        IPage<AiApiKeyVO> result = aiApiKeyService.getAiApiKeyPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增密钥管理")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('system:ai-api-key:add')")
    public Result<Void> saveAiApiKey(@RequestBody @Valid AiApiKeyForm formData ) {
        boolean result = aiApiKeyService.saveAiApiKey(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取密钥管理表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:ai-api-key:edit')")
    public Result<AiApiKeyForm> getAiApiKeyForm(
        @Parameter(description = "密钥管理ID") @PathVariable Long id
    ) {
        AiApiKeyForm formData = aiApiKeyService.getAiApiKeyFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改密钥管理")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('system:ai-api-key:edit')")
    public Result<Void> updateAiApiKey(
            @Parameter(description = "密钥管理ID") @PathVariable Long id,
            @RequestBody @Validated AiApiKeyForm formData
    ) {
        boolean result = aiApiKeyService.updateAiApiKey(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除密钥管理")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:ai-api-key:delete')")
    public Result<Void> deleteAiApiKeys(
        @Parameter(description = "密钥管理ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = aiApiKeyService.deleteAiApiKeys(ids);
        return Result.judge(result);
    }
}
