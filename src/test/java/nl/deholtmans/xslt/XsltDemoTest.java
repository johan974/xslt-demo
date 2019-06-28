package nl.deholtmans.xslt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class XsltDemoTest {
    @Test
    public void testBasic() {
        String input = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<catalog>\n" +
                "    <cd>\n" +
                "        <title>Empire Burlesque</title>\n" +
                "        <artist>Bob Dylan</artist>\n" +
                "        <country>USA</country>\n" +
                "        <company>Columbia</company>\n" +
                "        <price>10.90</price>\n" +
                "        <year>1985</year>\n" +
                "    </cd>\n" +
                "    <cd>\n" +
                "        <title>Hide your heart</title>\n" +
                "        <artist>Bonnie Tyler</artist>\n" +
                "        <country>UK</country>\n" +
                "        <company>CBS Records</company>\n" +
                "        <price>9.90</price>\n" +
                "        <year>1988</year>\n" +
                "    </cd>\n" +
                "</catalog>";

        String xslt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "    <xsl:template match=\"/\">\n" +
                "        <html>\n" +
                "            <body>\n" +
                "                <h2>My CD Collection</h2>\n" +
                "                <table border=\"1\">\n" +
                "                    <tr bgcolor=\"#9acd32\">\n" +
                "                        <th style=\"text-align:left\">Title</th>\n" +
                "                        <th style=\"text-align:left\">Artist</th>\n" +
                "                    </tr>\n" +
                "                    <xsl:for-each select=\"catalog/cd\">\n" +
                "                        <tr>\n" +
                "                            <td><xsl:value-of select=\"title\"/></td>\n" +
                "                            <td><xsl:value-of select=\"artist\"/></td>\n" +
                "                        </tr>\n" +
                "                    </xsl:for-each>\n" +
                "                </table>\n" +
                "            </body>\n" +
                "        </html>\n" +
                "    </xsl:template>\n" +
                "</xsl:stylesheet>";
        XsltDemo xsltDemo = new XsltDemo();
        String output = xsltDemo.transformInputViaXslt( input, xslt);
        assertTrue(output.contains( "<td>Empire Burlesque</td><td>Bob Dylan</td>") );
        System.out.println( "OUt: " + output);
    }
}