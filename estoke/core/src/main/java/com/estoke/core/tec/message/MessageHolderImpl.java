package com.estoke.core.tec.message;

/**
 * A base implantation of a {@link MessageHolder}. It works as a simple pojo that holds a message to be used by the system.
 *
 * @author vitor.alves
 */
public class MessageHolderImpl implements MessageHolder {

    private static final long serialVersionUID = 3372782053728457267L;

    private final String message;

    public MessageHolderImpl(String message) {
        this.message = message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return message;
    }
}
