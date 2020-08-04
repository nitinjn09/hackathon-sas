package com.infinera.tnps.dao.controller;

import com.infinera.tnps.common.model.Node;
import com.infinera.tnps.dao.application.SpringBootDBApp;
import com.infinera.tnps.dao.model.NodeEntity;
import com.infinera.tnps.dao.repository.NodeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringBootTest(classes = SpringBootDBApp.class)
@RunWith(SpringRunner.class)
@AutoConfigurationPackage
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("it")
public class NodeRepositoryIT {

    @Autowired
    NodeRepository nodeRepository;

    @Test
    public void shouldSaveAndLoadNodeIT() {

        NodeEntity nodeEntity = new NodeEntity(new Node("ITNode"));
        nodeRepository.save(nodeEntity);

        NodeEntity returnedNodeEntity = nodeRepository.findById(nodeEntity.getId()).get();

        assertEquals("ITNode", returnedNodeEntity.getName());
    }
}
