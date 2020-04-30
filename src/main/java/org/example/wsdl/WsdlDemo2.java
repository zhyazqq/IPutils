//package org.example.wsdl;
//
//import javax.wsdl.Definition;
//import javax.wsdl.Types;
//import javax.wsdl.WSDLException;
//import javax.wsdl.extensions.ExtensionRegistry;
//import javax.wsdl.factory.WSDLFactory;
//import javax.wsdl.xml.WSDLReader;
//import javax.wsdl.xml.WSDLWriter;
//
//public class WsdlDemo2 {
//    public static void main(String[] args) {
//        WSDLFactory wsdlFactory = new WSDLFactory() {
//            @Override
//            public Definition newDefinition() {
//                Definition definition = newDefinition();
//                definition.setDocumentBaseURI("");
//                return null;
//            }
//
//            @Override
//            public WSDLReader newWSDLReader() {
//                return null;
//            }
//
//            @Override
//            public WSDLWriter newWSDLWriter() {
//                WSDLFactory wsdlFactory1 = b
//                return null;
//            }
//
//            @Override
//            public ExtensionRegistry newPopulatedExtensionRegistry() {
//                return null;
//            }
//        };
//        WSDLReader reader = wsdlFactory.newWSDLReader();
//        try {
//            Definition definition = reader.readWSDL("http://localhost:9999/demo?wsdl");
//
//            Types types = definition.getTypes();
//            System.out.println(types);
//        } catch (WSDLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
