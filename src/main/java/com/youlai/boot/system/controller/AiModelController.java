package com.youlai.boot.system.controller;

import com.youlai.boot.system.service.AiModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youlai.boot.system.model.form.AiModelForm;
import com.youlai.boot.system.model.query.AiModelQuery;
import com.youlai.boot.system.model.vo.AiModelVO;
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
 * 模型信息前端控制层
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Tag(name = "模型信息接口")
@RestController
@RequestMapping("/api/v1/ai-model")
@RequiredArgsConstructor
public class AiModelController  {

    private final AiModelService aiModelService;

    @Operation(summary = "模型信息分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('system:ai-model:query')")
    public PageResult<AiModelVO> getAiModelPage(AiModelQuery queryParams ) {
        IPage<AiModelVO> result = aiModelService.getAiModelPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增模型信息")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('system:ai-model:add')")
    public Result<Void> saveAiModel(@RequestBody @Valid AiModelForm formData ) {
        boolean result = aiModelService.saveAiModel(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取模型信息表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('system:ai-model:edit')")
    public Result<AiModelForm> getAiModelForm(
        @Parameter(description = "模型信息ID") @PathVariable Long id
    ) {
        AiModelForm formData = aiModelService.getAiModelFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改模型信息")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('system:ai-model:edit')")
    public Result<Void> updateAiModel(
            @Parameter(description = "模型信息ID") @PathVariable Long id,
            @RequestBody @Validated AiModelForm formData
    ) {
        boolean result = aiModelService.updateAiModel(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除模型信息")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('system:ai-model:delete')")
    public Result<Void> deleteAiModels(
        @Parameter(description = "模型信息ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = aiModelService.deleteAiModels(ids);
        return Result.judge(result);
    }
}
