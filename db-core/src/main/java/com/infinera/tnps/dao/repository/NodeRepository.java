package com.infinera.tnps.dao.repository;

import com.infinera.tnps.dao.model.NodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NodeRepository extends JpaRepository<NodeEntity, Long>
{
}
