package com.seaboxdata.model;

import com.seaboxdata.dto.MdsHistoryObjectIdDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Optional;

/**
 * MdsHistoryObject 复合ID
 *
 * @author hualong
 */
@Data
@Getter
@Builder
@AllArgsConstructor
public class MdsHistoryObjectId implements Serializable {
    final Long id;
    final Long version;

    /**
     * DTO Util
     *
     * @param from
     * @return
     */
    public static Optional<MdsHistoryObjectIdDTO> of(MdsHistoryObjectId from) {
        if (null == from) {
            return Optional.empty();
        }
        MdsHistoryObjectIdDTO to = new MdsHistoryObjectIdDTO(from.getId(), from.getVersion());
        return Optional.of(to);
    }
}
