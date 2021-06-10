package org.kie.kogito.jobmanagement.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JobManagementExceptionMapper  implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {
        e.printStackTrace();
        if (e instanceof IllegalArgumentException) {
            return Response.status(Response.Status.CONFLICT.getStatusCode(), e.getMessage()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
        }
    }
}
