package persistence;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import comic.Comic;
import comic.ConcreteComic;
import comic.GradedComic;
import comic.SignedComic;
import comic.SlabbedComic;

/**
 * Defines the Deserializer for {@linkplain Comic} data persistence
 * 
 * if the json node has a "grade" field, then it is a graded comic
 * if the json node has a "slabbed" field, then it is a slabbed comic
 * 
 * @author aditya
 */
public class ComicDeserializer extends JsonDeserializer<Comic> {

	@Override
	public Comic deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec oc = p.getCodec();
		JsonNode node = oc.readTree(p);

		int ComicValue = 1;
		if (node.has("Value") && node.get("Value").asInt() != 0) {
			ComicValue = node.get("Value").asInt();
		}
		Comic comic = new ConcreteComic (
			node.get("Series").asText(),
			node.get("Issue").asInt(),
			node.get("Full Title").asText(), 
			node.get("Variant Description").asText(), 
			node.get("Publisher").asText(), 
			node.get("Release Date").asText(), 
			node.get("Format").asText(), 
			node.get("Added Date").asText(), 
			node.get("Creator").asText(),
			ComicValue
		);
		int newvalue = ComicValue*comic.getFullTitle().hashCode();
		newvalue = Math.abs(newvalue) % 20 + 1;
		comic.setValue(newvalue);

		if (node.has("grade")) {
			comic = new GradedComic(node.get("grade").asInt(), comic);
		}
		if (node.has("slabbed")) {
			comic = new SlabbedComic(comic);
		}
		if (node.has("signed")) {
			comic = new SignedComic(comic, node.get("signed").asText());
		}
		return comic;
	}
	
}
