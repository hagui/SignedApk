package fr.a2305.signedapk.exception;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */
public class AgentNotFoundException extends RuntimeException{
    public AgentNotFoundException(String agentNotSupported) {
        super(agentNotSupported);
    }
}
