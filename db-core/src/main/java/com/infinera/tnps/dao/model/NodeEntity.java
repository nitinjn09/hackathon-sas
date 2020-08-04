package com.infinera.tnps.dao.model;

import com.infinera.tnps.common.model.Node;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "node")
public class NodeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;


    protected NodeEntity() {
    }

    public NodeEntity(String name) {
        this.name = name;
    }

    public NodeEntity(Node node) {
        this.name = node.getName();
    }

    @Override
    public String toString() {
        return String.format("Node[Name='%s']", name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}