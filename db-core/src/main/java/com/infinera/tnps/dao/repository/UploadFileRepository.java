package com.infinera.tnps.dao.repository;

import com.infinera.tnps.dao.model.FileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UploadFileRepository extends CrudRepository<FileEntity, Long> {
}
