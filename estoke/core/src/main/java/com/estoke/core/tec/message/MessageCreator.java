package com.estoke.core.tec.message;

/**
 * A message creator indicates and provides information on a resource bundle. It than is able to create a simple {@link MessageHolder} that contains a
 * message for the resource bundle, with the specified key.
 *
 * @author vitor.alves
 */
public interface MessageCreator {

    /**
     * Creates a simple {@link MessageHolder}, with a message from a resource bundle with a specified key.
     *
     * @param args an array of arguments to be used in the message.
     * @return a simple {@link MessageHolder}
     */
    MessageHolder create(Object... args);

    /**
     * @return The number of arguments that the massage contains.
     */
    int getNumArgs();

    /**
     * @return The name of a resource bundle.
     */
    String getBundle();

    /**
     * @return the key to the message within the resource bundle.
     */
    String getKey();
}
