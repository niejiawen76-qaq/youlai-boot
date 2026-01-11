package com.youlai.boot.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.AiModelMapper;
import com.youlai.boot.system.service.AiModelService;
import com.youlai.boot.system.model.entity.AiModel;
import com.youlai.boot.system.model.form.AiModelForm;
import com.youlai.boot.system.model.query.AiModelQuery;
import com.youlai.boot.system.model.vo.AiModelVO;
import com.youlai.boot.system.converter.AiModelConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 模型信息服务实现类
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
@Service
@RequiredArgsConstructor
public class AiModelServiceImpl extends ServiceImpl<AiModelMapper, AiModel> implements AiModelService {

    private final AiModelConverter aiModelConverter;

    /**
    * 获取模型信息分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<AiModelVO>} 模型信息分页列表
    */
    @Override
    public IPage<AiModelVO> getAiModelPage(AiModelQuery queryParams) {
        Page<AiModelVO> pageVO = this.baseMapper.getAiModelPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取模型信息表单数据
     *
     * @param id 模型信息ID
     * @return 模型信息表单数据
     */
    @Override
    public AiModelForm getAiModelFormData(Long id) {
        AiModel entity = this.getById(id);
        return aiModelConverter.toForm(entity);
    }
    
    /**
     * 新增模型信息
     *
     * @param formData 模型信息表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveAiModel(AiModelForm formData) {
        AiModel entity = aiModelConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新模型信息
     *
     * @param id   模型信息ID
     * @param formData 模型信息表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateAiModel(Long id,AiModelForm formData) {
        AiModel entity = aiModelConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除模型信息
     *
     * @param ids 模型信息ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteAiModels(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的模型信息数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
