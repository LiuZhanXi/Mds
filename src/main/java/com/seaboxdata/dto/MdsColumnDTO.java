package com.seaboxdata.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/** 字段 */
@Data
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
public class MdsColumnDTO implements Serializable {

    private static final long serialVersionUID = -5778146076394689153L;

    @ToString.Include
    private Long id;                //** id *//
    private Long seqId;             //** 排序 *//
    private Long tenantId;          //** 租户Id *//
    private Long mdsObjectId;       //** 所属元数据id *//
    //private Long metaDataId;      //** 所属元数据id *//
    @ToString.Include
    private String name;            //** 元数据字段名字 *//
    private String dbColumnType;    //** 元数据字段类型 *//
    private String desc;            //** 元数据字段描述 *//
    private Boolean isPrimaryKey;   //** 是否是主外键 *//
    private Long creator;           //** 记录创建人，insert记录时必须添加 *//
    private Long modifier;          //** 记录修改人，update记录时必须更新 *//
    private Integer size;           //** 字段长度 *//
    private Boolean isNullAble;     //** 是否允许为null *//
    private String defaultValue;    //** 默认值 *//
    private Boolean physicalOnly;   //仅物理
    private LocalDateTime createTm; //** 记录创建时间，create_tm insert记录时必须添加 *//
    private LocalDateTime modifyTm; //** modify_tm记录修改时间，update记录时必须更新 *//

    private String tblName;        //源表名
    private String bizDesc;        //业务描述
    private String colSrc;         //字段来源

    //DTO特有
    @Deprecated
    private Long views;             //** 访问次数 *//
    private Boolean isPartitionKey; //是否分区表
    private String note;           //字段备注信息
}
