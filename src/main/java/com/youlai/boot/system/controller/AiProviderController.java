package com.youlai.boot.system.controller;

import com.youlai.boot.system.service.AiProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.AiProviderForm;
import com.youlai.boot.system.model.query.AiProviderQuery;
import com.youlai.boot.system.model.vo.AiProviderVO;
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
 * 模型供应商前端控制层
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Tag(name = "模型供应商接口")
@RestController
@RequestMapping("/api/v1/ai-provider")
@RequiredArgsConstructor
public class AiProviderController  {

    private final AiProviderService aiProviderService;

    @Operation(summary = "模型供应商分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:ai-provider:query')")
    public PageResult<AiProviderVO> getAiProviderPage(AiProviderQuery queryParams ) {
        IPage<AiProviderVO> result = aiProviderService.getAiProviderPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增模型供应商")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('system:ai-provider:add')")
    public Result<Void> saveAiProvider(@RequestBody @Valid AiProviderForm formData ) {
        boolean result = aiProviderService.saveAiProvider(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取模型供应商表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:ai-provider:edit')")
    public Result<AiProviderForm> getAiProviderForm(
        @Parameter(description = "模型供应商ID") @PathVariable Long id
    ) {
        AiProviderForm formData = aiProviderService.getAiProviderFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改模型供应商")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('system:ai-provider:edit')")
    public Result<Void> updateAiProvider(
            @Parameter(description = "模型供应商ID") @PathVariable Long id,
            @RequestBody @Validated AiProviderForm formData
    ) {
        boolean result = aiProviderService.updateAiProvider(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除模型供应商")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:ai-provider:delete')")
    public Result<Void> deleteAiProviders(
        @Parameter(description = "模型供应商ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = aiProviderService.deleteAiProviders(ids);
        return Result.judge(result);
    }
}
