package persistence;


import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import user.User;
import comic.Comic;


public class UserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        
        gen.writeStartObject();
        gen.writeStringField("username", value.getUsername());
        gen.writeStringField("password", value.getPassword());
        gen.writeArrayFieldStart("collection");
        for (Comic comic : value.getCollection().getContents()) {
            gen.writeObject(comic);
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
    
    
}
