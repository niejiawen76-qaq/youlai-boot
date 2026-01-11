package com.youlai.boot.system.service;

import com.youlai.boot.system.model.entity.AiProvider;
import com.youlai.boot.system.model.form.AiProviderForm;
import com.youlai.boot.system.model.query.AiProviderQuery;
import com.youlai.boot.system.model.vo.AiProviderVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 模型供应商服务类
 *
 * @author njw
 * @since 2026-01-10 22:58
 */
public interface AiProviderService extends IService<AiProvider> {

    /**
     *模型供应商分页列表
     *
     * @return {@link IPage<AiProviderVO>} 模型供应商分页列表
     */
    IPage<AiProviderVO> getAiProviderPage(AiProviderQuery queryParams);

    /**
     * 获取模型供应商表单数据
     *
     * @param id 模型供应商ID
     * @return 模型供应商表单数据
     */
     AiProviderForm getAiProviderFormData(Long id);

    /**
     * 新增模型供应商
     *
     * @param formData 模型供应商表单对象
     * @return 是否新增成功
     */
    boolean saveAiProvider(AiProviderForm formData);

    /**
     * 修改模型供应商
     *
     * @param id   模型供应商ID
     * @param formData 模型供应商表单对象
     * @return 是否修改成功
     */
    boolean updateAiProvider(Long id, AiProviderForm formData);

    /**
     * 删除模型供应商
     *
     * @param ids 模型供应商ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteAiProviders(String ids);

}
