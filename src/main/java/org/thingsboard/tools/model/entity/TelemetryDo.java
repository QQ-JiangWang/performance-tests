package org.thingsboard.tools.model.entity;

import jnr.ffi.annotations.In;
import lombok.Data;

/**
 * @title: TelemetryDo
 * @Author JiangWang
 * @Date: 2022/1/5 17:02
 * @Version 1.0
 */
@Data
public class TelemetryDo {
    private String sn;
    private Long ts;
    private Integer si;
    private Integer rs;
    private Integer te;
    private Integer mo;
    private String bt;
    private String ch;
    private String gs;
}
