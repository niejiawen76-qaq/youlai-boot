package com.youlai.boot.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.AiProviderMapper;
import com.youlai.boot.system.service.AiProviderService;
import com.youlai.boot.system.model.entity.AiProvider;
import com.youlai.boot.system.model.form.AiProviderForm;
import com.youlai.boot.system.model.query.AiProviderQuery;
import com.youlai.boot.system.model.vo.AiProviderVO;
import com.youlai.boot.system.converter.AiProviderConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 模型供应商服务实现类
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
@Service
@RequiredArgsConstructor
public class AiProviderServiceImpl extends ServiceImpl<AiProviderMapper, AiProvider> implements AiProviderService {

    private final AiProviderConverter aiProviderConverter;

    /**
    * 获取模型供应商分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<AiProviderVO>} 模型供应商分页列表
    */
    @Override
    public IPage<AiProviderVO> getAiProviderPage(AiProviderQuery queryParams) {
        Page<AiProviderVO> pageVO = this.baseMapper.getAiProviderPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取模型供应商表单数据
     *
     * @param id 模型供应商ID
     * @return 模型供应商表单数据
     */
    @Override
    public AiProviderForm getAiProviderFormData(Long id) {
        AiProvider entity = this.getById(id);
        return aiProviderConverter.toForm(entity);
    }
    
    /**
     * 新增模型供应商
     *
     * @param formData 模型供应商表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveAiProvider(AiProviderForm formData) {
        AiProvider entity = aiProviderConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新模型供应商
     *
     * @param id   模型供应商ID
     * @param formData 模型供应商表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateAiProvider(Long id,AiProviderForm formData) {
        AiProvider entity = aiProviderConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除模型供应商
     *
     * @param ids 模型供应商ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteAiProviders(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的模型供应商数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
