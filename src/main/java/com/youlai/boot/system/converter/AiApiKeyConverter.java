package com.youlai.boot.system.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.boot.system.model.entity.AiApiKey;
import com.youlai.boot.system.model.form.AiApiKeyForm;

/**
 * 密钥管理对象转换器
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Mapper(componentModel = "spring")
public interface AiApiKeyConverter{

    AiApiKeyForm toForm(AiApiKey entity);

    AiApiKey toEntity(AiApiKeyForm formData);
}