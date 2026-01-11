package com.youlai.boot.system.service;

import com.youlai.boot.system.model.entity.AiModel;
import com.youlai.boot.system.model.form.AiModelForm;
import com.youlai.boot.system.model.query.AiModelQuery;
import com.youlai.boot.system.model.vo.AiModelVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 模型信息服务类
 *
 * @author njw
 * @since 2026-01-10 22:47
 */
public interface AiModelService extends IService<AiModel> {

    /**
     *模型信息分页列表
     *
     * @return {@link IPage<AiModelVO>} 模型信息分页列表
     */
    IPage<AiModelVO> getAiModelPage(AiModelQuery queryParams);

    /**
     * 获取模型信息表单数据
     *
     * @param id 模型信息ID
     * @return 模型信息表单数据
     */
     AiModelForm getAiModelFormData(Long id);

    /**
     * 新增模型信息
     *
     * @param formData 模型信息表单对象
     * @return 是否新增成功
     */
    boolean saveAiModel(AiModelForm formData);

    /**
     * 修改模型信息
     *
     * @param id   模型信息ID
     * @param formData 模型信息表单对象
     * @return 是否修改成功
     */
    boolean updateAiModel(Long id, AiModelForm formData);

    /**
     * 删除模型信息
     *
     * @param ids 模型信息ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    boolean deleteAiModels(String ids);

}
