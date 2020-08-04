package com.infinera.tnps.dao.model;

import com.infinera.tnps.common.model.UploadFileDataObject;

import javax.persistence.*;

@Entity
@Table(name = "tnpsfiledata")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "data")
    @Lob
    private byte[] data;

    public FileEntity() {

    }

    public FileEntity(UploadFileDataObject uploadFileDataObject) {
        this.fileName = uploadFileDataObject.getFileName();
        this.data = uploadFileDataObject.getFileContent();
    }

}
