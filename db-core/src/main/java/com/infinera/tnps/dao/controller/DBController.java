package com.infinera.tnps.dao.controller;


import com.infinera.tnps.common.message.TopologyObjectsMessage;
import com.infinera.tnps.common.messagehandler.UploadFileRequestReceiverChannel;
import com.infinera.tnps.common.model.Node;
import com.infinera.tnps.common.messagehandler.MessageQueueDescriptor;
import com.infinera.tnps.common.messagehandler.RequestReceiverChannel;
import com.infinera.tnps.common.model.PhysicalLinkBundle;
import com.infinera.tnps.common.model.UploadFileDataObject;
import com.infinera.tnps.dao.model.FileEntity;
import com.infinera.tnps.dao.model.NodeEntity;
import com.infinera.tnps.dao.model.PhysicalLinkBundleEntity;
import com.infinera.tnps.dao.repository.NodeRepository;
import com.infinera.tnps.dao.repository.PhysicalLinkBundleRepository;
import com.infinera.tnps.dao.repository.UploadFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

@RestController
public class DBController {

    @Autowired
    NodeRepository nodeRepository;

    @Autowired
    PhysicalLinkBundleRepository physicalLinkRepository;

    @Autowired
    UploadFileRepository uploadFileRepository;

    private Logger LOG = LoggerFactory.getLogger(DBController.class);

    //GenericMessageConverter messageConverter = new GenericMessageConverter<>();

//    public DBController()
//    {
//        messageConverter.addParserClass(TopologyObjectsMessage.class, new TopologyObjectParser());
//    }


//    @StreamListener(RequestReceiverChannel.requestReceiver)
//    public void processPathQueryRequest(@Payload byte[] messageData,
//                                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
//                                        @Header(KafkaHeaders.OFFSET) long offest,
//                                        @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment)
//            throws Throwable
//    {
//        acknowledgment.acknowledge();
//        //logger.error("PRODUCER: REQUEST EVENT RECEIVED");
//        MessageQueueDescriptor queDetails = new MessageQueueDescriptor(topic, partition, offest);
//
//        if(messageConverter.supports(TopologyObjectsMessage.class))
//        {
//            messageConverter.convertFromInternal()
//        }
//        ByteArrayInputStream bis = new ByteArrayInputStream(messageData);
//        ObjectInput in = new ObjectInputStream(bis);
//        Object inObject = in.readObject();
//        List<Object> TopologyObejcts = (List<Object>)inObject;
//        procesTopologyObjectsEvent(TopologyObejcts);
//    }



    @StreamListener(RequestReceiverChannel.requestReceiver)
    public void processPathQueryRequest(@Payload byte[] messageData,
                                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                                        @Header(KafkaHeaders.OFFSET) long offest,
                                        @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment)
            throws Throwable
    {
        LOG.debug("Topology Request Received!");
        acknowledgment.acknowledge();
        //logger.error("PRODUCER: REQUEST EVENT RECEIVED");
        MessageQueueDescriptor queDetails = new MessageQueueDescriptor(topic, partition, offest);
        ByteArrayInputStream bis = new ByteArrayInputStream(messageData);
        ObjectInput in = new ObjectInputStream(bis);
        Object inObject = in.readObject();
        TopologyObjectsMessage topologyMessageObejct = (TopologyObjectsMessage)inObject;
        procesTopologyObjectsEvent(topologyMessageObejct);
        LOG.debug("Topology Request Processed!");
    }

    private void procesTopologyObjectsEvent(TopologyObjectsMessage topologyMessageObejct)
            throws Throwable {


        for (Node node : topologyMessageObejct.getNodes()) {
            nodeRepository.save(new NodeEntity(node));
        }

        for (PhysicalLinkBundle physicalLinkBundle : topologyMessageObejct.getPhysicalLinkBundles()) {
            physicalLinkRepository.save(new PhysicalLinkBundleEntity(physicalLinkBundle));
        }
    }

    @StreamListener(UploadFileRequestReceiverChannel.UploadFileRequestReceiver)
    public void processPathQueryRequest(@Payload byte[] messageData,
                                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                        @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment)
            throws Throwable {
        acknowledgment.acknowledge();
        ByteArrayInputStream bis = new ByteArrayInputStream(messageData);
        ObjectInput in = new ObjectInputStream(bis);
        Object inObject = in.readObject();
        UploadFileDataObject uploadFileDataObject = (UploadFileDataObject) inObject;
        procesUploadFileEvent(uploadFileDataObject);
    }

    private void procesUploadFileEvent(UploadFileDataObject uploadFileDataObject) {
        uploadFileRepository.save(new FileEntity(uploadFileDataObject));
    }

}

//    @GetMapping("/getdata")
//    public String getData() throws IOException {
//        nodeRepository.save(new Node("N1"));
//
//
//        return "done";
//    }



