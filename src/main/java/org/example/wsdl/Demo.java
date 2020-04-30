//package org.example.wsdl;
//
//import org.apache.tomcat.util.net.jsse.JSSEUtil;
//import org.ow2.easywsdl.schema.api.*;
//import org.ow2.easywsdl.schema.api.Import;
//import org.ow2.easywsdl.schema.api.Include;
//import org.ow2.easywsdl.schema.api.extensions.NamespaceMapperImpl;
//import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.FormChoice;
//import org.ow2.easywsdl.wsdl.WSDLFactory;
//import org.ow2.easywsdl.wsdl.api.*;
//import org.w3c.dom.Document;
//import org.w3c.dom.TypeInfo;
//
//import javax.xml.namespace.QName;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class Demo {
//    public static void main(String[] args) {
//        try {
//            WSDLReader wsdlReader = WSDLFactory.newInstance().newWSDLReader();
//            try {
//                URL url = new URL("http://localhost:9999/demo?wsdl");
//                Description read = wsdlReader.read(url);
//                Types types = read.getTypes();
//                List<Schema> schemas = types.getSchemas();
//                Iterator<Schema> iterator = schemas.iterator();
//                while(iterator.hasNext()){
//                    Schema schema = (Schema)iterator.next();
//                    List<Type> types1 = schema.getTypes();
//                    System.out.println(types1);
//
//                    List<Import> imports = schema.getImports();
//                    Import anImport = imports.get(0);
//                    Schema schema1 = anImport.getSchema();
//                    List<Type> types2 = schema1.getTypes();
//                    Iterator<Type> iterator1 = types2.iterator();
//                    while(iterator1.hasNext()){
//                        Type next = iterator1.next();
//                        QName qName = next.getQName();
//                        Element element = schema1.getElement(qName);
//                        System.out.println(element);
//                        System.out.println(qName);
//                    }
//                    List<Element> elements = schema1.getElements();
//                    System.out.println("elements:++++++++》》》》》"+elements.size());
//                }
//
//            } catch (URISyntaxException | IOException e) {
//                e.printStackTrace();
//            } catch (XmlException e) {
//                e.printStackTrace();
//            }
//
//
//        } catch (WSDLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
