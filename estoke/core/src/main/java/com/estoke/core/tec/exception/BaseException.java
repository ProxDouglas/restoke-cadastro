package com.estoke.core.tec.exception;


import com.estoke.core.tec.message.MessageHolder;

/**
 * A base {@link RuntimeException} that accepts a {@link MessageHolder} as parameter.
 *
 * @author vitor.alves
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 6714382345466664741L;

    protected BaseException(MessageHolder messageHolder) {
        super(messageHolder.getMessage());
    }

    protected BaseException(MessageHolder messageHolder, Throwable cause) {
        super(messageHolder.getMessage(), cause);
    }

    protected BaseException(Throwable cause) {
        super(cause);
    }
}
