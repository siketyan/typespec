// Code generated by Microsoft (R) TypeSpec Code Generator.

package payload.multipart;

import io.clientcore.core.annotation.Metadata;
import io.clientcore.core.annotation.ServiceClient;
import io.clientcore.core.http.exception.HttpResponseException;
import io.clientcore.core.http.models.RequestOptions;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.util.binarydata.BinaryData;
import payload.multipart.implementation.FormDataHttpPartsContentTypesImpl;
import payload.multipart.implementation.MultipartFormDataHelper;

/**
 * Initializes a new instance of the synchronous MultiPartClient type.
 */
@ServiceClient(builder = MultiPartClientBuilder.class)
public final class FormDataHttpPartsContentTypeClient {
    @Metadata(generated = true)
    private final FormDataHttpPartsContentTypesImpl serviceClient;

    /**
     * Initializes an instance of FormDataHttpPartsContentTypeClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Metadata(generated = true)
    FormDataHttpPartsContentTypeClient(FormDataHttpPartsContentTypesImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Test content-type: multipart/form-data.
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    @Metadata(generated = true)
    Response<Void> imageJpegContentTypeWithResponse(BinaryData body, RequestOptions requestOptions) {
        // Protocol API requires serialization of parts with content-disposition and data, as operation
        // 'imageJpegContentType' is 'multipart/form-data'
        return this.serviceClient.imageJpegContentTypeWithResponse(body, requestOptions);
    }

    /**
     * Test content-type: multipart/form-data.
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    @Metadata(generated = true)
    Response<Void> requiredContentTypeWithResponse(BinaryData body, RequestOptions requestOptions) {
        // Protocol API requires serialization of parts with content-disposition and data, as operation
        // 'requiredContentType' is 'multipart/form-data'
        return this.serviceClient.requiredContentTypeWithResponse(body, requestOptions);
    }

    /**
     * Test content-type: multipart/form-data for optional content type.
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    @Metadata(generated = true)
    Response<Void> optionalContentTypeWithResponse(BinaryData body, RequestOptions requestOptions) {
        // Protocol API requires serialization of parts with content-disposition and data, as operation
        // 'optionalContentType' is 'multipart/form-data'
        return this.serviceClient.optionalContentTypeWithResponse(body, requestOptions);
    }

    /**
     * Test content-type: multipart/form-data.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Metadata(generated = true)
    public void imageJpegContentType(FileWithHttpPartSpecificContentTypeRequest body) {
        // Generated convenience method for imageJpegContentTypeWithResponse
        RequestOptions requestOptions = new RequestOptions();
        imageJpegContentTypeWithResponse(
            new MultipartFormDataHelper(requestOptions)
                .serializeFileField("profileImage", body.getProfileImage().getContent(),
                    body.getProfileImage().getContentType(), body.getProfileImage().getFilename())
                .end()
                .getRequestBody(),
            requestOptions).getValue();
    }

    /**
     * Test content-type: multipart/form-data.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Metadata(generated = true)
    public void requiredContentType(FileWithHttpPartRequiredContentTypeRequest body) {
        // Generated convenience method for requiredContentTypeWithResponse
        RequestOptions requestOptions = new RequestOptions();
        requiredContentTypeWithResponse(
            new MultipartFormDataHelper(requestOptions)
                .serializeFileField("profileImage", body.getProfileImage().getContent(),
                    body.getProfileImage().getContentType(), body.getProfileImage().getFilename())
                .end()
                .getRequestBody(),
            requestOptions).getValue();
    }

    /**
     * Test content-type: multipart/form-data for optional content type.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Metadata(generated = true)
    public void optionalContentType(FileWithHttpPartOptionalContentTypeRequest body) {
        // Generated convenience method for optionalContentTypeWithResponse
        RequestOptions requestOptions = new RequestOptions();
        optionalContentTypeWithResponse(
            new MultipartFormDataHelper(requestOptions)
                .serializeFileField("profileImage", body.getProfileImage().getContent(),
                    body.getProfileImage().getContentType(), body.getProfileImage().getFilename())
                .end()
                .getRequestBody(),
            requestOptions).getValue();
    }
}
