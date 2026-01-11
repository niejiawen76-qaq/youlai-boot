package com.youlai.boot.system.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.AiProvider;
import com.youlai.boot.system.model.form.AiProviderForm;

/**
 * 模型供应商对象转换器
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Mapper(componentModel = "spring")
public interface AiProviderConverter{

    AiProviderForm toForm(AiProvider entity);

    AiProvider toEntity(AiProviderForm formData);
}