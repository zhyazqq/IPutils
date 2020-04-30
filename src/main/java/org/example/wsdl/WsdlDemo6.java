package org.example.wsdl;



import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;

import java.io.IOException;

public class WsdlDemo6 {
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:9999/demo?wsdl";
        WsdlProject wsdlProject = new WsdlProject();
        WsdlInterface[] wsdlInterfaces = WsdlImporter.importWsdl(wsdlProject, url);

    }
}
