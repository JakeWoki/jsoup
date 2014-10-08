package org.jsoup.nodes;

import java.io.IOException;

import org.jsoup.helper.StringUtil;

/**
 * A {@code <!DOCTYPE>} node.
 */
public class DocumentType extends Node {
    // todo: quirk mode from publicId and systemId

    /**
     * Create a new doctype element.
     * @param name the doctype's name
     * @param publicId the doctype's public ID
     * @param systemId the doctype's system ID
     * @param baseUri the doctype's base URI
     */
    public DocumentType(String name, String publicId, String systemId, String baseUri) {
        super(baseUri);

        attr("name", name);
        attr("publicId", publicId);
        attr("systemId", systemId);
    }

    @Override
    public String nodeName() {
        return "#doctype";
    }

    @Override
    void outerHtmlHead(Appendable accum, int depth, Document.OutputSettings out) throws IOException {
        accum.append("<!DOCTYPE");
        if (!StringUtil.isBlank(attr("name")))
            accum.append(" ").append(attr("name"));
        if (!StringUtil.isBlank(attr("publicId")))
            accum.append(" PUBLIC \"").append(attr("publicId")).append('"');
        if (!StringUtil.isBlank(attr("systemId")))
            accum.append(" \"").append(attr("systemId")).append('"');
        accum.append('>');
    }

    @Override
    void outerHtmlTail(Appendable accum, int depth, Document.OutputSettings out) {
    }
}
