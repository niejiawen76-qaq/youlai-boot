package com.youlai.boot.system.service;

import com.youlai.boot.system.model.entity.AiApiKey;
import com.youlai.boot.system.model.form.AiApiKeyForm;
import com.youlai.boot.system.model.query.AiApiKeyQuery;
import com.youlai.boot.system.model.vo.AiApiKeyVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 密钥管理服务类
 *
 * @author njw
 * @since 2026-01-10 22:48
 */
public interface AiApiKeyService extends IService<AiApiKey> {

    /**
     *密钥管理分页列表
     *
     * @return {@link IPage<AiApiKeyVO>} 密钥管理分页列表
     */
    IPage<AiApiKeyVO> getAiApiKeyPage(AiApiKeyQuery queryParams);

    /**
     * 获取密钥管理表单数据
     *
     * @param id 密钥管理ID
     * @return 密钥管理表单数据
     */
     AiApiKeyForm getAiApiKeyFormData(Long id);

    /**
     * 新增密钥管理
     *
     * @param formData 密钥管理表单对象
     * @return 是否新增成功
     */
    boolean saveAiApiKey(AiApiKeyForm formData);

    /**
     * 修改密钥管理
     *
     * @param id   密钥管理ID
     * @param formData 密钥管理表单对象
     * @return 是否修改成功
     */
    boolean updateAiApiKey(Long id, AiApiKeyForm formData);

    /**
     * 删除密钥管理
     *
     * @param ids 密钥管理ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteAiApiKeys(String ids);

}
