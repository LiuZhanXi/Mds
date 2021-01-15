package com.seaboxdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MdsHistoryObjectIdDTO implements Serializable {
    private Long id;
    private Long version;
}
