package com.seaboxdata.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.seaboxdata.dto.MdsColumnDTO;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 元数据子集
 *
 * @author hualong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MdsColumn implements Serializable {

    private static final long serialVersionUID = -5778146076394689153L;

    @Id
    @ToString.Include
    private Long id;                        //id
    private Long seqId;                     //排序id
    private Long tenantId;                  //租户Id
    private Long mdsObjectId;               //所属元数据id
    private String name;                    //元数据字段名字
    private String dbColumnType;            //元数据字段类型
    private String desc;                    //元数据字段描述
    private Boolean isPrimaryKey;           //是否是主外键
    private Long creator;                   //记录创建人，insert记录时必须添加
    private Long modifier;                  //记录修改人，update记录时必须更新
    private Integer size;                   //字段长度
    @Deprecated
    @JsonIgnore
    private Integer m;                      //decimal 左边长度
    @JsonIgnore
    @Deprecated
    private Integer d;                      //decimal 右边长度
    private Boolean isNullAble;             //是否允许为null
    private String defaultValue;            //默认值
    private Boolean physicalOnly;           //仅物理

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTm;         //** 记录创建时间，create_tm insert记录时必须添加 */

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime modifyTm;         //modify_tm记录修改时间，update记录时必须更新

    private String tblName;        //源表名
    private String bizDesc;        //业务描述
    private String colSrc;         //字段来源
    private Boolean isPartitionKey;//是否分区字段
    private String note;           //字段备注信息

    public static Optional<MdsColumnDTO> of(MdsColumn from) {
        if (null == from) {
            return Optional.empty();
        }
        MdsColumnDTO to = new MdsColumnDTO();
        BeanUtils.copyProperties(from, to);
        return Optional.of(to);
    }

    public static MdsColumn of(MdsColumnDTO from) {
        if (from == null) return null;
        MdsColumn to = new MdsColumn();
        BeanUtils.copyProperties(from, to);
        return to;
    }
}
