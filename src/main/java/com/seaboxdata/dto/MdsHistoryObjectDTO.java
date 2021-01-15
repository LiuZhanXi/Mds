package com.seaboxdata.dto;


import com.seaboxdata.model.DbSourceTypeEnum;
import com.seaboxdata.model.MdsObjectTypeEnum;
import com.seaboxdata.model.StorageTypeEnum;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

/**
 * MdsHistoryObject DTO
 */
@Data
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
public class MdsHistoryObjectDTO implements Serializable {

    private static final long serialVersionUID = 8685452181472936779L;

    @ToString.Include
    private MdsHistoryObjectIdDTO id;//** id */
    private Long version;
    private Long tenantId; //** 租户Id */
    @ToString.Include
    private String name; //** 表名 */
    private String chineseName; //** 表中文名 */
    private Long techLinkmanId; //** 技术负责人ID */
    private Long busiLinkmanId;//** 业务负责人ID */
    private List<Long> tbTedUids; //** 表的技术负责人UID列表 */
    private List<Long> tbOpUids; //** 表的业务负责人UID列表 */
    private Long organizationId; //** 元数据所属事业部门ID */
    private String marketName; //** 集市名字 */
    private String description; //** 描述 */
    private String dataFrameworkLevelName; //** 数据架构层次 */
    private Long technologyCategoryId; //** 技术类目ID */
    private Long operationCategoryId; //** 业务类目ID */
    private MdsObjectTypeEnum mdsObjectTypeEnum; //** 元数据类型 */
    private BigInteger storageSize; //** 存储量(最小精确MB) */
    private StorageTypeEnum storageTypeEnum; //** 存储方式 */
    private LocalDateTime createDate; //** 创建时间 */
    private LocalDateTime ddlLastUpdateDate; //** DDL最后更新时间 */
    private LocalDateTime lastChangeDate; //** 数据最后变更时间 */
    private LocalDateTime lastQueryDate; //** 数据最后查询时间 */
    private String belongApp; //** 所属应用 */
    private String belongResource; //** 所在资源 */
    private Boolean isTmpTable = false; //** 是否临时表 */
    private Boolean isDescCompletion = false; //** 元数据描述是否完整 */
    private String belongSystem; //** 所属系统 */
    private String dataBaseName; //** 数据库名 */
    private String dataBaseType; //** 数据库类型 */
    private List<MdsColumnDTO> mdsColumns; //** 字段的集合 */
    private Long creator; //** 记录创建人，insert记录时必须添加 */
    private Long modifier; //** 记录修改人，update记录时必须更新 */
    private LocalDateTime createTm; //** 记录创建时间，create_tm insert记录时必须添加 */
    private LocalDateTime modifyTm; //** modify_tm记录修改时间，update记录时必须更新 */
    private BigInteger incRows;                     //增量记录数
    private BigInteger incStorSize;                 //增量数据量
    private LocalDateTime availTime;                // 数据有效日期
    private String srcTblNature;                    //源表性质
    private String srcTblDesc;                      //源表注释
    private String clsDesc;                         //清理要求和周期
    private Boolean isIncUpdateAvaliable;           //是否可提供增量
    private String tblRelaInfo;                     //表关联信息
    private Boolean isPhysDel;                      //是否有物理删除
    private DbSourceTypeEnum dbSourceType;
    private String schema;
    private String columnsJson;
    private String note;                    //字段备注信息
}

