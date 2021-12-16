package com.estoke.core.tec.exception;


import com.estoke.core.tec.message.MessageHolder;

/**
 * @author vitor.alves
 */
public class BusinessException extends BaseException {

    public BusinessException(MessageHolder messageHolder) {
        super(messageHolder);
    }

    public BusinessException(MessageHolder messageHolder, Throwable cause) {
        super(messageHolder, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
