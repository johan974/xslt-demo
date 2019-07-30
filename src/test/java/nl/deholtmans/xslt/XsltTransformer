import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;

public class XsltTransformer {
    public static void main(String[] args) throws IOException, URISyntaxException, TransformerException {
//        TransformerFactory factory = TransformerFactory.newInstance();
//        Source xslt = new StreamSource(new File("transform.xslt"));
//        Transformer transformer = factory.newTransformer(xslt);
//        Source text = new StreamSource(new File("input.xml"));
//        transformer.transform(text, new StreamResult(new File("output.xml")));
        XsltTransformer xsltTransformer = new XsltTransformer();
        xsltTransformer.testBasic();
        xsltTransformer.testBasicSelect();
        xsltTransformer.testBasicForEach();
        xsltTransformer.testBasicForEachAndSorting();
        xsltTransformer.testBasicTestIf();
        xsltTransformer.testBasicTestChoose();
    }

    public String transformInputViaXslt(String input, String xslt) {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsltSource = new StreamSource(new java.io.StringReader(xslt));
        try {
            Transformer transformer = factory.newTransformer(xsltSource);

            Source text = new StreamSource(new java.io.StringReader(input));

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            transformer.transform(text, result);
            return writer.toString();
        } catch (Exception e) {
            System.out.println("Cannot perform ");
            return null;
        }
    }

    private void testBasic() {
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
        String output = transformInputViaXslt(input, xslt);
        if (!output.contains("<td>Hide your heart</td><td>Bonnie Tyler</td>")) {
            System.out.println("Error: output contains: " + output);
        }
    }

    private void testBasicSelect() {
        String input = "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "<?xml-stylesheet type=\"text/xsl\" href=\"tutorials.xsl\"?>\n" +
                "<tutorials>\n" +
                "<tutorial>\n" +
                "<name>XML Tutorial</name>\n" +
                "<url>https://www.quackit.com/xml/tutorial</url>\n" +
                "</tutorial>\n" +
                "<tutorial>\n" +
                "<name>HTML Tutorial</name>\n" +
                "<url>https://www.quackit.com/html/tutorial</url>\n" +
                "</tutorial>\n" +
                "</tutorials>";

        String xslt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "   <xsl:template match=\"/\">\n" +
                "  (other content/HTML markup goes here)\n" +
                "  <xsl:apply-templates/>\n" +
                "</xsl:template>\n" +
                "<xsl:template match=\"tutorial\">\n" +
                "  <xsl:value-of select=\"name\"/>\n" +
                "  <xsl:value-of select=\"url\"/>\n" +
                "</xsl:template>" +
                "</xsl:stylesheet>";
        String output = transformInputViaXslt(input, xslt);
        if (!output.contains("HTML Tutorialhttps://www.quackit.com/html/tutorial")) {
            System.out.println("Error: output contains: " + output);
        }
    }

    private void testBasicForEach() {
        String input = "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "<?xml-stylesheet type=\"text/xsl\" href=\"tutorials.xsl\"?>\n" +
                "<tutorials>\n" +
                "<tutorial>\n" +
                "<name>XML Tutorial</name>\n" +
                "<url>https://www.quackit.com/xml/tutorial</url>\n" +
                "</tutorial>\n" +
                "<tutorial>\n" +
                "<name>HTML Tutorial</name>\n" +
                "<url>https://www.quackit.com/html/tutorial</url>\n" +
                "</tutorial>\n" +
                "</tutorials>";

        String xslt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "<xsl:template match=\"tutorial\">\n" +
                "    <xsl:for-each select=\"name\">\n" +
                "      <xsl:value-of select=\".\"/><xsl:element name=\"br\"/>\n" +
                "    </xsl:for-each>\n" +
                "  </xsl:template>\n" +
                "</xsl:stylesheet>";
        String output = transformInputViaXslt(input, xslt);
        if (!output.contains("HTML Tutorial<br/>")) {
            System.out.println("Error: output contains: " + output);
        }
    }

    private void testBasicForEachAndSorting() {
        String input = "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "<?xml-stylesheet type=\"text/xsl\" href=\"tutorials.xsl\"?>\n" +
                "<tutorials>\n" +
                "<tutorial>\n" +
                "<name>XML Tutorial</name>\n" +
                "<url>https://www.quackit.com/xml/tutorial</url>\n" +
                "</tutorial>\n" +
                "<tutorial>\n" +
                "<name>HTML Tutorial</name>\n" +
                "<url>https://www.quackit.com/html/tutorial</url>\n" +
                "</tutorial>\n" +
                "</tutorials>";

        String xslt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "<xsl:template match=\"tutorial\">\n" +
                "    <xsl:for-each select=\"name\">\n" +
                "      <xsl:sort select=\"name\"/>\n" +
                "      <xsl:value-of select=\".\"/><xsl:element name=\"br\"/>\n" +
                "    </xsl:for-each>\n" +
                "  </xsl:template>\n" +
                "</xsl:stylesheet>";
        String output = transformInputViaXslt(input, xslt);
        if (!output.contains("HTML Tutorial<br/>")) {
            System.out.println("Error: output contains: " + output);
        }
    }

    private void testBasicTestIf() {
        String input = "<?xml version=\"1.0\"?>\n" +
                "<food_list>\n" +
                "  <food_item type=\"vegetable\">\n" +
                "    <name>Agar</name>\n" +
                "    <carbs_per_serving>81</carbs_per_serving>\n" +
                "    <fiber_per_serving>8</fiber_per_serving>\n" +
                "    <fat_per_serving>0.5</fat_per_serving>\n" +
                "    <kj_per_serving>1280</kj_per_serving>\n" +
                "  </food_item>\n" +
                "  <food_item type=\"vegetable\">\n" +
                "    <name>Asparagus</name>\n" +
                "    <carbs_per_serving>1</carbs_per_serving>\n" +
                "    <fiber_per_serving>1</fiber_per_serving>\n" +
                "    <fat_per_serving>0</fat_per_serving>\n" +
                "    <kj_per_serving>40</kj_per_serving>\n" +
                "  </food_item>\n" +
                "</food_list>";

        String xslt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "<xsl:template match=\"/\">\n" +
                "  <xsl:apply-templates/>\n" +
                "</xsl:template>\n" +
                "\n" +
                "<xsl:template match=\"food_list\">\n" +
                "  <table>\n" +
                "    <tr style=\"background-color:#ccff00\">\n" +
                "      <th>Food Item</th>\n" +
                "      <th>Carbs (g)</th>\n" +
                "      <th>Fiber (g)</th>\n" +
                "      <th>Fat (g)</th>\n" +
                "      <th>Energy (kj)</th>\n" +
                "    </tr>\n" +
                "    <xsl:for-each select=\"food_item\">\n" +
                "      <xsl:if test=\"@type = 'vegetable'\">\n" +
                "        <tr style=\"background-color:#00cc00\">\n" +
                "          <td><xsl:value-of select=\"name\"/></td>\n" +
                "          <td><xsl:value-of select=\"carbs_per_serving\"/></td>\n" +
                "          <td><xsl:value-of select=\"fiber_per_serving\"/></td>\n" +
                "          <td><xsl:value-of select=\"fat_per_serving\"/></td>\n" +
                "          <td><xsl:value-of select=\"kj_per_serving\"/></td>\n" +
                "       </tr>\n" +
                "      </xsl:if>\n" +
                "    </xsl:for-each>\n" +
                "  </table>\n" +
                "</xsl:template>" +
                "</xsl:stylesheet>";
        String output = transformInputViaXslt(input, xslt);
        if (!output.contains("HTML Tutorial<br/>")) {
            System.out.println("Error: output contains: " + output);
        }
    }

    private void testBasicTestChoose() {
        String input = "<?xml version=\"1.0\"?>\n" +
                "<food_list>\n" +
                "  <food_item type=\"vegetable\">\n" +
                "    <name>Agar</name>\n" +
                "    <carbs_per_serving>81</carbs_per_serving>\n" +
                "    <fiber_per_serving>8</fiber_per_serving>\n" +
                "    <fat_per_serving>0.5</fat_per_serving>\n" +
                "    <kj_per_serving>1280</kj_per_serving>\n" +
                "  </food_item>\n" +
                "  <food_item type=\"vegetable\">\n" +
                "    <name>Asparagus</name>\n" +
                "    <carbs_per_serving>1</carbs_per_serving>\n" +
                "    <fiber_per_serving>1</fiber_per_serving>\n" +
                "    <fat_per_serving>0</fat_per_serving>\n" +
                "    <kj_per_serving>40</kj_per_serving>\n" +
                "  </food_item>\n" +
                "</food_list>";

        String xslt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "<xsl:template match=\"/\">\n" +
                "  <xsl:apply-templates/>\n" +
                "</xsl:template>\n" +
                "\n" +
                "<xsl:template match=\"food_list\">\n" +
                "  <table>\n" +
                "    <tr style=\"background-color:#ccff00\">\n" +
                "      <th>Food Item</th>\n" +
                "      <th>Carbs (g)</th>\n" +
                "      <th>Fiber (g)</th>\n" +
                "      <th>Fat (g)</th>\n" +
                "      <th>Energy (kj)</th>\n" +
                "    </tr>\n" +
                "    <xsl:for-each select=\"food_item\">\n" +
                "      <xsl:choose>\n" +
                "        <xsl:when test=\"@type = 'grain'\">\n" +
                "          <tr style=\"background-color:#cccc00\">\n" +
                "            <td><xsl:value-of select=\"name\"/></td>\n" +
                "            <td><xsl:value-of select=\"carbs_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"fiber_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"fat_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"kj_per_serving\"/></td>\n" +
                "          </tr>\n" +
                "        </xsl:when>\n" +
                "        <xsl:when test=\"@type = 'vegetable'\">\n" +
                "          <tr style=\"background-color:#00cc00\">\n" +
                "            <td><xsl:value-of select=\"name\"/></td>\n" +
                "            <td><xsl:value-of select=\"carbs_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"fiber_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"fat_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"kj_per_serving\"/></td>\n" +
                "          </tr>\n" +
                "        </xsl:when>\n" +
                "        <xsl:otherwise>\n" +
                "          <tr style=\"background-color:#cccccc\">\n" +
                "            <td><xsl:value-of select=\"name\"/></td>\n" +
                "            <td><xsl:value-of select=\"carbs_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"fiber_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"fat_per_serving\"/></td>\n" +
                "            <td><xsl:value-of select=\"kj_per_serving\"/></td>\n" +
                "          </tr>\n" +
                "        </xsl:otherwise>\n" +
                "      </xsl:choose>\n" +
                "    </xsl:for-each>\n" +
                "  </table>\n" +
                "</xsl:template>" +
                "</xsl:stylesheet>";
        String output = transformInputViaXslt(input, xslt);
        if (!output.contains("HTML Tutorial<br/>")) {
            System.out.println("Error: output contains: " + output);
        }
    }
}
