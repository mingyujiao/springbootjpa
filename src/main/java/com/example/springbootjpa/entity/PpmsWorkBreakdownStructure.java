package com.example.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Jmy
 * @date 2019/6/7 1:16
 * @email jiaomingyu5778@gmail.com
 */
@Data
@Entity(name="ppms_work_breakdown_structure")
public class PpmsWorkBreakdownStructure implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "sid",length = 35)
    private Long sid;

    @Column(name = "layer", length = 2)
    private Integer layer;

    @Column(name = "parent_node_guid", length = 35)
    private Long parentNodeGuid;

    @Column(name = "remark", length = 200)
    private String remark;

    @Column(name = "pbs_code", length = 200)
    private String pbsCode;

    @Column(name = "pbs_name", length = 200)
    private String pbsName;
}
