package org.example.spring;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.repository.HippoRepository;
import org.hippoecm.repository.HippoRepositoryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a really lightweight repository service.
 */
public class HippoRepositoryService {

    private static Logger log = LoggerFactory.getLogger(HippoRepositoryService.class);

    private volatile HippoRepository repository;
    private String repositoryLocation;
    private String username;
    private String password;

    private Session session = null;

    public HippoRepositoryService(final String repositoryLocation, final String username, final String password) {
        this.repositoryLocation = repositoryLocation;
        this.username = username;
        this.password = password;
    }

    public void destroy() {
        if (session != null && session.isLive()) {
            session.logout();
        }
    }

    public Session getSession() {
        if(repository==null) {
            obtainRepository();
        }
        if(repository!=null) {
            try{
                session = repository.login(username, password.toCharArray());
            } catch (LoginException e) {
                log.debug("Something went wrong: {}",e);
            } catch (RepositoryException e) {
                repository = null;
                log.debug("Something went wrong: {}", e);
            }
        }
        return session;
    }

    private void obtainRepository() {
        try {
            repository = HippoRepositoryFactory.getHippoRepository(repositoryLocation);
        } catch (RepositoryException e) {
            repository = null;
            log.debug("Something went wrong: {}", e);
        }
    }

    @Override
    public String toString() {
        return "HippoRepositoryService{" +
                "repositoryLocation='" + repositoryLocation + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
