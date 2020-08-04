package com.infinera.tnps.dao.model;

import com.infinera.tnps.common.model.PhysicalLinkBundle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "physicallinkbundle")
public class PhysicalLinkBundleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;


    @Column(name="aendnodeid")
    private String aendnodeid;

    @Column(name="zendnodeid")
    private String zendnodeid;


    protected PhysicalLinkBundleEntity() {
    }

    public PhysicalLinkBundleEntity(PhysicalLinkBundle phyLinkBundle) {
        this.name = phyLinkBundle.getName();
        this.aendnodeid = phyLinkBundle.getAendnodeid();
        this.zendnodeid = phyLinkBundle.getZendnodeid();
    }

    @Override
    public String toString() {
        return String.format("Physical Link Bundle [Name='%s']", name);
    }
}