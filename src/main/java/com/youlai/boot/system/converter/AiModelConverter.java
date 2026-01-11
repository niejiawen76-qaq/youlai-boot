package com.youlai.boot.system.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.AiModel;
import com.youlai.boot.system.model.form.AiModelForm;

/**
 * 模型信息对象转换器
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Mapper(componentModel = "spring")
public interface AiModelConverter{

    AiModelForm toForm(AiModel entity);

    AiModel toEntity(AiModelForm formData);
}