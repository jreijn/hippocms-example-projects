package org.example.spring;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.onehippo.cms7.event.HippoEvent;
import org.onehippo.cms7.event.HippoEventConstants;
import org.onehippo.cms7.services.eventbus.Subscribe;
import org.onehippo.repository.events.HippoWorkflowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationEventListener {

    private static Logger log = LoggerFactory.getLogger(PublicationEventListener.class);

    @Autowired
    private HippoRepositoryService repositoryService;

    @Subscribe
    public void handleEvent(HippoEvent event) throws RepositoryException {
        if (HippoEventConstants.CATEGORY_WORKFLOW.equals(event.category())) {
            HippoWorkflowEvent workflowEvent = new HippoWorkflowEvent(event);
            if ("publish".equals(workflowEvent.methodName())) {
                log.debug("document with id: {} was published", workflowEvent.subjectId());

                final Session session = repositoryService.getSession();
                log.debug("Found node with path: {}", session.getNodeByIdentifier(workflowEvent.subjectId()).getPath());
            }
        }
    }

}