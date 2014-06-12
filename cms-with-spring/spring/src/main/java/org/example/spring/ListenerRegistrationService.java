package org.example.spring;

import org.onehippo.cms7.services.HippoServiceRegistry;
import org.onehippo.cms7.services.eventbus.HippoEventBus;
import org.springframework.beans.factory.annotation.Autowired;

public class ListenerRegistrationService {

    @Autowired
    private PublicationEventListener listener;

    public void init() {
        HippoServiceRegistry.registerService(listener, HippoEventBus.class);
    }

    public void destroy() {
        HippoServiceRegistry.unregisterService(listener, HippoEventBus.class);
    }
}