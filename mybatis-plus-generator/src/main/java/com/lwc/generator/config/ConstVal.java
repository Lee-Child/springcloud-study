/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.lwc.generator.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.nio.charset.StandardCharsets;

/**
 * 定义常量
 *
 * @author YangHu, tangguo, hubin
 * @since 2016-08-31
 */
public interface ConstVal {

    String MODULE_NAME = "ModuleName";

    String ENTITY = "Entity";
    String SERVICE = "Service";
    String SERVICE_IMPL = "ServiceImpl";
    String MAPPER = "Mapper";
    String XML = "Xml";
    String CONTROLLER = "Controller";
    String FEIGN = "Feign";
    String ENTITY_EXT = "EntityExt";
    String DAO = "Dao";
    String DAO_IMPL = "DaoImpl";
    String FALLBACK = "Fallback";
    String PAYLOAD = "Payload";
    String HANDLER = "Handler";

    String ENTITY_PATH = "entity_path";
    String SERVICE_PATH = "service_path";
    String SERVICE_IMPL_PATH = "service_impl_path";
    String MAPPER_PATH = "mapper_path";
    String XML_PATH = "xml_path";
    String CONTROLLER_PATH = "controller_path";
    String FEIGN_PATH = "feign_path";
    String ENTITY_EXT_PATH = "entity_ext_path";
    String DAO_PATH = "dao_path";
    String DAO_IMPL_PATH = "dao_impl_path";
    String FALLBACK_PATH = "fallback_path";
    String PAYLOAD_PATH = "payload_path";
    String HANDLER_PATH = "handler_path";

    String JAVA_TMPDIR = "java.io.tmpdir";
    String UTF8 = StandardCharsets.UTF_8.name();
    String UNDERLINE = "_";

    String JAVA_SUFFIX = StringPool.DOT_JAVA;
    String KT_SUFFIX = ".kt";
    String XML_SUFFIX = ".xml";

    String TEMPLATE_ENTITY_JAVA = "/templates/entity.java";
    String TEMPLATE_ENTITY_KT = "/templates/entity.kt";
    String TEMPLATE_MAPPER = "/templates/mapper.java";
    String TEMPLATE_XML = "/templates/mapper.xml";
    String TEMPLATE_SERVICE = "/templates/service.java";
    String TEMPLATE_SERVICE_IMPL = "/templates/serviceImpl.java";
    String TEMPLATE_CONTROLLER = "/templates/apiImpl.java";
    String TEMPLATE_FEIGN = "/templates/api.java";
    String TEMPLATE_ENTITY_EXT = "/templates/bo.java";
    String TEMPLATE_DAO = "/templates/dao.java";
    String TEMPLATE_DAO_IMPL = "/templates/daoImpl.java";
    String TEMPLATE_FALLBACK = "/templates/fallback.java";
    String TEMPLATE_PAYLOAD = "/templates/payload.java";
    String TEMPLATE_HANDLER = "/templates/handler.java";

    String SUPER_ENTITY_CLASS = "com.gtmc.glaf.framework.data.entity.Entity";
    String SUPER_MAPPER_CLASS = "com.gtmc.glaf.framework.data.mysql.mapper.BaseMpMapper";
    String SUPER_SERVICE_CLASS = "com.gtmc.glaf.framework.data.mysql.service.BaseMpService";
    String SUPER_SERVICE_IMPL_CLASS = "com.gtmc.glaf.framework.data.mysql.service.impl.BaseMpServiceImpl";

    String SUPER_DAO_CLASS = "com.gtmc.glaf.framework.data.mysql.dao.BaseMpDao";
    String SUPER_DAO_IMPL_CLASS = "com.gtmc.glaf.framework.data.mysql.dao.impl.BaseMpDaoImpl";

    String SUPER_FEIGN_CLASS = "com.gtmc.infra.eip.common.service.BaseSinglePkApi";
}
