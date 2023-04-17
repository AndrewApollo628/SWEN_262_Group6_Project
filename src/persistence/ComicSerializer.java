package persistence;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import comic.Comic;
import comic.ComicDec;
import comic.ConcreteComic;
import comic.GradedComic;
import comic.SlabbedComic;

public class ComicSerializer extends JsonSerializer<Comic> {

    @Override
    public void serialize(Comic value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // if comic is instanceof comicdec then add just the regular comic fields

        gen.writeStartObject();
        if (value instanceof ComicDec) {

            if (value instanceof GradedComic) {
                gen.writeNumberField("grade", ((GradedComic) value).getGrade());
            } else if (((comic.ComicDec)value).getComic() instanceof GradedComic) {
                gen.writeNumberField("grade", ((GradedComic) ((ComicDec) value).getComic()).getGrade());
            }
            if (value instanceof SlabbedComic) {
                gen.writeBooleanField("slabbed", true);
            } else if (((comic.ComicDec)value).getComic() instanceof SlabbedComic) {
                gen.writeBooleanField("slabbed", true);
            }

            if (((comic.ComicDec)value).getComic() instanceof ConcreteComic) {
                gen.writeStringField("Series", ((ComicDec) value).getComic().getSeries());
                gen.writeNumberField("Issue", ((ComicDec) value).getComic().getIssue());
                gen.writeStringField("Full Title", ((ComicDec) value).getComic().getFullTitle());
                gen.writeStringField("Variant Description", ((ComicDec) value).getComic().getVariantDescription());
                gen.writeStringField("Publisher", ((ComicDec) value).getComic().getPublisher());
                gen.writeStringField("Release Date", ((ComicDec) value).getComic().getPublicationDate());
                gen.writeStringField("Format", ((ComicDec) value).getComic().getFormat());
                gen.writeStringField("Added Date", ((ComicDec) value).getComic().getAddedDate());
                gen.writeStringField("Creator", String.join(" | ", ((ComicDec) value).getComic().getCreator()));
                gen.writeNumberField("Value", ((ComicDec) value).getComic().getValue());
            }

        } 
        if (value instanceof Comic){
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
        }
        gen.writeEndObject();

    }

}
