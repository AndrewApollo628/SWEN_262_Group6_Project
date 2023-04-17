package persistence;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import comic.*;

public class ComicSerializer extends JsonSerializer<Comic> {

    @Override
    public void serialize(Comic value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        gen = gen.useDefaultPrettyPrinter();
        gen.writeStartObject();
        if (value instanceof ComicDec) {
            ComicDec dec = (ComicDec) value;
            if (dec.isGraded()) {
                gen.writeNumberField("grade", dec.getGrade());
            }
            if (dec.isSlabbed()) {
                gen.writeBooleanField("slabbed", true);
            }
            if (dec.isSigned()) {
                gen.writeStringField("signature", dec.getSignature());
            } 

        } 

        gen.writeStringField("Series", value.getSeries());
        gen.writeNumberField("Issue", value.getIssue());
        gen.writeStringField("Full Title", value.getFullTitle());
        gen.writeStringField("Variant Description", value.getVariantDescription());
        gen.writeStringField("Publisher", value.getPublisher());
        gen.writeStringField("Release Date", value.getPublicationDate());
        gen.writeStringField("Format", value.getFormat());
        gen.writeStringField("Added Date", value.getAddedDate());
        gen.writeStringField("Creator", String.join(" | ", value.getCreator()));
        gen.writeNumberField("Value", value.getValue());
        gen.writeEndObject();

    }

}
