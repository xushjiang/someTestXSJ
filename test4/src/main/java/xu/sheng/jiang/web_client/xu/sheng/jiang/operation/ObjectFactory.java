
package xu.sheng.jiang.web_client.xu.sheng.jiang.operation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xu.sheng.jiang.operation package. 
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

    private final static QName _DifferentFromMethodName_QNAME = new QName("http://operation.jiang.sheng.xu/", "differentFromMethodName");
    private final static QName _DifferentFromMethodNameResponse_QNAME = new QName("http://operation.jiang.sheng.xu/", "differentFromMethodNameResponse");
    private final static QName _Exception_QNAME = new QName("http://operation.jiang.sheng.xu/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xu.sheng.jiang.operation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link DifferentFromMethodNameResponse }
     * 
     */
    public DifferentFromMethodNameResponse createDifferentFromMethodNameResponse() {
        return new DifferentFromMethodNameResponse();
    }

    /**
     * Create an instance of {@link DifferentFromMethodName }
     * 
     */
    public DifferentFromMethodName createDifferentFromMethodName() {
        return new DifferentFromMethodName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DifferentFromMethodName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://operation.jiang.sheng.xu/", name = "differentFromMethodName")
    public JAXBElement<DifferentFromMethodName> createDifferentFromMethodName(DifferentFromMethodName value) {
        return new JAXBElement<DifferentFromMethodName>(_DifferentFromMethodName_QNAME, DifferentFromMethodName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DifferentFromMethodNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://operation.jiang.sheng.xu/", name = "differentFromMethodNameResponse")
    public JAXBElement<DifferentFromMethodNameResponse> createDifferentFromMethodNameResponse(DifferentFromMethodNameResponse value) {
        return new JAXBElement<DifferentFromMethodNameResponse>(_DifferentFromMethodNameResponse_QNAME, DifferentFromMethodNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://operation.jiang.sheng.xu/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
