//package org.example.wsdl;
//
//import javax.wsdl.*;
//import javax.wsdl.extensions.ExtensibilityElement;
//import javax.wsdl.factory.WSDLFactory;
//import javax.wsdl.xml.WSDLReader;
//import javax.xml.namespace.QName;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class WsdlDemo3 {
//    public static void main(String[] args) {
//        String webServiceUrl = "http://localhost:9999/demo";
//        try {
//            WSDLFactory factory = WSDLFactory.newInstance();
//            WSDLReader reader = factory.newWSDLReader();
//            reader.setFeature("javax.wsdl.verbose", true);
//            reader.setFeature("javax.wsdl.importDocuments", true);
//            Definition def = reader.readWSDL(webServiceUrl + "?wsdl");
//
//            String namespaceURI = def.getTargetNamespace();
//            String localPart = webServiceUrl.split("/")[webServiceUrl.split("/").length - 1];
//            if (localPart.contains(".")) {
//                localPart = localPart.split("\\.")[0];
//            }
//            Service service = def.getService(new QName(namespaceURI, localPart));
//            System.out.println(service.getQName().getLocalPart());
//            System.out.println();
//
//            String portStr = "";
//            Map<?, ?> ports = service.getPorts();
//            Iterator<?> itor = ports.entrySet().iterator();
//            while (itor.hasNext()) {
//                Map.Entry<?, ?> map = (Map.Entry<?, ?>) itor.next();
//                Object key = map.getKey();
//                portStr = (key == null ? "" : key.toString());
//                break;
//            }
//            Port port = service.getPort(portStr);
//            Binding binding = port.getBinding();
//            PortType portType = binding.getPortType();
//            List<?> operations = portType.getOperations();
//            Iterator<?> operIter = operations.iterator();
//            while (operIter.hasNext()) {
//                Operation operation = (Operation) operIter.next();
//                if (!operation.isUndefined()) {
//                    System.out.println("方法名称:" + operation.getName());
//
//                }
//            }
//            System.out.println("-----------------------------------------------------");
//            // 解析消息，输入输出
//            System.out.println("nMessages:");
//            Map messages = def.getMessages();
//            Iterator msgIter = messages.values().iterator();
//            while (msgIter.hasNext()) {
//                Message msg = (Message) msgIter.next();
//                if (!msg.isUndefined()) {
//                    System.out.println(msg.getQName().getLocalPart());
//                    Iterator partIter = msg.getParts().values().iterator();
//                    while (partIter.hasNext()) {
//                        Part part = (Part) partIter.next();
//                        System.out.print("parameter name:" + part.getName() + "t");
//                        //System.out.println("parameter type:" + part.getTypeName().getLocalPart());
//                    }
//                }
//            }
//
//            //解析服务地址
//            System.out.println("nService location:");
//            List l=port.getExtensibilityElements();
//            ExtensibilityElement element=(ExtensibilityElement) l.get(0);
//            String s=element.toString();
//            System.out.println(s.substring(s.indexOf("location")));
//            System.out.println("---------");
//
//        } catch (WSDLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//}
//
//
