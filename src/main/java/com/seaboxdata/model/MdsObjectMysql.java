package com.seaboxdata.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:    MdsObjectMysql
 * Package:    com.seaboxdata.model
 * Description:
 * Datetime:    2021年01月07日   16:20
 * Author:     LiuZhanXi
 */
@Data
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
@TableName(value = "mds_object_mysql")
public class MdsObjectMysql implements Serializable {

    private static final long serialVersionUID = 8057477654193741141L;

    @Id
    @ToString.Include
    private Long id; //id
    @Indexed
    private Long tenantId;// 租户Id
    @Indexed
    @ToString.Include
    private String name;                        // 表名
    private String chineseName;                 // 表中文名
    private Long techLinkmanId;                 // 技术负责人ID
    private Long busiLinkmanId;                 // 业务负责人ID
    private String marketName;                  // 集市名字
    private String description;                 // 描述
    @Deprecated
    private String dataFrameworkLevelName;      //数据架构层次
    private Long technologyCategoryId;          //技术类目ID
    private List<Long> businessCategoryIds;     // 业务类目ID列表
    @Indexed
    private MdsObjectTypeEnum mdsObjectTypeEnum;//元数据类型
    private BigInteger storageSize;             // 存储量(最小精确字节)

    private BigInteger rows;                    //　记录数
    private BigInteger dataSize;
    private BigInteger indexSize;

    private StorageTypeEnum storageTypeEnum;    // 存储方式
    private LocalDateTime createTime;           //元数据库的创建时间
    private LocalDateTime updateTime;           //元数据库的最后更新时间
    @Deprecated
    private LocalDateTime ddlLastUpdateDate;    //DDL最后更新时间
    @Deprecated
    private LocalDateTime lastChangeDate;       //数据最后变更时间 由updateTime代替
    private LocalDateTime lastQueryDate;        //数据最后查询时间
    private Boolean isTmpTable;                 //是否临时表
    private Boolean isCopy;                     //表是否是拷贝表
    @Deprecated
    private Boolean isDescCompletion;           //元数据描述是否完整
    private String dataBaseName;                //数据库名
    private Long creator;                       //记录创建人，insert记录时必须添加
    private Long modifier;                      //记录修改人，update记录时必须更新
    private LocalDateTime createTm;             //记录创建时间，create_tm insert记录时必须添加
    private LocalDateTime modifyTm;             //modify_tm记录修改时间，update记录时必须更新
    private Long versionId;                     //版本Id

    private BigInteger incRows;                 //增量记录数
    private BigInteger incStorSize;             //增量数据量
    private LocalDateTime availTime;            //数据有效日期
    private String srcTblNature;                //源表性质
    private String srcTblDesc;                  //源表注释
    private String clsDesc;                     //清理要求和周期
    private Boolean isIncUpdateAvaliable;       //是否可提供增量
    private String tblRelaInfo;                 //表关联信息
    private Boolean isPhysDel;                  //是否有物理删除

    private String ddl;                     //table create script
    private Boolean isPartitionKey;         //是否分区表

    private DbSourceTypeEnum dbSourceType;
    private String schema;
    private String columnsJson;
    private String note;                    //字段备注信息

    private boolean asInput = false; // 是否为手工录入的
}
