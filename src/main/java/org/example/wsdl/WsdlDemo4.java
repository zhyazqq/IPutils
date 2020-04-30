//package org.example.wsdl;
//
//import org.w3c.dom.*;
//import org.w3c.dom.bootstrap.DOMImplementationRegistry;
//import org.w3c.dom.ls.DOMImplementationLS;
//import org.w3c.dom.ls.LSInput;
//import org.w3c.dom.ls.LSResourceResolver;
//import org.xml.sax.SAXException;
//
//import javax.wsdl.Definition;
//import javax.wsdl.WSDLException;
//import javax.wsdl.extensions.schema.Schema;
//import javax.wsdl.factory.WSDLFactory;
//import javax.wsdl.xml.WSDLReader;
//import javax.xml.XMLConstants;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Result;
//import javax.xml.transform.Source;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.validation.SchemaFactory;
//import javax.xml.validation.TypeInfoProvider;
//import javax.xml.validation.Validator;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class WsdlDemo4 {
//
//    public static void main(String[] args) throws SAXException, WSDLException, ClassNotFoundException, ParserConfigurationException, InstantiationException, IllegalAccessException, IOException {
//        WSDLFactory wsdlFactory    = WSDLFactory.newInstance();
//        WSDLReader reader         = wsdlFactory.newWSDLReader();
//        Definition wsdlDefinition = reader.readWSDL("http://localhost:9999/demo?wsdl");
//        String documentBaseURI = wsdlDefinition.getDocumentBaseURI();
//
//
//
//        ArrayList<Element> wsdlSchemas = new ArrayList<Element>();
//
////        for (Object o : wsdlDefinition.getTypes().getExtensibilityElements()) {
////            if (o instanceof Schema) {
////                wsdlSchemas.add(((Schema) o).getElement());
////            }
////        }
//
//        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//        ArrayList<DOMSource> asrcs   = new ArrayList<DOMSource>();
//
//        for (Element e : wsdlSchemas) {
//            asrcs.add(new DOMSource(e));
//        }
//        DOMSource sources[] = asrcs.toArray(new DOMSource[0]);
//        javax.xml.validation.Schema schema  = factory.newSchema(sources);
//
//        Validator schemaValidator = schema.newValidator();
//
//
//        javax.xml.validation.Schema schema1 = makeSchema(documentBaseURI);
//        Validator validator = schema1.newValidator();
//
////        Validator validator = schema1.newValidator();
////        LSResourceResolver resourceResolver = validator.getResourceResolver();
//
//
//
//    }
//    public static javax.xml.validation.Schema makeSchema(String pathToWsdl)
//            throws ParserConfigurationException, IOException, SAXException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        // read wsdl document
////        File wsdlFile = new File(pathToWsdl);
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        dbFactory.setNamespaceAware(true);
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//
//        Document wsdlDoc = dBuilder.parse(pathToWsdl);
//
//        // read namespace declarations from wsdl document, in case they are referred from a schema
//        NamedNodeMap attributes = wsdlDoc.getDocumentElement().getAttributes();
//        Map<String, String> namespacesFromWsdlDocument = new HashMap<>();
//        for (int i = 0; i < attributes.getLength(); i++) {
//            Node n = attributes.item(i);
//            if (n.getNamespaceURI() != null && n.getNamespaceURI().equals("http://www.w3.org/2000/xmlns/")) {
//                namespacesFromWsdlDocument
//                        .put(n.getLocalName(), n.getNodeValue());
//            }
//        }
//
//        // read the schema nodes from the wsdl
//        NodeList schemas = wsdlDoc.getElementsByTagNameNS("http://www.w3.org/2001/XMLSchema", "schema");
//        Map<String, DOMSource> sources = new HashMap<>();
//        for (int i = 0; i < schemas.getLength(); i++) {
//            // create a document for each schema and copy the source schema
//            Document schema = dBuilder.newDocument();
//            Element schemaElement = (Element)schema.importNode(schemas.item(i), true);
//
//            // add all non-existing namespace declarations from the wsdl node
//            String targetNs = schemaElement.getAttribute("targetNamespace");
//            for (Map.Entry<String, String> ns : namespacesFromWsdlDocument.entrySet()) {
//                String name = ns.getKey();
//                String value = ns.getValue();
//                if (schemaElement.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", name) == null) {
//                    schemaElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + name, value);
//                }
//            }
//
//            // map schemas by their target namespace
//            schema.appendChild(schemaElement);
//            DOMSource domSource = new DOMSource(schema);
//            sources.put(targetNs, domSource);
//        }
//
//        SchemaFactory factory =
//                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//
//        // Create a ResourceResolver that can find the correct schema from the map
//        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
//
//        final DOMImplementationLS domImplementationLS = (DOMImplementationLS) registry.getDOMImplementation("LS");
//        factory.setResourceResolver(new LSResourceResolver() {
//            @Override public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
//                Source xmlSource = sources.get(namespaceURI);
//                System.out.println(xmlSource+"null");
//                if (xmlSource != null) {
//                    LSInput input = domImplementationLS.createLSInput();
//                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                    Result outputTarget = new StreamResult(outputStream);
//                    try {
//                        TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
//                    } catch (TransformerException e) {
//                        e.printStackTrace();
//                    }
//                    InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
//                    input.setByteStream(is);
//                    input.setSystemId(systemId);
//                    return input;
//                } else {
//                    return null;
//                }
//            }
//        });
//
//        // create the schema object from the sources
//        return factory.newSchema(sources.values().toArray(new DOMSource[]{}));
//    }
//}
