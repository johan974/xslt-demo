package nl.deholtmans.xslt;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;

public class XsltDemo {
    public static void main(String[] args) throws IOException, URISyntaxException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("transform.xslt"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File("input.xml"));
        transformer.transform(text, new StreamResult(new File("output.xml")));
    }

    public String transformInputViaXslt( String input, String xslt) {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsltSource = new StreamSource( new java.io.StringReader( xslt));
        try {
            Transformer transformer = factory.newTransformer(xsltSource);

            Source text = new StreamSource( new java.io.StringReader(input));

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            transformer.transform(text, result);
            return writer.toString();
        } catch (Exception e) {
            System.out.println( "Cannot perform ");
            return null;
        }
    }
}
