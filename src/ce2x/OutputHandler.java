
package ce2x;

import java.io.PrintWriter;
import java.util.Stack;

import org.apache.commons.lang.StringEscapeUtils;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * {@link ContentHandler} that delegate methods to the given {@link PrintWriter} hence
 * serializes the XML
 *
 * This class was copied from edi-to-xml by Renat Zubairov,
 * see https://github.com/zubairov/edi-to-xml/blob/master/src/main/java/org/zubairov/edi2xml/OutputHandler.java,
 * and then slightly modified.
 *
 * @author zubairov
 *
 */
public class OutputHandler extends DefaultHandler implements ContentHandler {

    private final PrintWriter out;

    private final Stack<String> namespaces = new Stack<String>();

    public OutputHandler(PrintWriter out) {
        this.out = out;
    }


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (namespaces.isEmpty() || !namespaces.peek().equals(uri)) {
            int ci = qName.indexOf(':');
            if (ci >= 0) {
                String prefix = qName.substring(0, qName.indexOf(':'));
                out.print("<" + qName + " xmlns:" + prefix + "=\"" + uri + "\">");
            } else {
                out.print("<" + qName+ " >");
            }
        } else {
            out.print("<" + qName+ " >");
        }
        namespaces.push(uri);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        out.println("</" + qName + ">");
        namespaces.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String s = new String(ch);
        out.print(StringEscapeUtils.escapeXml(s));
    }

}