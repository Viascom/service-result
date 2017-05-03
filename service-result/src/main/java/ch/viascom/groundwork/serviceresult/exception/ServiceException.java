package ch.viascom.groundwork.serviceresult.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Throwable Wrapper of the ServiceFault.
 */
@NoArgsConstructor
public class ServiceException extends Exception {

    /**
     * Holds the underlying service fault.
     * This exception acts as container for the fault.
     * The data is stored in the fault and not in this exception
     * because of serialization.
     */
    @Setter
    @Getter
    protected ServiceFault fault;

    /**
     * Constructor.
     *
     * @param exceptionCode Technical exception code.
     * @param message       Display text of exception.
     */
    public ServiceException(String exceptionCode, String message) {
        super(message);

        this.fault = new ServiceFault(exceptionCode, message);
    }

    /**
     * Constructor.
     *
     * @param fault Error information.
     */
    public ServiceException(ServiceFault fault) {
        super(fault.getMessage());

        this.fault = fault;
    }

    /**
     * Constructor.
     */
    public ServiceException(String exceptionCode, String message, int responseStatusCode) {
        super(message);

        this.fault = new ServiceFault(exceptionCode, message);
        this.fault.setResponseStatusCode(responseStatusCode);
    }

    /**
     * Sets the exception which caused this service exception.
     * It's important to set this exception to understand
     * and reproduce the error!
     *
     * @param innerException Underlying exception
     */
    public ServiceException setException(Throwable innerException) {
        ByteArrayOutputStream messageOutputStream = new ByteArrayOutputStream();
        innerException.printStackTrace(new PrintStream(messageOutputStream));

        String exceptionMessage = messageOutputStream.toString();

        this.fault.setException(exceptionMessage);

        return this;
    }

    public ServiceException setRequestedType(Class<?> requestedType) {
        this.fault.setRequestedType(requestedType);
        return this;
    }

    public ServiceException setRequestedType(String requestedType){
        this.fault.setRequestedType(requestedType);
        return this;
    }

    public ServiceException setRequestUrl(String requestedUrl) {
        this.fault.setRequestUrl(requestedUrl);
        return this;
    }

    public ServiceException setResponseCode(int code) {
        this.fault.setResponseStatusCode(code);
        return this;
    }

    /**
     * Adds a name-value pair to the request parameter list.
     *
     * @return The exception which is used.
     */
    public ServiceException addRequestParameter(String key, String value) {
        this.fault.addRequestParam(key, value);
        return this;
    }
}