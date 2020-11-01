package cn.ga.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年10月31日 13:11:00
 */
@Data
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
