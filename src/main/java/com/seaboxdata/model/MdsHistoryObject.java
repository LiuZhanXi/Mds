package com.seaboxdata.model;


import com.seaboxdata.dto.MdsHistoryObjectDTO;
import com.seaboxdata.dto.MdsHistoryObjectIdDTO;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * 元数据实体类
 *
 * @author hualong
 */
@Document(collection = "mds_object_history")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
public class MdsHistoryObject implements Serializable {

    private static final long serialVersionUID = 8685452181472936779L;

    //----- History -----
    @Id
    private MdsHistoryObjectId id;
    @Indexed
    private Long mdsObjectId;
    @Indexed
    private Long versionId;
    private MdsHistoryVersionStatusEnum versionStatus;
    private String versionContent;
    private Long versionCreator;
    private LocalDateTime versionCreateTm;
    private Long importJobId;
    //----- History -----

    @Indexed
    private Long tenantId;                          //** 租户Id */
    @ToString.Include
    private String name;                            //** 表名 */
    private String chineseName;                     //** 表中文名 */
    private Long techLinkmanId;                     //** 技术负责人ID */
    private Long busiLinkmanId;                     //** 业务负责人ID */
    private List<Long> tbTedUids;                // 表的技术负责人UID列表
    private List<Long> tbOpUids;                 // 表的业务负责人UID列表
    private Long organizationId;                    //** 元数据所属事业部门ID */
    private String marketName;                      //** 集市名字 */
    private String description;                     //** 描述 */
    private String dataFrameworkLevelName;          //** 数据架构层次 */
    private Long technologyCategoryId;              //** 技术类目ID */
    private Long operationCategoryId;               //** 业务类目ID */
    private MdsObjectTypeEnum mdsObjectTypeEnum;    //** 元数据类型 */
    private BigInteger storageSize;                 //** 存储量(最小精确MB) */
    private StorageTypeEnum storageTypeEnum;        //** 存储方式 */
    private LocalDateTime createDate;               //** 创建时间 */
    private LocalDateTime ddlLastUpdateDate;        //** DDL最后更新时间 */
    private LocalDateTime lastChangeDate;           //** 数据最后变更时间 */
    private LocalDateTime lastQueryDate;            //** 数据最后查询时间 */
    private String belongApp;                       //** 所属应用 */
    private String belongResource;                  //** 所在资源 */
    private Boolean isTmpTable;                     //** 是否临时表 */
    private Boolean isDescCompletion;               //** 元数据描述是否完整 */
    private String belongSystem;                    //** 所属系统 */
    private String dataBaseName;                    //** 数据库名 */
    private String dataBaseType;                    //** 数据库类型 */
    private List<MdsColumn> mdsColumns;             //** 字段的集合 */
    private Long creator;                           //** 记录创建人，insert记录时必须添加 */
    private Long modifier;                          //** 记录修改人，update记录时必须更新 */
    private LocalDateTime createTm;                 //** 记录创建时间，create_tm insert记录时必须添加 */
    private LocalDateTime modifyTm;                 //** modify_tm记录修改时间，update记录时必须更新 */

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

    public static Optional<MdsHistoryObjectDTO> of(MdsHistoryObject from) {
        if (null == from) {
            return Optional.empty();
        }
        MdsHistoryObjectDTO to = new MdsHistoryObjectDTO();
        BeanUtils.copyProperties(from, to);
        to.setMdsColumns(from.getMdsColumns()
                .stream().map(MdsColumn::of)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(toList())
        );
        Optional<MdsHistoryObjectIdDTO> id = MdsHistoryObjectId.of(from.getId());
        id.ifPresent(to::setId);
        return Optional.of(to);
    }

    public static MdsHistoryObject from(MdsObject mds) {
        MdsHistoryObject historyObject = new MdsHistoryObject();
        BeanUtils.copyProperties(mds, historyObject);

        historyObject.setId(MdsHistoryObjectId.builder().id(mds.getId()).version(mds.getVersionId()).build())
                .setMdsObjectId(mds.getId())
                .setVersionId(mds.getVersionId())
                .setVersionStatus(MdsHistoryVersionStatusEnum.INSERT)
                .setVersionContent("MDS版本初始化")
                .setVersionCreator(1L)
                .setVersionCreateTm(LocalDateTime.now())
                .setImportJobId(1L);
        return historyObject;
    }
}
