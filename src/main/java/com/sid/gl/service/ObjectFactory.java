
package com.sid.gl.service;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sid.gl.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CustomerList_QNAME = new QName("http://service.gl.sid.com/", "customerList");
    private final static QName _CustomerListResponse_QNAME = new QName("http://service.gl.sid.com/", "customerListResponse");
    private final static QName _GetCustomer_QNAME = new QName("http://service.gl.sid.com/", "getCustomer");
    private final static QName _GetCustomerResponse_QNAME = new QName("http://service.gl.sid.com/", "getCustomerResponse");
    private final static QName _SaveCustomer_QNAME = new QName("http://service.gl.sid.com/", "saveCustomer");
    private final static QName _SaveCustomerResponse_QNAME = new QName("http://service.gl.sid.com/", "saveCustomerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sid.gl.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerList }
     * 
     */
    public CustomerList createCustomerList() {
        return new CustomerList();
    }

    /**
     * Create an instance of {@link CustomerListResponse }
     * 
     */
    public CustomerListResponse createCustomerListResponse() {
        return new CustomerListResponse();
    }

    /**
     * Create an instance of {@link GetCustomer }
     * 
     */
    public GetCustomer createGetCustomer() {
        return new GetCustomer();
    }

    /**
     * Create an instance of {@link GetCustomerResponse }
     * 
     */
    public GetCustomerResponse createGetCustomerResponse() {
        return new GetCustomerResponse();
    }

    /**
     * Create an instance of {@link SaveCustomer }
     * 
     */
    public SaveCustomer createSaveCustomer() {
        return new SaveCustomer();
    }

    /**
     * Create an instance of {@link SaveCustomerResponse }
     * 
     */
    public SaveCustomerResponse createSaveCustomerResponse() {
        return new SaveCustomerResponse();
    }

    /**
     * Create an instance of {@link CustomerResponse }
     * 
     */
    public CustomerResponse createCustomerResponse() {
        return new CustomerResponse();
    }

    /**
     * Create an instance of {@link CustomerRequest }
     * 
     */
    public CustomerRequest createCustomerRequest() {
        return new CustomerRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerList }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.gl.sid.com/", name = "customerList")
    public JAXBElement<CustomerList> createCustomerList(CustomerList value) {
        return new JAXBElement<CustomerList>(_CustomerList_QNAME, CustomerList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.gl.sid.com/", name = "customerListResponse")
    public JAXBElement<CustomerListResponse> createCustomerListResponse(CustomerListResponse value) {
        return new JAXBElement<CustomerListResponse>(_CustomerListResponse_QNAME, CustomerListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.gl.sid.com/", name = "getCustomer")
    public JAXBElement<GetCustomer> createGetCustomer(GetCustomer value) {
        return new JAXBElement<GetCustomer>(_GetCustomer_QNAME, GetCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.gl.sid.com/", name = "getCustomerResponse")
    public JAXBElement<GetCustomerResponse> createGetCustomerResponse(GetCustomerResponse value) {
        return new JAXBElement<GetCustomerResponse>(_GetCustomerResponse_QNAME, GetCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.gl.sid.com/", name = "saveCustomer")
    public JAXBElement<SaveCustomer> createSaveCustomer(SaveCustomer value) {
        return new JAXBElement<SaveCustomer>(_SaveCustomer_QNAME, SaveCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.gl.sid.com/", name = "saveCustomerResponse")
    public JAXBElement<SaveCustomerResponse> createSaveCustomerResponse(SaveCustomerResponse value) {
        return new JAXBElement<SaveCustomerResponse>(_SaveCustomerResponse_QNAME, SaveCustomerResponse.class, null, value);
    }

}
