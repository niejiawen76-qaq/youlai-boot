package com.youlai.boot.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.system.mapper.AiApiKeyMapper;
import com.youlai.boot.system.service.AiApiKeyService;
import com.youlai.boot.system.model.entity.AiApiKey;
import com.youlai.boot.system.model.form.AiApiKeyForm;
import com.youlai.boot.system.model.query.AiApiKeyQuery;
import com.youlai.boot.system.model.vo.AiApiKeyVO;
import com.youlai.boot.system.converter.AiApiKeyConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 密钥管理服务实现类
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
@Service
@RequiredArgsConstructor
public class AiApiKeyServiceImpl extends ServiceImpl<AiApiKeyMapper, AiApiKey> implements AiApiKeyService {

    private final AiApiKeyConverter aiApiKeyConverter;

    /**
    * 获取密钥管理分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<AiApiKeyVO>} 密钥管理分页列表
    */
    @Override
    public IPage<AiApiKeyVO> getAiApiKeyPage(AiApiKeyQuery queryParams) {
        Page<AiApiKeyVO> pageVO = this.baseMapper.getAiApiKeyPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取密钥管理表单数据
     *
     * @param id 密钥管理ID
     * @return 密钥管理表单数据
     */
    @Override
    public AiApiKeyForm getAiApiKeyFormData(Long id) {
        AiApiKey entity = this.getById(id);
        return aiApiKeyConverter.toForm(entity);
    }
    
    /**
     * 新增密钥管理
     *
     * @param formData 密钥管理表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveAiApiKey(AiApiKeyForm formData) {
        AiApiKey entity = aiApiKeyConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新密钥管理
     *
     * @param id   密钥管理ID
     * @param formData 密钥管理表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateAiApiKey(Long id,AiApiKeyForm formData) {
        AiApiKey entity = aiApiKeyConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除密钥管理
     *
     * @param ids 密钥管理ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteAiApiKeys(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的密钥管理数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
