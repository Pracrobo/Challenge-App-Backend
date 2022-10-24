package com.whale.challenge.module.security;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;

import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

public class HtmlCharacterEscapes extends CharacterEscapes {

	private final int[] asciiEscapes;

	public HtmlCharacterEscapes() {
		// XSS 방지 처리할 특수 문자 지정
		asciiEscapes = standardAsciiEscapesForJSON();
		asciiEscapes['<'] = ESCAPE_CUSTOM;
		asciiEscapes['>'] = ESCAPE_CUSTOM;
		asciiEscapes['\"'] = ESCAPE_CUSTOM;
		asciiEscapes['('] = ESCAPE_CUSTOM;
		asciiEscapes[')'] = ESCAPE_CUSTOM;
		asciiEscapes['#'] = ESCAPE_CUSTOM;
		asciiEscapes['\''] = ESCAPE_CUSTOM;
	}

	@Override
	public int[] getEscapeCodesForAscii() {
		return asciiEscapes;
	}

	@Override
	public SerializableString getEscapeSequence(int ch) {
		return new SerializedString(escapeHtml4(Character.toString((char) ch)));
	}
}
