package org.example.server.wsdlTest;

import com.eviware.soapui.model.propertyexpansion.resolvers.EvalPropertyResolver;
import com.ibm.wsdl.AbstractWSDLElement;
import org.w3c.dom.*;

import javax.wsdl.*;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import javax.xml.namespace.QName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test002 {
    public static void main(String[] args) throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader wsdlReader = factory.newWSDLReader();
        Definition definition = wsdlReader.readWSDL("http://localhost:9999/demo?wsdl");
        System.out.println("hahahah");
        String targetNamespace = definition.getTargetNamespace();
        System.out.println(targetNamespace+"00000000000");
        Map allBindings = definition.getAllBindings();
        Set set = allBindings.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            QName next = (QName) iterator.next();

            Binding binding = definition.getBinding(next);
            List bindingOperations = binding.getBindingOperations();
            Iterator iterator1 = bindingOperations.iterator();
            while (iterator1.hasNext()){
                BindingOperation next1 = (BindingOperation)iterator1.next();
                String name = next1.getOperation().getName();
                System.out.println(name);
                System.out.println("--------------");
            }

        }

        AbstractWSDLElement types =(AbstractWSDLElement) definition.getTypes();
        List<ExtensibilityElement> extensibilityElements = types.getExtensibilityElements();
        Iterator<ExtensibilityElement> iterator1 = extensibilityElements.iterator();
        while (iterator1.hasNext()) {

            Schema next = (Schema) iterator1.next();
            Element element = next.getElement();
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                String method=null;
                Node item = childNodes.item(i);
                if(item.getNodeType()==Node.ELEMENT_NODE){
                    org.w3c.dom.Element element1 = (org.w3c.dom.Element)item;
                    NamedNodeMap attributes = element1.getAttributes();
                    int length2 = attributes.getLength();
                    for (int i1 = 0; i1 < length2; i1++) {
                        method = attributes.item(i1).getNodeValue();

                        System.out.println(attributes.item(i1)+"这是啥。。。。。。。。。。");
                        System.out.println(attributes.item(i1).getNodeValue()+"这是啥。。。。。。。。。。");
                    }


                    int length1 = element1.getAttributes().getLength();
                    System.out.println(length1);



                    NodeList childNodes1 = element1.getChildNodes();
                    int length3 = childNodes1.getLength();
                    System.out.println(length3+"二级子节点");

                    int length4 = childNodes1.getLength();
                    System.out.println("*************");
                    for (int i1 = 0; i1 < length4; i1++) {
                        System.out.println("有下一级");
                        Node item1 = childNodes1.item(i1);
                        System.out.println(item1.getNodeName());
                        System.out.println(item1.getNodeType());

                        if(item1.getNodeType()==Node.ELEMENT_NODE){
                            System.out.println("element");
                            Element element2 = (Element)item1;
                            NodeList childNodes2 = element2.getChildNodes();
                            int length5 = childNodes2.getLength();
                            for (int i2 = 0; i2 < length5; i2++) {
                                Node item2 = childNodes2.item(i2);
                                System.out.println(item2.getNodeType());
                                if(item2.getNodeType()==Node.TEXT_NODE){
                                    System.out.println(item2.getNodeValue());
                                }else if(item2.getNodeType()== Node.ELEMENT_NODE){
                                    Element element3 =(Element)item2;
                                    NodeList childNodes3 = element3.getChildNodes();
                                    NamedNodeMap attributes1 = element3.getAttributes();
                                    int length6 = attributes1.getLength();
                                    StringBuffer value=new StringBuffer();
                                    for (int i3 = 0; i3 < length6; i3++) {
                                        Node item3 = attributes1.item(i3);
                                        System.out.println(item3.getNodeName());
                                        System.out.println(item3.getNodeValue());
                                        value=value.append(item3.getNodeName()+":").append(item3.getNodeValue()).append("----");

                                    }
                                    System.out.println(attributes1.getLength());
                                    String nodeName = element3.getNodeName();
                                    System.out.println(nodeName);
                                    System.out.println("还有其他类型-----------------");
                                    System.out.println(childNodes3.getLength());
                                    System.out.println("over");
                                    System.out.println("方法--------------"+method+"-----"+value);
                                }
                            }
                            System.out.println();
                        }
                    }

                }
            }
        }


    }
}
