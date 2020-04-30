//package org.example.wsdl;
//
//import org.apache.cxf.Bus;
//import org.apache.cxf.BusFactory;
//import org.apache.cxf.service.model.BindingInfo;
//import org.apache.cxf.service.model.ServiceInfo;
//import org.apache.cxf.wsdl.WSDLHelper;
//import org.apache.cxf.wsdl.service.factory.WSDLBasedServiceConfiguration;
//import org.apache.cxf.wsdl11.WSDLServiceFactory;
//import org.ow2.easywsdl.schema.api.Element;
//import org.ow2.easywsdl.schema.api.Schema;
//import org.ow2.easywsdl.schema.api.Type;
//import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.FormChoice;
//import org.ow2.easywsdl.wsdl.WSDLFactoryImpl;
//import org.ow2.easywsdl.wsdl.api.*;
//
//import javax.xml.namespace.QName;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.List;
//
//public class WsdlDemo1 {
//    public static void main(String[] args) {
//        try {
//
//            WSDLReader wsdlReader = WSDLFactoryImpl.newInstance().newWSDLReader();
//            URL url = new URL("http://localhost:9999/demo?wsdl");
//            Description read = wsdlReader.read(url);
//            List<Binding> bindings = read.getBindings();
//            for (Binding binding : bindings) {
//                List<Service> services = read.getServices();
//
//                    ServiceInfo serviceInfo = new ServiceInfo();
//                BusFactory busFactory = new BusFactory() {
//                    @Override
//                    public Bus createBus() {
//                        return null;
//                    }
//                };
////                WSDLServiceFactory serviceFactory = new WSDLServiceFactory();
//
//                BindingInfo bindingInfo = new BindingInfo(serviceInfo,binding.toString());
//                WSDLBasedServiceConfiguration s = new WSDLBasedServiceConfiguration(bindingInfo);
//                String style = s.getStyle();
//                System.out.println(style);
//                System.out.println(s);
//            }
//            Types types = read.getTypes();
//            List<Schema> schemas = types.getSchemas();
//            for (Schema schema : schemas) {
//                List<Element> elements = schema.getElements();
//                for (Element element : elements) {
//                    QName ref = element.getRef();
//                    System.out.println(ref);
//                    String maxOccurs = element.getMaxOccurs();
//                    System.out.println(maxOccurs);
//                }
//                URI documentURI = schema.getDocumentURI();
//                System.out.println(documentURI);
//            }
//        } catch (WSDLException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
