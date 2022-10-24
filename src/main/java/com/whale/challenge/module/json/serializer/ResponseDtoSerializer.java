package com.whale.challenge.module.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.whale.challenge.dto.ResponseDto;

import java.io.IOException;

public class ResponseDtoSerializer extends StdSerializer<ResponseDto> {

	private static final long serialVersionUID = -2434507246334683655L;

    public ResponseDtoSerializer() {
		super(ResponseDto.class);
	}

	@Override
	public void serialize(ResponseDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeFieldName("data");
		provider.defaultSerializeValue(value.getData(), gen);
        gen.writeStringField("code", value.getCode());
        gen.writeStringField("message", value.getMessage());
		gen.writeEndObject();
		
	}
    
}
