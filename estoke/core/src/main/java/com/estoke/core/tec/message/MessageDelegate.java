package com.estoke.core.tec.message;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * A simple message delegate that creates {@link MessageHolder}, using a resource bundles and formatting the string with an array of arguments.
 *
 * @author vitor.alves
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageDelegate {

    private static final String FAILD_TO_OPEN_RESOURCE = "Filed to find main.resource from bundle: ";

    private static final String NUMBER_OF_ARGS_WRONG = "Number of arguments wrong for key: ";

    /**
     * Creates a simple instance of {@link MessageDelegate}
     *
     * @return {@link MessageDelegate}
     */
    public static MessageDelegate getMessageDelegate() {
        return new MessageDelegate();
    }

    /**
     * Base method for the creation of a {@link MessageHolder}.
     *
     * @param messageCreator a{@link MessageCreator} with the information to create the message within a resource bundle,
     * @param args           Arguments to be used in the creation of the {@link MessageHolder}.
     * @return a {@link MessageHolder}
     */
    public MessageHolder createMessageHolder(MessageCreator messageCreator, Object[] args) {
        return this.createMessageHolder(messageCreator.getBundle(), messageCreator.getKey(), messageCreator.getNumArgs(), args);
    }


    /**
     * An auxiliary method to stream line the creation of a {@link MessageHolder}.
     *
     * @param bundle  The name of a resource bundle.
     * @param key     the key of a message in the resource bundle
     * @param numArgs the number of expected arguments in the message.
     * @param args    the arguments to be substituted in the message.
     * @return A base implementation of {@link MessageHolder}.
     */
    private MessageHolder createMessageHolder(String bundle, String key, int numArgs, Object[] args) {
        ClassLoader classLoader = Thread.currentThread().getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = MessageDelegate.this.getClass().getClassLoader();
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle, Locale.getDefault(), classLoader);
        if (resourceBundle != null) {
            if (args.length != numArgs) {
                return new MessageHolderImpl(NUMBER_OF_ARGS_WRONG + key);
            }
            String string = resourceBundle.getString(key);
            return new MessageHolderImpl(args.length > 0 ? MessageFormat.format(string, this.resolveArgs(args)) : string);
        } else {
            return new MessageHolderImpl(FAILD_TO_OPEN_RESOURCE + bundle);
        }
    }

    /**
     * An auxiliary method to get the string value of the arguments.
     *
     * @param args An array of arguments to be used in the message.
     * @return An array of the string value of the arguments.
     */
    private Object[] resolveArgs(Object[] args) {
        List<String> stringValues = new ArrayList<>();
        for (Object object : args) {
            stringValues.add(String.valueOf(object));
        }
        return stringValues.toArray();
    }

}
